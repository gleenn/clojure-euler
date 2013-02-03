(ns euler.problem28)

(defn spiral-sum [width]
  "returns the sum of the diagonals of a grid where the numbers spiral outward starting at 1
  radius of a 1 by 1 is 0"
  (let [radius (quot (- width 1) 2)]
    (loop [current-val 1 current-sum 1 increment-amount 2 corner 0 iterations-left (* 4 radius)]
      ;(do (print (str current-val " "))
      (if (zero? iterations-left)
        current-sum
        (let [
               next-val (+' current-val increment-amount)
               next-sum (+' current-sum current-val increment-amount)
               next-increment-value (if (= corner 3) (+ 2 increment-amount) increment-amount)
               next-corner (if (= corner 3) 0 (inc corner))
               next-iterations-left (dec' iterations-left)]
          (recur next-val next-sum next-increment-value next-corner next-iterations-left))))));)

;.73.  74  75   76   77   78   79   80  .81.
; 72  .43.  44   45   46   47   48  .49. 50
; 71   42  .21.  22   23   24  .25.  26  51
; 70   41   20   .7.   8   .9.  10   27  52
; 69   40   19    6   .1.   2   11   28  53
; 68   39   18   .5.   4   .3.  12   29  54
; 67   38  .17.  16   15   14  .13.  30  55
; 66  .37.  36   35   34   33   32  .31. 56
;.65.  64   63   62   61   60   59   58 .57.

(assert (= (spiral-sum 1) (+ 1)))
(assert (= (spiral-sum 3) (+ 1 3 5 7 9)))
(assert (= (spiral-sum 5) (+ 1 3 5 7 9 13 17 21 25)))
(assert (= (spiral-sum 7) (+ 1 3 5 7 9 13 17 21 25 31 37 43 49)))
(assert (= (spiral-sum 9) (+ 1 3 5 7 9 13 17 21 25 31 37 43 49 57 65 73 81)))
(assert (= (spiral-sum 11) 961))
(assert (= (spiral-sum 13) 1565))
(assert (= (spiral-sum 1001) 669171001))
(prn (spiral-sum 1001))