(ns clj-euler)

;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn find-sum-until-when-divisible-by [upper-bound mydivisors]
  (reduce +
          (filter
           #((fn [l x] (some (fn [y] (zero? (rem x y))) l)) mydivisors %)
           (range upper-bound))))

(find-sum-until-when-divisible-by 1000 [3 5]) ;; 233168


;; The filter function could be written this way for just 3 and 5
(#(or (zero? (rem % 3)) (zero? (rem % 5))) 8)