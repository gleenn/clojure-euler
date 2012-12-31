(ns euler.problem5)

(defn divides? [number divisor] (zero? (mod number divisor)))

(defn has-all-divisors [divisors num]
  (if (every? (fn [divisor] (divides? num divisor)) divisors) num false))

;(prn (has-all-divisors [2 3 6] 6))
;(prn (has-all-divisors [1] 6))
;(time (prn (some (fn [i] (has-all-divisors (range 2 10) i)) (iterate inc 1)))) ; 2520 ; 94 msecs

(time (prn (some (fn [i] (has-all-divisors (range 2 20) i)) (iterate inc 1)))) ; 232792560 ; 163188 msecs

