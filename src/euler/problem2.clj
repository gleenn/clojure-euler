(ns euler.problem2)

;(prn (take 10 (iterate (fn [[x y]] [y (+ x y)]) [0 1])))

;(prn (take 10 (filter even?
;                (map (fn [[x y]] x)
;                              (iterate (fn [[x y]] [y (+ x y)]) [0 1])))))

(defn fib-seq [] (map first (iterate (fn [[x y]] [y (+ x y)]) [0 1])))

;(prn (take 10 (filter even? (fib-seq))))
(prn (reduce + (take-while (fn [x] (<= x 4000000)) (filter even? (fib-seq)))))