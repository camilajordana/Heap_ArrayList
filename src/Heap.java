

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> elementos = new ArrayList();
    int quantidade = 0;
    public Heap() {
        // A primeira posição do array é responsável por guardar a quantidade de 
        // elementos do array
        elementos.add(0);
    }

    public void inserir(Integer chave) {
        elementos.add(chave);
        quantidade++;
        elementos.set(0, quantidade);
        upheap(quantidade);
    }

    public void upheap(int indice) {
        while (indice != 1) {
            if (elementos.get(indice) < elementos.get(indice / 2)) {
                troca_Pai_E_Filho(indice, indice / 2);
                indice = indice / 2;
                upheap(indice);
            }
            break;
        }
    }

    public void troca_Pai_E_Filho(int indiceFilho, int indicePai) {
        Integer auxiliar = elementos.get(indiceFilho);
        elementos.set(indiceFilho, elementos.get(indicePai));
        elementos.set(indicePai, auxiliar);
    }

    public void removeMin() {
        elementos.set(1, elementos.get(quantidade));
        elementos.remove(quantidade);
        quantidade--;
        elementos.set(0, quantidade);
        if(quantidade != 0){
            downheap(1);
        } else {
            System.out.println("Todos os elementos foram removidos");
        }
    }

    public void downheap(int indice) {

        if (quantidade != indice) { // Se tiver filhos
            if (quantidade != indice * 2 + 1) { // Caso não tenho filho direito
                int indice_do_pai_atual = elementos.get(indice);
                int indice_do_filho_esquerdo = elementos.get(indice * 2);
                if (indice_do_pai_atual > indice_do_filho_esquerdo) {
                    troca_Pai_E_Filho(indice * 2, indice);
                    downheap(indice * 2);
                }
            } else {
                int indice_do_pai_atual = elementos.get(indice);
                int indice_do_filho_esquerdo = elementos.get(indice * 2);
                int indice_do_filho_direito = elementos.get(indice * 2 + 1);
                if (indice_do_pai_atual > indice_do_filho_esquerdo && indice_do_filho_esquerdo < indice_do_filho_direito) {
                    //troca(indice_do_pai_atual, indice_do_filho_esquerdo);
                    troca_Pai_E_Filho(indice * 2, indice);
                    downheap(indice * 2);
                } else if (indice_do_pai_atual > indice_do_filho_direito && indice_do_filho_direito < indice_do_filho_esquerdo) {
                    //troca(indice_do_pai_atual, indice_do_filho_direito);
                    troca_Pai_E_Filho(indice * 2 + 1, indice);
                    downheap(indice * 2 + 1);
                }
            }
        }

    }

    public void exibirArray() {
        for (int i = 1; i <= quantidade; i++) {
            System.out.print(elementos.get(i) + " ");
        }
    }

}
