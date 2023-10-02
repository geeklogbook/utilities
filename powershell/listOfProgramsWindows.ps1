$installedApps = Get-WmiObject -Class Win32_Product | Select-Object -Property Name,Version

if ($installedApps) {
    $installedApps | Export-Csv -Path "$PSScriptRoot\installed_apps.csv" -NoTypeInformation
} else {
    Write-Host "No installed applications found."
}