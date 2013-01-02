(ns euler.problem6)

(defn square [n] (* n n))
(defn sum [xs] (reduce + xs))

(prn (- (square (sum (range 101)))
        (sum (map square (range 101))))) ; 25164150