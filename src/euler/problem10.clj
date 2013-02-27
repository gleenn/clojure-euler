(ns euler.problem10)

(defn divides? [^long number ^long divisor] (zero? (mod number divisor)))

(defn primes-upto [upto-n]
  (if (<= upto-n 1)
      #{}
    (loop [n 2 primes #{}]
      (if (= n upto-n) primes
        (if (some (fn [prime] (divides? prime n)) primes)
          (recur (inc n) primes)
          (recur (inc n) (merge primes )))))))

(prn (primes-upto 1))
;(assert (= (primes-upto 1) #{}))
;(assert (= (primes-upto 2) #{2}))
;(assert (= (primes-upto 3) #{2 3}))
;(assert (= (primes-upto 4) #{2 3}))
;(assert (= (primes-upto 5) #{2 3 5}))

;(defn sum-primes-upto [upto-n]
;  (->> (primes-upto upto-n)))

;(assert (= (sum-primes-upto 1) 0))
;(assert (= (sum-primes-upto 2) 2))
;(assert (= (sum-primes-upto 3) 5))
;(assert (= (sum-primes-upto 10) (+ 2 3 5 7)))
;(assert (= (sum-primes-upto 11) (+ 2 3 5 7 11)))
;(assert (= (sum-primes-upto 100) 1060))
