(ns euler.problem28)

(defn spiral-sum [width]
  "returns the sum of the diagonals of a grid where the numbers spiral outward starting at 1
  radius of a 1 by 1 is 0"
  (let [radius (quot (- width 1) 2)]
    (loop [current-val 1 current-sum 1 increment-amount 2 corner 0 iterations-left (* 4 radius)]
    (if (zero? iterations-left)
      current-sum
      (let [
        next-val (+' current-val increment-amount)
        next-sum (+' current-sum current-val increment-amount)
        next-increment-value (if (= corner 3) (*' 2 increment-amount) increment-amount)
        next-corner (if (= corner 3) 0 (inc corner))
        next-iterations-left (dec' iterations-left)]
        (recur next-val next-sum next-increment-value next-corner next-iterations-left))))))

(println (spiral-sum 1))
(println (spiral-sum 3))
(println (spiral-sum 5))
(println (spiral-sum 7))
(println (spiral-sum 9))
(println (spiral-sum 11))
(println (spiral-sum 13))
(println (spiral-sum 1001))

; wrong -> 170216311610599377240685864235035155915265386394239369053131151140998957413043076853930044800947016171846107574633123692479297340386040438773083434633501N