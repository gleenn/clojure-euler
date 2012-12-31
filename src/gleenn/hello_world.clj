(ns hello_world,
  (:require gleenn.math))

;(in-ns 'hello_world)
;(use 'math)

(prn (map math/square [1,2,3]))

;(doall (prn "hi"))

;(defn multiargfn ([x] (prn x)) ([x y] (prn (+ x y))))
;(multiargfn 2)
;(multiargfn 2 3)