#!/bin/sh

#set -x # Echo all commands
set -e # Stop on exit code != 0 immediately

java -version

export MAVEN_OPTS="${MAVEN_OPTS} -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn"
export MAVEN_OPTS="${MAVEN_OPTS} -Dmaven.color=false"
export MAVEN_OPTS="${MAVEN_OPTS} -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
export SPRING_PROFILES_ACTIVE=ci

./mvnw -B verify --settings mvn-settings.xml 2>&1

echo "build.sh has finished."