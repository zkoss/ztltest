#!/bin/bash

A11Y_SERVER="$1"
NO_A11Y_SERVER="$2"

if [ -z "$A11Y_SERVER" ] || [ -z "$NO_A11Y_SERVER" ]; then
    echo "Usage: $0 <A11Y_SERVER> <NO_A11Y_SERVER>"
    exit 1
fi

# The theme a server renders: ZK writes zk.themeName into every page. An empty result (server not reachable) skips
# nothing.
server_theme() {
    curl -s --max-time 30 "http://$1/zktest/ztl.zul" | grep -o "zk\.themeName='[^']*'" | head -n 1 | cut -d"'" -f2
}

A11Y_THEME=$(server_theme "$A11Y_SERVER")
NO_A11Y_THEME=$(server_theme "$NO_A11Y_SERVER")
echo "Theme of $A11Y_SERVER: ${A11Y_THEME:-unknown}; theme of $NO_A11Y_SERVER: ${NO_A11Y_THEME:-unknown}"

# A test marked //@iceblueOnly runs only on a server whose theme is iceblue: for any other server it gets no copy,
# so no job runs it there.
skipped_on() {
    [ "$iceblue_only" = true ] && [ -n "$1" ] && [ "$1" != "iceblue" ]
}

# The copies write "]]>" as "]]\>", the same string at runtime. A literal "]]>" in code that TestCafe quotes in a
# warning or failure would end the CDATA section of the xunit report early.
find . -name "*TestCafe.js" -type f | while read -r file
do
    echo "Processing file: $file"

    name="${file%.*}"

    if head -n 3 "$file" | grep -q "^//@nonConcurrent"; then
        kind="NonConcurrent"
    else
        kind="Concurrent"
    fi
    if head -n 3 "$file" | grep -q "^//@iceblueOnly"; then
        iceblue_only=true
    else
        iceblue_only=false
    fi

    # ---- NO-A11Y ----
    if skipped_on "$NO_A11Y_THEME"; then
        echo "Skipped (IceBlue-only, theme is $NO_A11Y_THEME): $file NO-A11y"
    else
        sed -E "s/TestCafe/TestCafe(NO-A11y)/g" "$file" \
        | sed "s/localhost:8080/${NO_A11Y_SERVER}/g" \
        | sed 's/]]>/]]\\>/g' \
        > "${name}-${kind}-NoA11y.js"
    fi

    # ---- A11Y ----
    if skipped_on "$A11Y_THEME"; then
        echo "Skipped (IceBlue-only, theme is $A11Y_THEME): $file A11y"
        rm "$file"
        continue
    fi
    if [[ "$OSTYPE" == "darwin"* ]]; then
        # macOS
        sed -i "" "s/TestCafe/TestCafe(A11y)/g" "$file"
        sed -i "" "s/localhost:8080/${A11Y_SERVER}/g" "$file"
        sed -i "" 's/]]>/]]\\>/g' "$file"
    else
        # Linux
        sed -i "s/TestCafe/TestCafe(A11y)/g" "$file"
        sed -i "s/localhost:8080/${A11Y_SERVER}/g" "$file"
        sed -i 's/]]>/]]\\>/g' "$file"
    fi

    mv "$file" "${name}-${kind}-A11y.js"
done