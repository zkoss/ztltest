#!/bin/bash
mvn surefire:test -Dreport.dir=$1 -Dtest.dir=$2