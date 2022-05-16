#!/bin/bash
set -e
printenv
java -jar foodApp-0.0.1-SNAPSHOT.jar --spring.profiles.active=${profile}