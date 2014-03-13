(ns playground-rebuild.operations
  (:refer-clojure :exclude [* - + == /])
  (:use [clojure.core.matrix]
        [clojure.core.matrix.operators]
        [clojure.tools.namespace.repl :only (refresh)]
        [cascalog.api :exclude (div)]
        [cascalog.more-taps :only (lfs-delimited)]
        ;[midje.cascalog]
        )
  )



(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [without-y (subvec a-vector 0 (clojure.core/- (count a-vector) 1))
        my-vector (matrix [without-y])]
    (mmul (transpose my-vector) my-vector)))

(defn to-int-vector [line]
  (vec (map #(Integer/parseInt %) (clojure.string/split line #", ")))
)

(defmapcatop vectormult [line]
  [[(coremult (to-int-vector line))]]
  )


(defn coresum [matrix1 matrix2]
  (if (and (matrix? matrix1) (matrix? matrix2))
    (+ matrix1 matrix2)
    (matrix [[1 1] [1 1]])))

(defparallelagg matrix-sum :init-var #'identity :combine-var #'coresum)

(defn test-query-2 []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?final-matrix]
        (tap ?line)
        (vectormult ?line :> ?final-matrix)
        ;(matrix-sum ?intermediate-matrices :> ?final-matrix)
        )))



(defn vanilla-function [] "abc")

(defn test-query []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?line] (tap ?line))))
