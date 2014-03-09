(defproject playground-rebuild "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [net.mikera/core.matrix "0.20.0"]
                 [cascalog/cascalog-core "2.0.0"]
                 [cascalog/cascalog-more-taps "2.0.0" ]
                 ]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [org.apache.hadoop/hadoop-core "1.1.2"]]}})
