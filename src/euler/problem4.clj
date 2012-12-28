(ns euler.problem4)

(use '[clojure.string :only (join)])

(println
  (apply max
    (map (fn [num] (Integer/parseInt num))
      (filter (fn [num] (= num (join (reverse num))))
        (for [i (range 100 999) j (range 100 999) :when (< i j)]
          (.toString (* i j)))))))
