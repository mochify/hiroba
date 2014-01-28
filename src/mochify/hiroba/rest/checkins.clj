(ns mochify.hiroba.rest.checkins "The Foursquare Checkins API"
  {:author "William Lee (birryree)"}
  (:require [mochify.hiroba.rest :as rest]))


;; POST methods
(defn add
  "Checks you in to a venue.

  Required Parameters:

    * oauth-token - The user's OAuth2 token
    * venueId - The venue to check into.

  Optional Parameters:

    * :eventId
    * :shout - A message about this checkin. Maximum field length is 140 characters.
    * :mentions
    * :broadcast - One of 'private', 'public', 'twitter', 'facebook', 'followers'. Defaults to 'public'.
    * :ll - Latitude and longitude of user.
    * :llAcc - accuracy of the latitude/longitude, in meters.
    * :alt - Altitude of the user's location, in meters.
    * :altAcc - Vertical accuracy of the user's location, in meters.
  "
  ([oauth-token venueId & {:as params}]
    (rest/post (rest/authenticated-uri "checkins" "add") :query-params (merge params {:oauth_token oauth-token :venueId venueId}))))

;; POST Actions
(defn addcomment
  "Adds a comment to a check-in

  Required Parameters:
    * oauth-token - The user's OAuth2 token.
    * checkin-id - The checkin to add the comment into.
    * text - the text of the comment

  Optional Parameters:

    * :mentions
  "
  ([oauth-token checkin-id text & {:as params}]
   (rest/post (rest/authenticated-uri "checkins" checkin-id "addcomment") :query-params (merge params {:oauth_token oauth-token :text text}))))

(defn addpost
  "Post user-generated content from an external app to a check-in. This post will be accessible to anyone
  who can view the details of a check-in.
  "
  ([oauth-token checkin-id & {:as params}]
   (rest/post (rest/authenticated-uri "checkins" checkin-id "addpost") :query-params (merge params {:oauth_token oauth-token}))))

(defn deletecomment
  "Deletes a comment from a checkin, if a provided user owns it."
  ([oauth-token checkin-id comment-id]
   (rest/post (rest/authenticated-uri "checkins" checkin-id "deletecomment") :query-params {:oauth_token oauth-token :commentId comment-id})))

(defn like
  "Likes a checkin."
  ([oauth-token checkin-id like]
   (rest/post (rest/authenticated-uri "checkins" checkin-id "like") :query-params {:oauth_token oauth-token :set like})))

;; GET methods


(defn details
  "Get details of a checkin.

  Parameters:

    * :oauth_token (string) - An Oauth2 token associated with a user.

  Optional Parameters:

    * signature (string) - The signature for a checkin as it appears in feeds like Twitter. This allows
                          access to checkins that are typically only allowed for friends."
  ([checkin-id &{:as params}]
    (rest/get (rest/authenticated-uri "checkins" checkin-id) :query-params params)))

(defn recent
  "Returns a list of recent checkins from friends.

  Required Parameters:

    * :oauth_token (string) - An Oauth2 token associated with a user.

  Optional Parameters:

    * :ll - Latitude and Longitude of a user's location. If provided, the response will include distance.
    * :limit (int) - Number of results to return. Maximum 100, defaults to 20.
    * :afterTimestamp (int) - Seconds after which to look for checkins, e.g.
                    for looking for new checkins since the last fetch. If more than limit results are new since then, this is ignored.
                    Checkins created prior to this timestamp will still be returned if they have new comments or photos, making it easier to poll for all new activity.
  "
  ([&{:as params}]
    (rest/get (rest/authenticated-uri "checkins" "recent") :query-params params)))

(defn likes
  "Returns friends and a total count of users who liked a specific checkin."
  ([checkin-id]
    (rest/get (rest/userless-uri "checkins" checkin-id "likes"))))

