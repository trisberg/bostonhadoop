batch-demo
==========

Build with:

    gradle clean build

    (also, build the spark-hashtags project using `mvn clean install` before running the batch job)

Run with:

    java -jar build/libs/batch-demo-0.1.0.jar dataPath=data/hadoop-tweets_2014-08-11.txt inputDir=/tweets/input outputDir=/tweets/counts

