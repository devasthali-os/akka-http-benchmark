(ns akka-http-benchmark
    (:gen-class)
    (:require [clojure.core.async :as async]
              [clj-http.client :as http])

    (:import [java.util.concurrent Executors]))

(defn task-fn [id]
  (str "Thread " (.getName (Thread/currentThread)) " executing " id))

(defn http-task [id]
  (http/get "http://localhost:9191/chat"))

(defn process-tasks [task data n-threads]
  (let [pool    (Executors/newFixedThreadPool n-threads)
        tasks   (map (fn [v] #(task v)) data)
        results (for [future (.invokeAll pool tasks)] (.get future))]
    (.shutdown pool)
    results))

(defn benchmark-result [concurrency]
  (println "akka http benchmark")
  (let [results (process-tasks http-task (range concurrency) 4)]
    results))

(defn -main "akka-http-benchmark" [& args]
  (println (benchmark-result 100)))