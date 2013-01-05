(ns euler.problem7)

(defn is-prime [n]
  true)

(defn find-nth-prime [n]
  (some (fn [num] (if (is-prime num) num false)) (iterate inc 1)))

(prn (find-nth-prime 10001))
