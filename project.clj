(defproject com.mochify/hiroba "0.1.0-alpha"
  :description "A minimalistic Clojure library for the Foursquare REST API"
  :url "http://mochify.github.io/hiroba"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cheshire            "5.3.1"]
                 [http-kit            "2.1.16"]
                 [clj-time            "0.6.0"]
                 [environ             "0.4.0"]
                 [http-kit.fake       "0.2.1"]]
  :min-lein-version "2.0.0"
  :global-vars {*warn-on-reflection* true}
  :plugins [[codox "0.6.6"]
            [lein-environ "0.4.0"]]
  :codox {:sources ["src"]
          :output-dir "doc/api"}
  :profiles {:compile {:aot [#"mochify.*"]}})
