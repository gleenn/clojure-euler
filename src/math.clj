(ns math)
;  (:require [clojure.strings :as strings])
;  (:use clojure.strings))

(defn square [x] (* x x))

(defmulti to-string type)
(defmethod to-string java.lang.String [v] v)
(defmethod to-string java.lang.Long [v] (.toString v))

(to-string "Foo")
(to-string 2)

;(defn add [x y?]
;  (if y?
;
;  )
;)
;
;(prn (map omg_shut_ur_face/square [1,2,3]))
