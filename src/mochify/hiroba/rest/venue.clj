(ns mochify.hiroba.rest.venue "The Foursquare Venues API"
  {:author "William Lee (birryree)"}
  (:require [mochify.hiroba.rest :as rest]))

(defn categories
  "Returns a hierarchical list of categories applied to venues.

  Foursquare recommends only downloading this list once per session for an application,
  and only caching data for no more than a week."
  []
  (let [result (rest/get (rest/userless-uri "venues" "categories"))]
    result))
