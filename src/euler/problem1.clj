(ns euler.problem1)

(prn (reduce +
       (filter
         (fn [x] (or
                   (zero? (mod x 3))
                   (zero? (mod x 5))))
         (range 1000))))