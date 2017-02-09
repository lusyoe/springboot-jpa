#!/bin/bash

source /etc/profile

MYIMAGE=192.168.1.2:8082/springboot/springboot-jpa

docker login 192.168.1.2:8082 -u admin -p admin123

mvn package -e -X docker:build -DskipTest

docker stop ${MYIMAGE}

docker run -dp 9090:8080 --name springboot-jpa ${IMAGE}


