#include <stdlib.h>
#include <stdio.h>

int RemoveZero(int n){
    int numero = n;
    char buffer[20];
    sprintf(buffer, "%d", numero);

    int i = 0;
    int last = 0;
    for(i =0; buffer[i];i++){
        if(buffer[i] != '0'){
            last = i;
        }
    }

    int j = 0;
    for(i = 0; i <= last; i++){
        if(buffer[i] != '0'){
            buffer[j++] = buffer[i];
        }
    }

    while(buffer[i]){
        buffer[j++] = buffer[i++];
    }
    buffer[j] = 0;

    int valor = atoi(buffer);

    return valor;
}