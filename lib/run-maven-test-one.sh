#!/bin/bash
echo "params=\"$1\" \"$2\" \"$3\" "
mvn surefire:test -Dtest.dir="$1" -Dbrowser="$2" -Dtest="$3"
