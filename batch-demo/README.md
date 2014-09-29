batch-demo
==========

run with:

    java -Dspark.yarn.jar=${SPARK_HOME}/lib/spark-assembly-1.1.0-hadoop2.4.0.jar -jar build/libs/batch-demo-0.1.0.jar dataPath=/Users/trisberg/Projects/BHUG/data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10
