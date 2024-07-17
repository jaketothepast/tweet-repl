(ns com.jakewindle.socials.auth-handler
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]))

(defn start-embedded-auth-server [handler]
  (let [app (wrap-params handler)]
    (jetty/run-jetty app {:port 3000 :join? false})))
