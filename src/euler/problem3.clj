(ns euler.problem3)

(defn prime-factors [x]
  (doto #{}
    (for [factor (range 2 (Math/sqrt x))]
      (if (= 0 (mod x factor))
        (merge factors factor)
        )
      )
    )
  )

(test )

(prime-factors 10)
