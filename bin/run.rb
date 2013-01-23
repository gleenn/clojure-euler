#!/usr/bin/env ruby

CLOJURE_JAR = File.dirname(__filename__) + "../lib/clojure.jar"
system("java -cp #CLOJURE_JAR clojure.main -i #ARGS")
