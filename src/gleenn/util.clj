(ns util)

; Blatantly stolen from
; http://stackoverflow.com/questions/5538033/how-to-add-fields-to-a-map-in-clojure

(defn merge-missing-keys [
                           a-set
                           some-keys
                         ]
          (merge-with
                         #(or %1 %2)
                         a-set
                         (into {} (map (fn[x] {x nil}) some-keys))))

;(merge-missing-keys {:a 1 :b 20} '(:a :b :c :d :e )) => {:a 1 :b 20 :c nil :d nil :e nil}
