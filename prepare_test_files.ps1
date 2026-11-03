param (
    [string]$A11yServer,
    [string]$NoA11yServer
)

if (-not $A11yServer -or -not $NoA11yServer) {
    Write-Host "Usage: .\prepare_test_files.ps1 <A11yServer> <NoA11yServer>"
    exit 1
}

$files = Get-ChildItem -Recurse -Filter "*TestCafe.js" | Where-Object { $_.FullName -notmatch "node_modules" }

# The copies write "]]>" as "]]\>", the same string at runtime. A literal "]]>" in code that TestCafe
# quotes in a warning or failure would end the CDATA section of the xunit report early.
foreach ($file in $files) {
    Write-Host "Processing file: $file"
    
    $content = Get-Content $file.FullName -Raw
    $firstLine = (Get-Content $file.FullName -TotalCount 1)
    
    $name = $file.BaseName
    if ($firstLine -match "^//@nonConcurrent") {
        $newName = "$name-NonConcurrent"
    } else {
        $newName = "$name-Concurrent"
    }

    # NO-A11Y
    $noA11yContent = $content -creplace 'TestCafe', 'TestCafe(NO-A11y)' -replace 'localhost:8080', $NoA11yServer -creplace '\]\]>', ']]\>'
    $noA11yContent | Set-Content (Join-Path $file.DirectoryName "$newName-NoA11y.js")

    # A11Y
    $a11yContent = $content -creplace 'TestCafe', 'TestCafe(A11y)' -replace 'localhost:8080', $A11yServer -creplace '\]\]>', ']]\>'
    $a11yContent | Set-Content (Join-Path $file.DirectoryName "$newName-A11y.js")

    Remove-Item $file.FullName
}