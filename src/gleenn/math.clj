(ns euler.math)
;  (:require [clojure.strings :as strings])
;  (:use clojure.strings))

(defn square [x] (* x x))

(defn divides? [^long number ^long divisor] (zero? (mod number divisor)))
