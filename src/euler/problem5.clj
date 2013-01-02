(ns euler.problem5)
(set! *unchecked-math* true)

(defn divides? [^long number ^long divisor] (zero? (mod number divisor)))

(defn has-all-divisors [divisors ^long num]
  (if (every? (fn [i] (divides? num i)) divisors) num false))

(time (prn (some (fn [^long i] (has-all-divisors (range 2 20) i)) (iterate inc 1))))

;(prn (has-all-divisors [2 3 6] 6))
;(prn (has-all-divisors [1] 6))
;(time (prn (some #(has-all-divisors (range 2 10) %) (iterate inc 1)))) ; 2520 ; 94 msecs

;(time (prn (some #(has-all-divisors (range 2 20) %) (iterate inc 1)))) ; 232792560 ; 163188 msecs

