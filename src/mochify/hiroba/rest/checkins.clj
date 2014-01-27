(ns mochify.hiroba.rest.checkins "The Foursquare Checkins API"
  {:author "William Lee (birryree)"}
  (:require [mochify.hiroba.rest :as rest]))

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
  [&{:as params}]
  (let [result (rest/get (rest/authenticated-uri "checkins" "recent") :query-params params)]
    result))

(defn likes
  "Returns friends and a total count of users who liked a specific checkin."
  [checkin-id]
  (let [result (rest/get (rest/userless-uri "checkins" checkin-id "likes"))]
    result))

