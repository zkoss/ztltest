#!/bin/bash
mvn compile -DskipTests=true
mvn surefire:test -P testcafe