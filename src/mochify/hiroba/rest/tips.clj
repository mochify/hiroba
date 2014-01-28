(ns mochify.hiroba.rest.tips "The Foursquare Tips API"
  {:author "William Lee (birryree"}
  (:require [mochify.hiroba.rest :as rest]))

(defn details
  "Get the details of a tip, including which users (especially friends) have marked the tip a to-do item.

  Required Parameters:

    * tip-id (string) - ID of the tip to detail.
  "
  ([tip-id]
    (rest/get (rest/userless-uri "tips" tip-id))))


(defn likes
  "Returns friends and a total count of users who have liked a tip."
  [tip-id]
    (rest/get (rest/userless-uri "tips" tip-id "likes")))

(defn listed
  "The list that this tip appears on.

  Optional Parameters:

    * :oauth_token (string) - If supplied, allows you to specify additional fields for the 'edited' parameter.
    * :edited (string) - Can be 'created', 'edited', 'followed', 'friends', or 'other'.
                        Only 'other' is supported if the oauth_token is not supplied.
  "
  ([tip-id &{:as params}]
    (rest/get (rest/userless-uri "tips" tip-id "listed"))))

(defn saves
  "Returns friends and a total count of users who have saved this tip."
  ([tip-id]
    (rest/get (rest/userless-uri "tips" tip-id "saves"))))

