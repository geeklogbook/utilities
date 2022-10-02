#include <stdio.h>

void commaOperator(void){
    int a, b, c;
    printf("Select Two numbers: ");
    scanf("%d %d", &a, &b);
    c = (a >= b, 50);
    printf("%d", c);
}