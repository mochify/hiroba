(ns mochify.hiroba.tests.rest-test
  (:require [clojure.test :refer :all]
            [mochify.hiroba.rest :as rest]))

(deftest test-make-api-endpoint
  (let [versionless-endpoint (rest/make-api-endpoint "http" "api.foursquare.com")
        versioned (rest/make-api-endpoint "https" "api.foursquare.com" "v2")]
    (is (= "http" (:protocol versionless-endpoint)))
    (is (= "api.foursquare.com" (:uri versionless-endpoint)))
    (is (nil? (:version versionless-endpoint)))
    (is (= "https" (:protocol versioned)))
    (is (= "api.foursquare.com" (:uri versioned)))
    (is (= "v2" (:version versioned)))))
