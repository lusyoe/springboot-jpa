#!/bin/bash

source /etc/profile

mvn package docker:build

docker run -dp 9090:8080 springboot-jpa-0.0.1

