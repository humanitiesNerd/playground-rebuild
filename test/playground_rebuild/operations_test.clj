(ns playground-rebuild.operations-test
  (:require [clojure.test :refer :all]
            [clojure.tools.namespace.repl :refer [refresh]]
            [playground-rebuild.operations :refer :all]
            [pigpen.core :as pig])
  )


(deftest test-my-data
  (let [data (test-data)]
    (is (= (pig/dump data)
           [[3 5 1] [2 3 1] ]))))



(comment
  -----------------------
[[9 15] [15 25]]
[[4 6] [6 9]]
-----------------------
)
