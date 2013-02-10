(ns euler.problem14)

;The following iterative sequence is defined for the set of positive integers:
;
;n -> n/2 (n is even)
;n -> 3n + 1 (n is odd)
;
;Using the rule above and starting with 13, we generate the following sequence:
;
;13  40  20  10  5  16  8  4  2  1
;It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
;
;Which starting number, under one million, produces the longest chain?
;
;NOTE: Once the chain starts the terms are allowed to go above one million.

(defn collatz-function [x]
  (if (even? x)
    (/ x 2)
    (inc (* 3 x))))

(defn collatz-seq-length [^long seed]
  (loop [val seed curr-length 0]
        (if (= val 1)
          (inc curr-length)
          (recur (collatz-function val) (inc curr-length)))))

(defn longest-collatz-seq [^long upto]
  (reduce max (map collatz-seq-length (range 1 (inc upto)))))

;(prn (longest-collatz-seq (range 1 6)))

(assert (= (longest-collatz-seq 1) 1))
(assert (= (longest-collatz-seq 2) 2))
(assert (= (longest-collatz-seq 3) 8))
(assert (= (longest-collatz-seq 4) 8))
(assert (= (longest-collatz-seq 5) 8))
(assert (= (longest-collatz-seq 6) 9))
(assert (= (longest-collatz-seq 7) 9))

(prn (collatz-seq-length 12))
(assert (= (longest-collatz-seq 12) 10))