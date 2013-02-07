(ns memoizer)

(defn bounded-memoize
  "Return a bounded memoized version of fn 'f'
   that caches the last 'k' computed values"
  [f k]
  (assert (and (fn? f) (integer? k)))

  (let [cached-map (atom {})
        cached-queue (atom clojure.lang.PersistentQueue/EMPTY)]
    (fn [& args]
      (if-let [e (find @cached-map args)]
        (do (prn (val e)) (val e))
        (let [return-val (apply f args)]
          (swap! cached-queue conj args)
          (swap! cached-map dissoc (pop @cached-queue))
          (swap! cached-map assoc args return-val)
          return-val)))))

(defn fib [n]
  (if (<= n 1)
    n
    (+ (fib (dec n)) (fib (- n 2)))))

(time (fib 35))

(time ((bounded-memoize fib 10000) 35))