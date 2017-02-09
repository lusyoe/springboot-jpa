#!/bin/bash

export M2_HOME=/opt/apache-maven-3.3.9
PATH=$PATH:$M2_HOME/bin

mvn package docker:build

docker run -dp 9090:8080 springboot-jpa-0.0.1

