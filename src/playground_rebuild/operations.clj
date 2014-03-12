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
  (let [my-vector (matrix [a-vector])]
    (mmul (transpose my-vector) my-vector)))

(defn vanilla-function [] "abc")

(defn test-query []
  (let [tap (lfs-delimited "X-matrix/tests.txt")]
    (<- [?line] (tap ?line))))
