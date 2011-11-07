(ns clj-euler)

(defn square-int? [n]
  (let [sqrt (int (Math/sqrt n))]
    (= (* sqrt sqrt) n)))


(for [a (range 0 500)
      b (range a 500)
      :let [a2 (* a a) b2 (* b b) c (Math/sqrt (+ a2 b2)) c2 (+ a2 b2)]
      :when
      (and
       (square-int? c2)
       (= 1000 (+ a b c)))
      ]
  (* a b c)) ;; 31875000