(ns euler.problem5)
(set! *unchecked-math* true)
;(set! *warn-on-reflection* true)

(defn divides? [^long number ^long divisor] (zero? (mod number divisor)))

;(defn has-all-divisors [divisors ^long num]
;  (if (every? (fn [^long i] (divides? num i)) divisors) num false))
;
;(time (let [rng (range 2 20)
;            f (fn [^long i] (has-all-divisors rng i))]
;        (prn (loop [i 1]
;               (if (f i)
;                 i
;                 (recur (inc i)))))))


;; fast solution from http://stackoverflow.com/questions/14115980/clojure-performance-really-bad-on-simple-loop-versus-java
(defn has-all-divisors [^long num]
  (loop [d (long 2)]
    (if (== 0 (rem num d))
      (if (>= d 20) true (recur (inc d)))
      false)))

(time (prn (loop [i (long 1)] (if (has-all-divisors i) i (recur (inc i))))))

;(time (prn (some #(has-all-divisors (range 2 10) %) (iterate inc 1)))) ; 2520 ; 94 msecs

;(time (prn (some #(has-all-divisors (range 2 20) %) (iterate inc 1)))) ; 232792560 ; 163188 msecs



;(ns euler.problem5
;  (:require clojure.test))
;
;(with-test
;  (defn divides? [divisor number] (zero? (mod number divisor)))
;
;  (defn has-all-divisors [divisors num]
;    (reduce (fn [other-divided divisor] (true? (and (divides? num divisor)))) true divisors))
;
;;(prn (take-while (fn [i] (< i 20)) (iterate inc 0)))
;
;  (is (has-all-divisors [2 3 6] 6))
;)
