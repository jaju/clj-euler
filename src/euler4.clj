(ns clj-euler)

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn str-reverse [x]
  (if (= 1 (count x))
    x
    (reduce #(str %2 %1) x)))


(defn ispalindrome-number? [n]
  (let [s (str n)]
    (= s (str-reverse s))))

(reduce max (filter ispalindrome-number?
                    (for [x (range 100 1000) y (range 100 1000)]
                      (* x y)))) ;; 906609



