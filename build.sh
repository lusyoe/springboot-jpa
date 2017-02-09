#!/bin/bash

source /etc/profile

mvn package -e -X docker:build

docker run -dp 9090:8080 springboot-jpa-0.0.1

