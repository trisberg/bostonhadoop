batch-demo
==========

Build and run with:

    gradle clean build
    java -jar build/libs/batch-demo-0.1.0.jar dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10

For 'yarn-client' run with:

    export SPARK_HOME=<path-to-your-spark-hadoop-install>
    export HADOOP_CONF_DIR=src/main/resources
    java -Dspark.yarn.jar=${SPARK_HOME}/lib/spark-assembly-1.1.0-hadoop2.4.0.jar -jar build/libs/batch-demo-0.1.0.jar dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10
