(ns playground-rebuild.operations
  (:refer-clojure :exclude [* - + == /])
  (:use [clojure.core.matrix]
        [clojure.tools.namespace.repl :only (refresh)]
        [cascalog.api :exclude (div)]
        [cascalog.more-taps :only (lfs-delimited)]
        [midje.cascalog])
  )



(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [without-y (subvec a-vector 0 (clojure.core/- (count a-vector) 1))
        my-vector (matrix [without-y])]
    (mmul (transpose my-vector) my-vector)))

(comment
  (defn coremult [vector]
    (let [without-y (subvec vector 0 (- (count vector) 1))]
      (i/mmult without-y (i/trans without-y)))
    ))

(defn vanilla-function [] "abc")

(defn test-query []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?line] (tap ?line))))
