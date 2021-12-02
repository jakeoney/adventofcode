(ns advent.of.code.day1
    (:require [clojure.string :as s]
              [clojure.repl :refer [doc]])
)
 

(slurp "/Users/jakeoney/personal/adventofcode/2021/day1/input.txt")

;; === Part 1 Solution ===
(defn readNumbers [filename]
  (->> filename
       slurp
       s/split-lines
       (map #(Integer/parseInt %)))
  )

(defn compareNumbers [numberPair] 
  (apply +
   (for [pair numberPair :when (< (nth pair 0) (nth pair 1))] `1))) 

(let [numbers (partition 2 1 (readNumbers "/Users/jakeoney/personal/adventofcode/2021/day1/input.txt"))]
  numbers
 (compareNumbers numbers))


;; === Part 2 Solution ===
;; Build sliding windows
(let [slidingWindows (partition 3 1 (readNumbers "/Users/jakeoney/personal/adventofcode/2021/day1/input.txt"))]
;;   Sum the values in the window. Partition it back into groups of 2
  (let [sumedWindows (partition 2 1 (for [window slidingWindows](apply + window)))]
    (compareNumbers sumedWindows)))
