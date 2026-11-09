param (
    [string]$A11yServer,
    [string]$NoA11yServer
)

if (-not $A11yServer -or -not $NoA11yServer) {
    Write-Host "Usage: .\prepare_test_files.ps1 <A11yServer> <NoA11yServer>"
    exit 1
}

# The theme a server renders: ZK writes zk.themeName into every page. An empty result (server not reachable) skips
# nothing.
function Get-ServerTheme([string]$server) {
    try {
        $page = Invoke-WebRequest -UseBasicParsing -TimeoutSec 30 "http://$server/zktest/ztl.zul"
        if ($page.Content -match "zk\.themeName='([^']*)'") { return $Matches[1] }
    } catch { }
    return ""
}

$a11yTheme = Get-ServerTheme $A11yServer
$noA11yTheme = Get-ServerTheme $NoA11yServer
Write-Host "Theme of ${A11yServer}: $(if ($a11yTheme) { $a11yTheme } else { 'unknown' }); theme of ${NoA11yServer}: $(if ($noA11yTheme) { $noA11yTheme } else { 'unknown' })"

# A test marked //@iceblueOnly runs only on a server whose theme is iceblue: for any other server it gets no copy,
# so no job runs it there.
function Test-Skipped([bool]$iceblueOnly, [string]$theme) {
    return $iceblueOnly -and $theme -and $theme -ne "iceblue"
}

$files = Get-ChildItem -Recurse -Filter "*TestCafe.js" | Where-Object { $_.FullName -notmatch "node_modules" }

# The copies write "]]>" as "]]\>", the same string at runtime. A literal "]]>" in code that TestCafe
# quotes in a warning or failure would end the CDATA section of the xunit report early.
foreach ($file in $files) {
    Write-Host "Processing file: $file"
    
    $content = Get-Content $file.FullName -Raw
    $firstLines = @(Get-Content $file.FullName -TotalCount 3)
    $iceblueOnly = [bool]($firstLines -match "^//@iceblueOnly")
    
    $name = $file.BaseName
    if ($firstLines -match "^//@nonConcurrent") {
        $newName = "$name-NonConcurrent"
    } else {
        $newName = "$name-Concurrent"
    }

    # NO-A11Y
    if (Test-Skipped $iceblueOnly $noA11yTheme) {
        Write-Host "Skipped (IceBlue-only, theme is $noA11yTheme): $file NO-A11y"
    } else {
        $noA11yContent = $content -creplace 'TestCafe', 'TestCafe(NO-A11y)' -replace 'localhost:8080', $NoA11yServer -creplace '\]\]>', ']]\>'
        $noA11yContent | Set-Content (Join-Path $file.DirectoryName "$newName-NoA11y.js")
    }

    # A11Y
    if (Test-Skipped $iceblueOnly $a11yTheme) {
        Write-Host "Skipped (IceBlue-only, theme is $a11yTheme): $file A11y"
    } else {
        $a11yContent = $content -creplace 'TestCafe', 'TestCafe(A11y)' -replace 'localhost:8080', $A11yServer -creplace '\]\]>', ']]\>'
        $a11yContent | Set-Content (Join-Path $file.DirectoryName "$newName-A11y.js")
    }

    Remove-Item $file.FullName
}