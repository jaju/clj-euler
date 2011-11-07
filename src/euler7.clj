(ns clj-euler)

(nth (filter isprime? (iterate inc 2)) 10000)
