
(defmulti to-string type)
(defmethod to-string java.lang.String [v] v)
(defmethod to-string java.lang.Long [v] (.toString v))

(to-string "Foo")
(to-string 2)

