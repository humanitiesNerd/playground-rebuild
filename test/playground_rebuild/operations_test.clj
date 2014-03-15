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

(deftest test-produce-A
  (let [calculated-data (pig/dump (produce-A test-data))
        expected-data [[[[13 21] [21 34]]]]]
    (is (= calculated-data expected-data)))
  )

(comment
  -----------------------
[[9 15] [15 25]]
[[4 6] [6 9]]
-----------------------

[[[[13 21] [21 34]]]]

)
