batch-demo
==========

Build with:

    gradle clean build

    (also, build the spark-hashtags project using `mvn clean package` before running the batch job)

For local execution run with:

    java -jar build/libs/batch-demo-0.1.0.jar dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10

For Spark cluster run with (master=spark://host:port)

    java -jar build/libs/batch-demo-0.1.0.jar master=spark://borneo:7077 dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10

For 'yarn-client' run with:

    export SPARK_HOME=<path-to-your-spark-hadoop-install>
    export HADOOP_CONF_DIR=src/main/resources
    java -Dspark.yarn.jar=${SPARK_HOME}/lib/spark-assembly-1.1.0-hadoop2.4.0.jar -jar build/libs/batch-demo-0.1.0.jar master=yarn-client dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=hdfs://borneo:8020/tweets/input outputDir=hdfs://borneo:8020/tweets/top10
