(ns playground-rebuild.operations-test
  (:use [midje sweet cascalog]
        [clojure.tools.namespace.repl :only (refresh)]
        [playground-rebuild.operations])
  )

(fact (vanilla-function) => "abc" )

(fact (coremult [2 3 4]) => [[4 6] [6 9]])


(fact (test-query) => (produces [["3, 5, 1"] ["2, 3, 1"]]))
