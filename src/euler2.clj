(ns clj-euler)

;;By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

(def fibseq
  (lazy-cat [0 1]
            (map + fibseq (rest fibseq))))

(defn fibseq-lt [x]
  (take-while #(< % x) fibseq))

(reduce + (filter even? (fibseq-lt 4000000))) ;; 4613732