(ns euler.problem3)

(defn prime-factors-helper [x factors factor]
  (if (= factor x) (conj factors x)
    (if (> factor x) factors
      (if (= 0 (mod x factor))
        (prime-factors-helper (/ x factor) (conj factors factor) factor)
        (prime-factors-helper x factors (inc factor))))))

(defn prime-factors [x]
  (prime-factors-helper x #{1} 2)
  )

(defn largest-prime-factor [x]
  (apply max (prime-factors x))
  )

(prn (largest-prime-factor 600851475143))