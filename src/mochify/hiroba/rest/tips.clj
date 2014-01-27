(ns mochify.hiroba.rest.tips "The Foursquare Tips API"
  {:author "William Lee (birryree"}
  (:require [mochify.hiroba.rest :as rest]))

(defn likes
  "Returns friends and a total count of users who have liked a tip."
  [tip-id]
  (let [result (rest/get (rest/userless-uri "tips" tip-id "likes"))]
    result))

(defn listed
  "The list that this tip appears on.

  Optional Parameters:

    * :oauth_token (string) - If supplied, allows you to specify additional fields for the 'edited' parameter.
    * :edited (string) - Can be 'created', 'edited', 'followed', 'friends', or 'other'.
                        Only 'other' is supported if the oauth_token is not supplied.
  "
  [tip-id &{:as params}]
  (let [result (rest/get (rest/userless-uri "tips" tip-id "listed"))]
    result))

(defn saved
  "Returns friends and a total count of users who have saved this tip."
  []
  (+ 3 3))
