(ns hello_world,
  (:use math))

;(in-ns 'hello_world)
;(use 'math)

(prn (map square [1,2,3]))

;(doall (prn "hi"))

;(defn multiargfn ([x] (prn x)) ([x y] (prn (+ x y))))
;(multiargfn 2)
;(multiargfn 2 3)