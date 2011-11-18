(ns clj-euler)

;; What is the largest prime factor of the number 600851475143?

(defn divs? [n x]
  (zero? (rem n x)))

(defn isprime? [n]
  {:pre [(> n 1)]}
  (if (= 2 n)
    true
    (not
     (some #(divs? n %) (range 2 (+ 2 (int (Math/sqrt n))))))))

(defn isprimefactor? [x n]
  (and (zero? (rem n x)) (isprime? x)))

(defn largest-prime-factor [n]
  (let [upper-bound (+ 2 (int (Math/sqrt n)))]
    (first (filter #(isprimefactor? % n) (range upper-bound 1 -1)))))

(def ln 600851475143)
(largest-prime-factor ln) ;; 6857
