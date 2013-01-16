(ns euler.problem9)

(defn is-pythagorean-triplet? [^long a ^long b ^long c]
  (= (+ (* a a) (* b b)) (* c c)))

(assert (is-pythagorean-triplet? 3 4 5))
(assert (not (is-pythagorean-triplet? 3 4 6)))


(defn pythagorean-triplet-with-sum-1000 []
  (apply * (some identity
             (for [c (range 1 1001)
                   b (range c)]
               (let [a (- 1000 b c)]
                 (if (and (is-pythagorean-triplet? a b c) (= 1000 (+ a b c)))
                   [a b c]))))))

(assert (= (pythagorean-triplet-with-sum-1000) 31875000))

(prn (pythagorean-triplet-with-sum-1000))

