(ns mochify.hiroba.rest.users "The Foursquare Users API"
  {:author "William Lee (birryree)"}
  (:require [mochify.hiroba.rest :as rest]))

(defn user
  "Returns information for a user.

  Required Parameters:

    * oauth-token (string) - An OAuth2 token for an authenticated user.

  Optional Parameters:

    * user (string) - A user to get. If not supplied, defaults to 'self'.
  "
  ([user oauth-token]
    (rest/get (rest/authenticated-uri "users" user) :query-params {:oauth_token oauth-token}))
  ([oauth-token]
    (user "self" oauth-token)))

(defn leaderboard
  "hits the leaderboard endpoint"
  ([&{:as params}]
    (rest/get (rest/authenticated-uri "users" "leaderboard") :query-params params)))

(defn requests
  "Endpoint for the list of friend requests a user has"
  ([&{:as params}]
    (rest/get (rest/authenticated-uri "users" "requests") :query-params params)))

(defn search
  "Locate friends with a bunch of parameters against the endpoint users/search

   Parameters:

      * :phone seq(string) - a list of phone numbers to search by.
      * :email seq(string) - a list of email addresses to search by.
      * :twitter seq(string) - a list of Twitter handles to search.
      * :twitterSource (string) - a single Twitter handle.
            Will return users that the handle follows on Twitter, who also use
      * :fbid (seq(string)) - A list of Facebook user IDs to search
      * :name (string) - A name to search for
      * :oauth_token (string) - OAuth2 token for the user
  "
  ([& {:as params}]
    (rest/get (rest/authenticated-uri "users" "search") :query-params params))

(defn badges
  "Returns a user's badges"
  ([user &{:as params}]
    (rest/get (rest/authenticated-uri "users" user "badges") :query-params params)))

(defn checkins
  "Returns a history of checkins for a user.

  Parameters:

    * :limit (int) - number of results to return, up to 250 (default 100)
    * :offset (int) - number of results to return, up to 250 (default 100)
    * :sort (string) - sort the returned checkins, valid values are 'newestfirst' or 'oldestfirst' (default 'newestfirst')
    * :afterTimestamp - retrieve the first results that follow this value. The value is seconds after epoch.
    * :beforeTimestamp - retrieve the first results before this epoch time.
  "
  ([& {:as params}]
    (rest/get (rest/authenticated-uri "users" "self" "checkins") :query-params params)))

(defn friends
  "Returns an array of a user's friends

  Parameters:

    * :limit (int) - number of results to return, up to 500
    * :offset (int) - Used to page through results.
  "
  ([user & {:as params}]
    (rest/get (rest/authenticated-uri "users" user "friends") :query-params params)))

(defn lists
  "Returns lists associated with a user.

  Parameters:

    * :group (string) - Can be one of the following, 'created', 'edited', 'followed', 'friends', or 'suggested'
    * :ll (geographic coordinate) - Location of the user. Necessary if you specify :group 'suggested'
  "
  ([user &{:as params}]
    (rest/get (rest/authenticated-uri "users" user "lists") :query-params params))

(defn mayorships
  "Returns a user's mayorships"
  ([user &{:as params}]
    (rest/get (rest/authenticated-uri "users" user "mayorships") :query-params params)))

(defn photos
  "Returns photos a user has uploaded.

  Parameters:

    * :limit (int) - Number of results to return. Default 100, max 500.
    * :offset (int) - Used to page through results. Default 100.
  "
  ([user &{:as params}]
    (rest/get (rest/authenticated-uri "users" user "photos") :query-params params)))

(defn venuehistory
  "Returns a list of venues visited by a user, including count and last visit.

  Parameters:

    * :beforeTimestamp (int) - Seconds since epoch.
    * :afterTimestamp (int) - Seconds after epoch.
    * :categoryId (string) - Limits returned venues to this category. If a top-level category is specified, all sub-categories will match.
  "
  ([user &{:as params}]
    (rest/get (rest/authenticated-uri "users" user "venuehistory") :query-params params)))
