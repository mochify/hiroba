# Hiroba, a Clojure client for Foursquare

Hiroba is a minimalistic Clojure client for the Foursquare REST API.


## Project Goals

* Be feature complete with the [Foursquare API](https://developer.foursquare.com/overview/)
* Be well documented
* Be well tested
* Be Clojuric, relying on Clojure idioms without introducing unnecessary abstractions
* Don't be subject to [NIH Syndrome](http://en.wikipedia.org/wiki/Not_invented_here)
* Be up-to-date with the latest Foursquare API changes

## Project Maturity

Hiroba is in its infancy. It is a new project, with only minimal use in production and testing environments at this point. The API is subject to change at any time, but will stabilize over time.


## Artifacts

Hiroba artifacts are [released to Clojars](https://clojars.org/com.mochify/hiroba). If you are using Maven, add the following repository
definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [com.mochify/hiroba "0.1.0-SNAPSHOT"]


With Maven:

    <dependency>
      <groupId>com.mochify</groupId>
      <artifactId>hiroba</artifactId>
      <version>0.1.0-SNAPSHOT</version>
    </dependency>


## Documentation & Examples

Our documentation site is not yet live, sorry.



## Supported Clojure versions

Hiroba is developed against Clojure 1.5.0 and newer. Use of the latest version is recommended.


## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/{{name}}.png)](http://travis-ci.org/clojurewerkz/{{name}})


## Development

Hiroba uses [Leiningen
2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against supported
Clojure versions using

    lein2 all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2014 William Lee, Alex Kuang, and The Mochify Team.

Licensed under the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
