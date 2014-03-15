(ns playground-rebuild.operations
  ;(:refer-clojure :exclude [* - + == /])
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.operators :as ops]
            [clojure.tools.namespace.repl :refer [refresh]]
            [pigpen.core :as pig]
        )
  )


(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [without-y (subvec a-vector 0 (- (count a-vector) 1))
        my-vector (m/matrix [without-y])]
    (m/mmul (m/transpose my-vector) my-vector)))

(defn produce-A [data]
  (pig/reduce m/add
              (pig/map coremult (data))))
