$installedApps = Get-WmiObject -Class Win32_Product | Where-Object { $_.Name -like "*SQL*" } | Select-Object -Property Name,Version

if ($installedApps) {
    $installedApps | Export-Csv -Path "$PSScriptRoot\sql_apps.csv" -NoTypeInformation
    Write-Host "CSV file created with SQL applications."
} else {
    Write-Host "No SQL applications found."
}