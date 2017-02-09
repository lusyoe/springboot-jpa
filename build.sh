#!/bin/bash

source /etc/profile

docker login -u admin -p admin123

mvn package -e -X docker:build -DskipTest

docker run -dp 9090:8080 springboot-jpa-0.0.1

