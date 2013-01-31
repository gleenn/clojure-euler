(ns euler.problem28)

; things along the diagonals are summed
; in this 5x5 number spiral and add up to
; 101
;
;.21.  22   23   24  .25.
; 20   .7.   8   .9.  10
; 19    6   .1.   2   11
; 18   .5.   4   .3.  12
;.17.  16   15   14  .13.
;
; 1 + 3 + 5 + 7 + 9 + 13 + 17 + 21 + 25
;  1   4   9   16  25
;  1   4   9   16  25
;
;ns(1) => 1
;
;ns(2) => 1 + 1+2 + 1+2+2 + 1+2+2+2 + 1+2+2+2+2
;
;ns(3) => 1 + 1+2 + 1+2+2 + 1+2+2+2 + 1+2+2+2+2
;           + 1+2+2+2+2+4 + 1+2+2+2+2+4+4 + 1+2+2+2+2+4+4+4 + 1+2+2+2+2+4+4+4+4
;
;ns(1) => 1
;ns(x+1) => ns(x) + 4*ns(x) + 10*2^x
;ns(x+1) => 1 + 4*ns(x-1)

;1 2 2 2 2 4 4 4 4 8 8 8 8
;2^(floor(x/4)-1)

(defn spiral-seq-at [^long index]
  (long (Math/pow 2 (quot (+ 3 index) 4))))

;(assert (= (map spiral-seq-at (range 17)) [1 2 2 2 2 4 4 4 4 8 8 8 8 16 16 16 16]))
;
;(defn seq-length-in-sprial-with-diameter [radius]
;  (+ 1 (* 4 (- radius 1))))
;
;(assert (= (map seq-length-in-sprial-with-diameter (range 1 6)) [1 5 9 13 17]))
;
;(defn number-spiral-sum [spiral-radius]
;  (let [seq-length-in-sprial-with-diameter (seq-length-in-sprial-with-diameter spiral-radius)]
;    (loop [x 1 sum 1 prev-in-seq 0]
;      (if (= x seq-length-in-sprial-with-diameter) sum
;        (let [current-num (spiral-seq-at x)]
;          (recur (inc x) (+ sum current-num) current-num))))))

;(defn number-spiral-sum [spiral-radius]
;  (let [upto (* spiral-radius spiral-radius)]
;    (loop [sum 0 curr-num 0 cycle 3 increment-by 1]
;      (let [new-curr-num (+ curr-num increment-by)
;            new-sum (+ sum new-curr-num)]
;        (if (= new-curr-num upto)
;          new-sum
;          (recur new-sum new-curr-num (rem (inc cycle) 4)
;            (if-not (zero? cycle)
;              increment-by
;              (* 2 increment-by))))))))

(def spiral-seq
  (map spiral-seq-at (iterate inc 0)))

(defn spiral-sum [spiral-diameter]
  (let [upto (* spiral-diameter spiral-diameter)
        stuff (into [] (take spiral-diameter spiral-seq))
        sequence (map (fn [index] (take index stuff)) (range 1 (inc (count stuff))))
        grouped-sequence (map
      (fn [group-by] (takexxx group-by sequence))
      (cons 1 (iterate #(+ 4 %) 4)))]
    (take spiral-diameter grouped-sequence)))
;    (last (take upto grouped-sequence))))

;(prn (spiral-sum 1))
;(prn (spiral-sum 3))
(prn (spiral-sum 5))
;(assert (= (number-spiral-sum 1) 1))
;(prn (number-spiral-sum 3))
;(assert (= (number-spiral-sum 3) 25))
;(assert (= (number-spiral-sum 2) (+ 1 3 5 7 9)))
;(assert (= (number-spiral-sum 2) (+ 1 1 2 1 2 2 1 2 2 2 1 2 2 2 2)))
;(assert (= (number-spiral-sum 3) (+ 1 3 5 7 9 13 17 21 25)))
