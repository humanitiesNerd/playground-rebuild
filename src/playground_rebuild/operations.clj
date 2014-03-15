(ns playground-rebuild.operations
  (:refer-clojure :exclude [* - + == /])
  (:use [clojure.core.matrix]
        [clojure.tools.namespace.repl :only (refresh)]
        )
  )



(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [my-vector (matrix [a-vector])]
    (mmul (transpose my-vector) my-vector)))
