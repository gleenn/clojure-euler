(ns gleenn.machine-learning)

(use '[clojure.string :only (join split)])
(use '[clojure.java.io :only (reader)])

(defn zip [& vecs] (apply map vector vecs))

(defn dot-product [vec-a vec-b]
  (reduce + (map #(apply * %) (zip vec-a vec-b))))

(prn (zip [1 2 3] ['a 'b 'c]))

(prn (dot-product [1 2 3] [3 2 1]))
