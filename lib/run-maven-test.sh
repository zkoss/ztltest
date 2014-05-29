#!/bin/bash
echo "params=\"$1\" \"$2\""
mvn surefire:test -Dreport.dir="$1" -Dtest.dir="$2"