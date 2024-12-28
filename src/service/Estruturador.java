package service;

import model.Usuarios;

import java.util.List;

public class Estruturador {
    public void quickSort(List<Usuarios> lista, int esquerda, int direita){
        if (esquerda < direita){
            int p = particao(lista, esquerda, direita);
            quickSort(lista, esquerda, p - 1);
            quickSort(lista, p + 1, direita);
        }
    }

    public int particao(List<Usuarios> lista, int esquerda, int direita){
        String pivo = lista.get(direita).getNome();
        int i = esquerda - 1;
        for (int j = esquerda; j < direita; j++){
            if (lista.get(j).getNome().compareTo(pivo) < 0){
                i++;
                Usuarios tmp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, tmp);
            }
        }
        i++;
        Usuarios tmp = lista.get(i);
        lista.set(i, lista.get(direita));
        lista.set(direita, tmp);
        return i;
    }

    public int Bbin(List<Usuarios> lista, String nomeBusca, int ini, int fim){
        int meio;
        while (ini <= fim){
            meio = (int)((ini + fim) / 2);
            if (lista.get(meio).getNome().compareTo(nomeBusca) == 0){
                return meio;
            }else if (lista.get(meio).getNome().compareTo(nomeBusca) < 0){
                ini = meio + 1;
            }else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}
