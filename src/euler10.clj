(ns clj-euler)

(reduce + (filter isprime? (range 2 2000000))) ;; 142913828922