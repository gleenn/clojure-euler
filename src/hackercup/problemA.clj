(ns hackercup.problemA)

(use '[clojure.string :only (join split)])
(use '[clojure.java.io :only (reader)])


;(with-open [rdr (clojure.java.io/reader "../../data/problemA/input.txt")]
;  (if-let [[x & xs] (line-seq rdr)]
;    (prn x "foo" xs)))

(defn gen [seed limit]
  (take-while #(< % limit)
    (iterate #(mod (* 1337 %) 31337))
    seed))

(defn dist [])

(defn solve [a b c]
  (let [[a b c] (map (fn [param] (Integer/parseInt param)) [a b c])]
    (let [xs (gen a c)
          ys (gen b c)]
      )))

(prn (map
       (fn [params] (apply solve params))
       (map (fn [line] (split line #"\s+"))
         (next (line-seq (reader "../../data/problemA/input.txt"))))))