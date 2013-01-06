(ns hackercup.problemA)

(use '[clojure.string :only (split)])
(use '[clojure.java.io :only (reader)])


(defn gen [seed limit]
  (take limit
    (iterate
      #(mod (* 1337 %) 31337)
      seed)))

;(defn dist [^long x ^long y]
(defn dist [^long x ^long y]
  (let [dx (Math/abs (- x 12345))
        dy (Math/abs (- y 6789))]
    [(Math/sqrt (+ (* dx dx) (* dy dy))) x y]))

(defn solve [a b c]
  (let [[a b c] (map (fn [param] (Integer/parseInt param)) [a b c])]
    (let [xs (gen a c)
          ys (gen b c)]
      (let [hundredth-closest (nth (sort (map #(apply dist %) (map vector xs ys))) 99)]
        (apply + (next hundredth-closest))))))

(def do-problem
  (map (fn [params] (apply solve params))
    (map (fn [line] (split line #"\s+"))
      (next (line-seq (reader "../../data/problemA/input.txt"))))))

(time (doseq [result
      (map-indexed (fn [i result] (str "Case #" (str (inc i)) ":" (str result))) do-problem)]
  (println result)))