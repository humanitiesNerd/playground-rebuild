(ns playground-rebuild.operations-test
  (:require [midje sweet]
            [clojure.tools.namespace.repl :refer [refresh]]
            [playground-rebuild.operations])
  )


(fact (coremult [2 3 4]) => [[4 6] [6 9]])



(comment
  -----------------------
[[9 15] [15 25]]
[[4 6] [6 9]]
-----------------------
)
