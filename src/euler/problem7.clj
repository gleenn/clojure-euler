(ns euler.problem7)

(defn divides? [num divisor] (= (rem num divisor) 0))

(defn find-nth-prime [nth]
  (loop [x 2
         num-primes 1]
    (if (= num-primes nth)
      x
      ;      (if (some (partial divides? x) (range 2 (Math/ceil (Math/sqrt x))))
      (if (some (partial divides? x) (range 2 x))
        (recur (inc x) num-primes)
        (recur (inc x) (inc num-primes))))))


(assert (= (divides? 4 2) true))
(assert (= (divides? 4 3) false))

;(assert (= (some (partial divides? x) (range 2 x))))

(prn (find-nth-prime 3))
(assert (= (find-nth-prime 1) 2))
(assert (= (find-nth-prime 2) 3))
;(assert (= (find-nth-prime 3) 5))
;(assert (= (find-nth-prime 4) 7))
;(assert (= (find-nth-prime 5) 11))

;(prn (find-nth-prime 10001))
