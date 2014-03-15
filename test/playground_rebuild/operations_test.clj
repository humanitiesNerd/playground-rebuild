(ns playground-rebuild.operations-test
  (:use [midje sweet cascalog]
        [clojure.tools.namespace.repl :only (refresh)]
        [playground-rebuild.operations])
  )

(fact (vanilla-function) => "abc" )

(fact (coremult [2 3 4]) => [[4 6] [6 9]])


(fact (test-query) => (produces [["3, 5, 1"] ["2, 3, 1"]]))

(fact (test-query-3) => (produces
                         [
                          [ [ [9 15] [15 25] ]  ]
                          [ [ [4 6] [6 9] ] ]
                          ]))
(comment
  -----------------------
3, 5, 1
2, 3, 1
-----------------------

-----------------------
[[9 15] [15 25]]
[[4 6] [6 9]]
-----------------------

)
