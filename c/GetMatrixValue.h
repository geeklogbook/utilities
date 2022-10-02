#include <stdio.h>

float get_value_at(float mat[][4], int id)
{
    return mat[id / 4][id% 4];
}

void getMatrixValue()
{
    float mat[2][4] = 
    {
        {1,2,3,4},
        {5,6,7,8},
    };

    float value0 = get_value_at(mat, 5);
    printf("%f\n", value0);

    float value1 = get_value_at(mat, 0);
    printf("%f\n", value1);
}