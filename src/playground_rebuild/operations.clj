(ns playground-rebuild.operations
  ;(:refer-clojure :exclude [* - + == /])
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.operators :as ops]
            [clojure.tools.namespace.repl :refer [refresh]]
            [pigpen.core :as pig]
        )
  )


(defn test-data []
  (pig/return [[3 5 1] [2 3 1]]))


(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [without-y (subvec a-vector 0 (- (count a-vector) 1))
        my-vector (m/matrix [without-y])]
    (m/mmul (m/transpose my-vector) my-vector)))
