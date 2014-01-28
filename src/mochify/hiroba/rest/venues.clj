(ns mochify.hiroba.rest.venues "The Foursquare Venues API"
  {:author "William Lee (birryree)"}
  (:require [mochify.hiroba.rest :as rest]))

(defn detail
  "Gets details about a venue, including location, mayorship, tags, tips, specials, and category.

  Providing an authenticated user will also give you information about who is currently at the venues.

  If the venue ID given is one that has been merged with a 'master' venu, the response will show data
  about the master venu instead of returning with an error.

  Optional Parameters:

    * :oauth_token (string) - An Oauth2 token for an authenticated user.
        Providing this gives you additional information about who is currently checked in at a venue.
  "
  ([venue-id &{:as params}]
    (rest/get (rest/userless-uri "venues" venue-id))))

(defn categories
  "Returns a hierarchical list of categories applied to venues.

  Foursquare recommends only downloading this list once per session for an application,
  and only caching data for no more than a week."
  ([] (rest/get (rest/userless-uri "venues" "categories")))

(defn trending
  "Returns a list of venues near a specified location with the most people currently checked in.

  Required Parameters:

    * ll (string) - Latitude and longitude of the user's location.

  Optional Parameters:

    * limit (int) - Number of results to return. Default: 10. Maximum: 50.
    * radius (int) - Radius in meters, up to 2000 meters. Default: 100."
  ([&{:as params}]
    (rest/get (rest/userless-uri "venues" "trending") :query-params params)))

(defn events
  "Access information about the current events at a venue. This endpoint currently has minimum information
  distribution and may only be useful for things like concerts and movies.

  Required Parameters:

    * venue-id (string) - The venue to get events for.
  "
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "events"))))


(defn hours
  "Returns hours for a venue.

  Required Parameters:

    * venue-id (string) - The venue ID hours are being requested for.
  "
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "hours"))))

(defn likes
  "Returns friends and a total count of users who have liked this venues.

  Required Parameters:

    * venue-id (string) - The venue ID to get likes for.
  "
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "likes")))


(defn links
  "Returns URLs or identifiers from third parties that have been applied to this venue.

  Required Parameters:

    * venue-id (string) - The venue to get links for."
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "links"))))


(defn listed
  "Gets the lists a venue appears on

  Required Parameters:

    * venue-id - The venue to get lists for.

  Optional Parameters:

    * :oauth_token (string) - A user Oauth token to use. Allows you to use additional values for the :group parameter.
    * :group (string) - Only 'other' is allowed if :oauth_token is not provided. Can be 'created', 'edited', 'followed', 'friends', 'other'.
    * :limit (int) - Number of results to return. Default: 30. Max: 200.
    * :offset (int) - Used to page through results. If specifying this, you must also specify :group
  "
  ([venue-id &{:as params}]
    (rest/get (rest/userless-uri "venues" venue-id "listed"))))

(defn menu
  "Returns menu information for a venue, if available.

  Required Parameters:

    * venue-id (string) - The venue the menu is being requested for.
  "
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "menu"))))

(defn nextvenues
  "Returns venues that people often check into after the specified venue."
  ([venue-id]
    (rest/get (rest/userless-uri "venues" venue-id "nextvenues"))))

(defn photos
  "Returns photos of a venue

  Required Parameters:

    * venue-id (string) - The venue to get photos for.

  Optional Parameters:

    * :group (string) - If not specified, public venue photos are returned, ordered by relevance.
                        'venue' if you want public venue photos, ordered by recency.
                        'checkin' for venue photos from friends (including non-public photos), ordered by recency.
    * :limit (int) - Number of results to return. Default: 100. Max: 200.
    * :offset (int) - Use to page through results in conjunction with :limit.
  "
  ([venue-id &{:as params}]
    (rest/get (rest/userless-uri "venues" venue-id "photos"))))


(defn tips
  "Returns tips for a venue.

  Required Parameters:

    * venue-id (string) - The venue to get tips for.

  Optional Parameters:

    * :sort (string) - One of 'friends', 'recent', or 'popular'
    * :limit (int) - Number of results to return. Max: 500.
    * :offset (int) - Use to page through results with :limit.
  "
  ([venue-id &{:as params}]
    (rest/get (rest/userless-uri "venues" venue-id "tips"))))
