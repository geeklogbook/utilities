//Page 12 conversion
#include <stdio.h>

int main()
{
    int fahr, celsius;
    int lower, upper, step;

    lower = 0;
    upper = 300;
    step = 20;

    fahr = lower;
    printf("%-15s| %-15s\n", "Fahrenheit", "Celsius");
    printf("-----------------------------------\n");
    while (fahr <= upper) {
        celsius= 5 * (fahr - 32) / 9;
        printf("%-15d| %-15d\n", fahr, celsius);
        fahr = fahr + step;
    }
}