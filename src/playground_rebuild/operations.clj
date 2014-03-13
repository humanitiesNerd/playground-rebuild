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

(defmapfn vectormult [line]
  [(coremult (to-int-vector line))]
  )

(defn coresum [matrix1 matrix2]
  {:pre [(matrix? matrix1) (matrix? matrix2)]}

  [13 21 21 34])

(defparallelagg matrix-sum :init-var #'identity :combine-var #'coresum)

(defn test-query-3 []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?intermediate-matrices]
        (tap ?line)
        (vectormult ?line :> ?intermediate-matrices)
        ;(matrix-sum ?intermediate-matrices :> ?final-matrix)
        )))



(defn vanilla-function [] "abc")

(defn test-query []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?line] (tap ?line))))
