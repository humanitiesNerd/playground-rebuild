(ns playground-rebuild.operations-test
  (:require [clojure.test :refer :all]
            [clojure.tools.namespace.repl :refer [refresh]]
            [playground-rebuild.operations :refer :all]
            [pigpen.core :as pig])
  )




(deftest test-my-data
  (let [data (test-data)]
    (is (= (pig/dump data)
           [[3 5 3 1] [2 3 4 1] ]))))

(deftest test-produce-A
  (let [calculated-data (pig/dump (produce-A test-data))
        expected-data [[[[13 21 17] [21 34 27] [17 27 25]]]]]
    (is (= calculated-data expected-data)))
  )

(deftest test-produce-b
  (let [calculated-data (pig/dump (produce-b test-data))
        expected-data [[[5 8 7]]]]
    (is (= calculated-data expected-data))))

(comment
  output of (produce-A test-data)
-----------------------
[[[[13 21 17] [21 34 27] [17 27 25]]]]
-----------------------
output of (produce-b  test-data)
[[[5 8 7]]]


)
