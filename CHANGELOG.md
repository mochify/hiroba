# Changes between Hiroba-0.1.0-SNAPSHOT and 0.1.0-alpha1

## Mostly complete support for [Foursquare Users API](https://developer.foursquare.com/docs/users/users)

The following non-deprecated endpoints are supported from the Users API:

* `/users/USER_ID`
* `/users/leaderboard`
* `/users/requests`
* `/users/search`
* `/users/USER_ID/badges`
* `/users/USER_ID/checkins`
* `/users/USER_ID/friends`
* `/users/USER_ID/lists`
* `/users/USER_ID/mayorships`
* `/users/USER_ID/photos`
* `/users/USER_ID/venuehistory`
* `/users/USER_ID/approve`
* `/users/USER_ID/deny`
* `/users/USER_ID/setpings`
* `/users/USER_ID/unfriend`

The following endpoint is not supported yet:

* `/users/USER_ID/update`

The following will not be supported due to their deprecated status:

* `/users/USER_ID/tips`
* `/users/USER_ID/todos`

## Basic support for [Foursquare Venues API](https://developer.foursquare.com/docs/venues/venues)

The following endpoints are supported from the Venues API:

* `/venues/VENUE_ID`
* `/venues/categories`
* `/venues/trending`
* `/venues/VENUE_ID/events`
* `/venues/VENUE_ID/hours`
* `/venues/VENUE_ID/likes`
* `/venues/VENUE_ID/links`
* `/venues/VENUE_ID/listed`
* `/venues/VENUE_ID/menu`
* `/venues/VENUE_ID/nextvenues`
* `/venues/VENUE_ID/photos`
* `/venues/VENUE_ID/tips`

## Complete support for [Foursquare Checkins API](https://developer.foursquare.com/docs/checkins/checkins)

All endpoints for the Checkins API are supported.

## Basic support for [Foursquare Tips API](https://developer.foursquare.com/docs/tips/tips)

The following endpoints are supported from the Tips API:

* `/tips/TIP_ID`
* `/tips/TIP_ID/likes`
* `/tips/TIP_ID/listed`
* `/tips/TIP_ID/saves`

