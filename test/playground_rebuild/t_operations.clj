(ns playground-rebuild.operations-test
  (:use [midje sweet cascalog]
        [clojure.tools.namespace.repl :only (refresh)]
        [playground-rebuild.operations])
  )

(fact (vanilla-function) => "abc" )

;(fact (test-query) => (produces [[["3, 5, 1"] ["2, 3, 1"]]]))

(fact (test-query) => (produces [["3, 5, 1"] ["2, 3, 1"]]))
