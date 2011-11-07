(ns clj-euler)

;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn sum-of-squares [coll]
  (reduce + (map #(* % %) coll)))


(defn square-of-sum [coll]
  (let [sum (reduce + coll)]
    (* sum sum)))

(defn sum-sq-and-sq-sum-diff [coll]
  (- (sum-of-squares coll) (square-of-sum coll)))

(def myrange (range 1 101))

(sum-of-squares myrange)
(square-of-sum myrange)
(sum-sq-and-sq-sum-diff (range 1 101)) ;; 25164150 (absolute value)