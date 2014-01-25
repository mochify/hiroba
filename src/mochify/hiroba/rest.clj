(ns mochify.hiroba.rest "Clojure Foursquare client"
  {:author "William Lee (birryree)"}
  (:refer-clojure :exclude [get])
  (:require [org.httpkit.client :as http]
            [environ.core :as env]
            [cheshire.core :as json]
            [clojure.string :refer [join]]
            [clj-time.core :refer [now]]
            [clj-time.format :refer [unparse, formatters]])
  (import [java.net URLEncoder]))

(defrecord FoursquareApiEndpoint
  [protocol uri version])

(def ^{:const true} current (unparse (formatters :basic-date) (now)))

(def ^{:const true} slash "/")
(def ^{:const true} encoding "UTF-8")

(defn make-api-endpoint
  ([protocol uri] (FoursquareApiEndpoint. protocol uri nil))
  ([protocol uri version] (FoursquareApiEndpoint. protocol uri version)))

(def ^{:dynamic true} *api-endpoint* (make-api-endpoint "https" "api.foursquare.com" "v2"))

(defn create-uri
  "Creates a URI from a FoursquareApiEndpoint"
  [^FoursquareApiEndpoint endpoint
   & segments]
  (let [protocol (:protocol endpoint)
        uri (:uri endpoint)
        version (:version endpoint)]
    (str protocol "://" uri slash (if version (str version slash)) (join slash (flatten segments)))))

(defn userless-uri
  "Create a URI that does not require an authenticated OAuth2 token.

  Instead, it will read your Foursquare Client ID and Fourquare Client Secret from the environment.
  "
  [& segments]
  (let [date current]
    (str (create-uri *api-endpoint* segments)
         "?" "client_id=" (env/env :foursquare-client-id)
         "&" "client_secret=" (env/env :foursquare-client-secret)
         "&" "v=" current)))

(defn authenticated-uri
  "Create a URI without the client ID or client secret. Most likely, you will have to provide
  the OAuth2 token once you use this URI with the Foursquare API."
  [& segments]
  (let
    [date current]
    (str (create-uri *api-endpoint* segments)
         "?v=" current)))

(defn get
  "Performs an HTTP GET of a URI, with optional query string parameters."
  ([^String uri]
    (io! (json/decode (:body @(http/get uri {:accept :json :throw-exceptions false})) true)))
  ([^String uri &{:as params}]
    (io! (json/decode (:body @(http/get uri params)) true))))
