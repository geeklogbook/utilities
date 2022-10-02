#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h> 

const int PAISES = 6;
const int BIMESTRE = 6;
const int MAXNUMERO = 11000;


void CargarPaisesSinRepetir(int matriz[PAISES][BIMESTRE]){
    int i; //Paises
    int k; //Bimestre

    bool asignado[MAXNUMERO];
    memset(asignado, false, MAXNUMERO * sizeof(bool));

    for (i = 0; i < PAISES;i++){
        for(k=0;k<BIMESTRE;k++){
            int num;
            do {
                do {
                    num = rand() % MAXNUMERO;
                } while (num %2 != 0);
            } while (asignado[num]);
            asignado[num] = true;
            matriz[i][k] = num;
            printf("%i - ", matriz[i][k]);
        }
        printf("\n");
    }
}
