(ns com.jakewindle.autoposter
  (:require [com.jakewindle.socials.twitter :refer [tweet]])
  (:import (java.lang Runtime))
  (:gen-class))

(defn tweet-repl []
  (try
    (loop []
      (print "tweet> ")
      (flush)
      (let [input (read-line)
            tweet-response (tweet {:text input})]
        (println (str "=> tweet created " (.getId (.getData tweet-response)))))
      (recur))
    (catch InterruptedException e
      (println "Exiting..."))))

(defn -main [args]
  (tweet-repl))
