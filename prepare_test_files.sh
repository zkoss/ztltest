#!/bin/bash

A11Y_SERVER="$1"
NO_A11Y_SERVER="$2"

if [ -z "$A11Y_SERVER" ] || [ -z "$NO_A11Y_SERVER" ]; then
    echo "Usage: $0 <A11Y_SERVER> <NO_A11Y_SERVER>"
    exit 1
fi

find . -name "*TestCafe.js" -type f | while read -r file
do
    echo "Processing file: $file"
    
    name="${file%.*}"

    if head -n 1 "$file" | grep -q "^//@nonConcurrent"; then
        new_name="${name}-NonConcurrent"
    else
        new_name="${name}-Concurrent"
    fi

    # ---- NO-A11Y ----
    sed -E "s/TestCafe/TestCafe(NO-A11y)/g" "$file" \
    | sed "s/localhost:8080/${NO_A11Y_SERVER}/g" \
    > "${new_name}-NoA11y.js"

    # ---- A11Y ----
    if [[ "$OSTYPE" == "darwin"* ]]; then
        # macOS
        sed -i "" "s/TestCafe/TestCafe(A11y)/g" "$file"
        sed -i "" "s/localhost:8080/${A11Y_SERVER}/g" "$file"
    else
        # Linux
        sed -i "s/TestCafe/TestCafe(A11y)/g" "$file"
        sed -i "s/localhost:8080/${A11Y_SERVER}/g" "$file"
    fi

    mv "$file" "${new_name}-A11y.js"
done