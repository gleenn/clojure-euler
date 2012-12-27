(ns euler.problem3)

(defn prime-factors-helper [factors factor x]
  (if (= factor x) (conj factors x)
    (if (> factor x) factors
      (if (= 0 (mod x factor))
        (prime-factors-helper (conj factors factor) factor (/ x factor))
        (prime-factors-helper factors (inc factor) x)))))

(def prime-factors (partial prime-factors-helper #{1} 2))

(defn largest-prime-factor [x]
  (apply max (prime-factors x))
  )

(prn (largest-prime-factor 600851475143)) ; should equal 6857