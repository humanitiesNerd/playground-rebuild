(ns playground-rebuild.operations
  (:refer-clojure :exclude [* - + == /])
  (:use clojure.core.matrix)
  (:use clojure.core.matrix.operators))


(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [my-vector (matrix [a-vector])]
    (mmul (transpose my-vector) my-vector)))
