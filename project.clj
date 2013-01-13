;; Use leiningen 2
(defproject org.clojars.michaelsbradleyjr/liberator "0.9.0-SNAPSHOT"
  :description "Liberator - A REST library for Clojure."
  :dependencies [[org.clojure/clojure "1.5.0-RC2"]
                 [org.clojure/tools.trace "0.7.5"]
                 [org.clojure/tools.logging "0.2.4"]
                 [org.clojure/data.json "0.2.1"]
                 [org.clojure/data.csv "0.1.2"]
                 [hiccup "1.0.2"]] ;; Used by code rendering default representations.

  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}

  :scm {:connection "scm:git:https://github.com/clojure-liberator/liberator.git"
        :url "https://github.com/clojure-liberator/liberator"}

  :plugins [[lein-midje "2.0.4"]
            [lein-ring "0.8.0"]]

  :profiles {:dev {:dependencies [[ring/ring-jetty-adapter "1.2.0-SNAPSHOT"]
                                  [ring-mock "0.1.3"]
                                  [ring/ring-devel "1.2.0-SNAPSHOT"]
                                  [compojure "1.1.5" :exclusions [org.clojure/tools.macro]] ;; only for examples
                                  [midje "1.4.0"]
                                  [org.clojure/clojurescript "0.0-1552"]]
                    :source-paths [ "src" "examples/clj"]}}

  :source-paths ["src"]
  :test-paths ["test"]

  :ring {:handler examples.server/handler
         :adapter {:port 8000}}

  :aliases {"examples" ["run" "-m" "examples.server"]})
