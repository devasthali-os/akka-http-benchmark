(defproject akka-http-benchmark "0.1.0-SNAPSHOT"
  :description "akka http benchmark"
  :url "http://prayagupd.io"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.443"]
                 [clj-http "3.7.0"]
                 ]
  :user {:repository [["clojars" "http://clojars.org/repo/"]
                      ["sonatype" "https://oss.sonatype.org/content/repositories/releases/"]
                      ["mvncentral" "http://central.maven.org/maven2/"]]}

  :main ^:skip-aot akka-http-benchmark)