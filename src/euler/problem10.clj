(ns euler.problem10)

(defn divides? [^long number ^long divisor] (zero? (mod number divisor)))

(defn is-prime? [candidate]
  "real slow prime checker..."
  (not (some #(divides? candidate %) (range 2 (inc (/ candidate 2))))))

(assert (is-prime? 2))
(assert (is-prime? 3))
(assert (not (is-prime? 4)))
(assert (is-prime? 5))
(assert (not (is-prime? 6)))
(assert (is-prime? 7))
(assert (not (is-prime? 8)))
(assert (not (is-prime? 9)))
(assert (not (is-prime? 10)))
(assert (is-prime? 11))
(assert (is-prime? 13))
(assert (is-prime? 101))

(defn primes-upto [size]
  (->> (range 2 (inc size))
  (map #(if (is-prime? %) % 0))))

(defn sum-primes-upto [size]
  (->>
    (primes-upto size)
    (reduce +)))

;(time (prn (sum-primes-upto 2000000)))
(assert (= (sum-primes-upto 1) 0))
(assert (= (sum-primes-upto 2) 2))
(assert (= (sum-primes-upto 3) 5))
(assert (= (sum-primes-upto 10) (+ 2 3 5 7)))
(assert (= (sum-primes-upto 11) (+ 2 3 5 7 11)))
(assert (= (sum-primes-upto 100) 1060))