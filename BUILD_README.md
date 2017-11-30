Building nucleus-gateway
==============

## Prerequisites

- Gradle 2.7 or latest version
- Java 8
- Kafka Producer 0.10.1.1

## Running Build

The default task is *shadowJar* which is provided by plugin. So running *gradle* from command line will run *shadowJar* and it will create a fat jar in build/libs folder. Note that there is artifact name specified in build file and hence it will take the name from directory housing the project.

Once the far Jar is created, it could be run as any other Java application.

## Create kafka topic (single node)

> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

NOTE : Multinode cluster config can be changed. For more info : https://kafka.apache.org/0100/documentation.html

## Running the Jar as an application

Following command could be used, from the base directory.

Note that any options that need to be passed onto Vertx instance need to be passed at command line e.g, worker pool size etc

> java -classpath ./build/libs/nucleus-insights-events-gateway-0.1-snapshot-fat.jar: -Dvertx.metrics.options.enabled=true -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory io.vertx.core.Launcher -conf src/main/resources/nucleus-data-class-writer.json

There is no cluster specific configuration for gateway.
