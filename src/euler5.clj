(ns clj-euler)

;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn primefactors [n]
  (let [pfs (filter #(isprimefactor? %1 n) (range 2 (inc n)))]
    (if (nil? pfs)
    n
    pfs)))

(defn max-div-pow [num factor]
  (loop [n num ctr 0]
    (if (integer? (/ n factor))
      (recur (/ n factor) (inc ctr))
      ctr)))

(defn all-prime-factors-and-powers [n]
  (map #(conj [] % (max-div-pow n %)) (primefactors n)))

(all-prime-factors-and-powers 1250)

(defn pick-lcm-factors [factors-list]
  (let [m {}]
    (reduce
     (fn [factors-map factor] (assoc factors-map (first factor) (max (second factor) (get factors-map (first factor) 0))))
     m factors-list)))


;; All of the above is a waste - the following came to my mind after an enlightenment moment!


(defn max-pow-lt [prime ub]
  (loop [ans 1]
    (if (< (Math/pow prime ans) ub)
      (recur (inc ans))
      (- ans 1))))

(defn all-lcm-factors-until [ub-inclusive]
  (let [ub (inc ub-inclusive)]
    (map #(conj [] % (max-pow-lt % ub)) (for [num (range 2 ub) :when (isprime? num)] num))))

(reduce
 #(* %1 (Math/pow (first %2) (second %2))) 1 (all-lcm-factors-until 20)) ;; 232792560

(all-lcm-factors-until 20)
