#include <iostream>

#define TAM 10

using namespace std;

void bubbleSort(int V[TAM])
{
    int aux;

    for (int i = 0; i < TAM; i++)
    {
        for (int k = 0; k < TAM; k++)
        {
            if (V[i] < V[k])
            {
                aux = V[i];
                V[i] = V[k];
                V[k] = aux;
            }
        }
    }
}

void imprimir(int V[TAM])
{
    for (int i = 0; i < TAM; i++)
    {
        cout << V[i] << " ";
    }
}

int main()
{
    int prueba[] = {6, 7, 2, 5, 19, 8, 1, 9, 3, 10};
    imprimir(prueba);
    bubbleSort(prueba);
    cout << "\n";
    imprimir(prueba);
}
