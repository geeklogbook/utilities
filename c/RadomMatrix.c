#include <stdlib.h>
#include <stdio.h>

int randomMatrix()
{
    for (int i = 0; i < 10; i++)
    {
        int randNumber = rand() % 8;
        printf("%d ", randNumber);
    }
}

void main()
{
    randomMatrix();
}
