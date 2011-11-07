(ns clj-euler)

;; Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference is pentagonal and D = |Pk − Pj| is minimised; what is the value of D?

(defn pentagonal [n]
  (/ (* n (- (* 3 n) 1)) 2))

(def pentagonal-seq
  (map pentagonal (iterate inc 1)))

;; Is the root of the polynomial equation associated with this number an integer?
(defn ispentagonal? [n]
  (zero? (rem (+ 1 (Math/sqrt (+ 1 (* 24 n)))) 6)))

(defn sum-and-diff-pentagonals? [[ignore sum diff]]
  (and (ispentagonal? sum) (ispentagonal? diff)))

(last
 (first
  (filter sum-and-diff-pentagonals?
          (for [cur-pentagonal pentagonal-seq
                smaller-pentagonal (reverse (take-while #(< % cur-pentagonal) pentagonal-seq))]
            [cur-pentagonal (+ cur-pentagonal smaller-pentagonal) (- cur-pentagonal smaller-pentagonal)])))) ;; 5482660