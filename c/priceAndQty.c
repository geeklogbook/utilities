// Used for that question: https://stackoverflow.com/questions/74091834/getting-an-error-code-lnk2019-while-running-that-code-not-able-to-figure-out-wh

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{

    int qty, price, total_exp, discount = 10;

    printf("\nenter qty: ");
    scanf_s("%d", &qty);
    printf("Entered qty: %d\n", qty);

    printf("enter the price: \n");
    scanf_s("%d", &price);
    printf("Entered price: %d\n", price);

    if (qty > 1000)
    {
        total_exp = (qty * price * discount) / 100;
        printf("total_exp: %d\n", total_exp);
    }
    else
    {
        total_exp = qty * price;
        printf("total_exp: %d\n", total_exp);
    }
    getch();
    return 0;
}