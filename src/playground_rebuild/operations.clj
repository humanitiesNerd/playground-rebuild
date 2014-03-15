(ns playground-rebuild.operations
  ;(:refer-clojure :exclude [* - + == /])
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.operators :as ops]
            [clojure.tools.namespace.repl :refer [refresh]]
            [pigpen.core :as pig]
        )
  )

(defn test-data []
  (pig/return [[3 5 3 1] [2 3 4 1]]))


(defn coremult [a-vector]
  "it multiplies a column vector for itself, but without the last digit, assumed to be belonging to the y column"
  (let [without-y (subvec a-vector 0 (- (count a-vector) 1))
        my-vector (m/matrix [without-y])]
    (m/mmul (m/transpose my-vector) my-vector)))


(defn produce-A [data]
  (pig/reduce m/add
              (pig/map coremult (data))))


(defn coremult2 [a-vector]
  (let [y (peek a-vector)
        without-y (subvec a-vector 0 (- (count a-vector) 1))]
    (m/mul y without-y)))

(defn produce-b [data]
  (pig/reduce m/add (pig/map coremult2 (data))))
