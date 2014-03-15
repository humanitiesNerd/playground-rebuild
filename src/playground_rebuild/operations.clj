(ns playground-rebuild.operations
  (:refer-clojure :exclude [* - + == /])
  (:require [clojure.core.matrix :as m]
            [clojure.tools.namespace.repl :refer [refresh]]
            [pigpen.core :as pig]
        )
  )


(defn test-data []
  (pig/load-tsv "X-matrix/tests.tsv"))

(defn coremult [a-vector]
  "it multiplies a column vector for itself"
  (let [my-vector (m/matrix [a-vector])]
    (m/mmul (m/transpose my-vector) my-vector)))
