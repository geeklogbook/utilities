//1-7 - Write a program to print the value of EOF

#include <stdio.h>

int main()
{
    int c;
    while (c= getchar() != EOF)
    {
        printf("%d\n", EOF);
    }
}