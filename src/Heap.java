
import java.util.ArrayList;

public class Heap {

    
    // 1º: cria um arrayList
    
    private ArrayList<Integer> elementos = new ArrayList();

    private int qtd;
    
    public Heap(){
        //Adicionando 0 ao primeiro elemento do array.
        elementos.add(0);
    }
    
    public void inserir(Integer key){
        elementos.add(key);
        qtd++;
        elementos.set(0, qtd);
        upheap(qtd);
    }
    
    public void upheap(int indice){
        //System.out.println(indice);
        while(indice != 1){
            if(elementos.get(indice) < elementos.get(indice/2)){
                troca(indice, indice/2);
                indice = indice/2;
                upheap(indice);
            }
            break;
        }
    }
    
    public void troca(int indice_pai, int indice_filho){
        Integer auxiliar = elementos.get(indice_filho);
        elementos.set(indice_filho, elementos.get(indice_pai));
        elementos.set(indice_pai, auxiliar);
    }
    
    
    public void exibir(){
        for(int i = 1; i <= qtd; i++) System.out.print(elementos.get(i) + " ");
    }
    
    public void remover(){
        elementos.set(1, elementos.get(qtd));
        elementos.remove(qtd);
        qtd--;
        elementos.set(0, qtd);
        downheap(1);
    }
    
    public void downheap(int indice){
        if(indice*2 < qtd){
            int indice_do_pai_atual = elementos.get(indice);
            int indice_do_filho_esquerdo = elementos.get(indice*2);
            int indice_do_filho_direito = elementos.get(indice*2+1);
            if(indice_do_pai_atual > indice_do_filho_esquerdo && indice_do_filho_esquerdo < indice_do_filho_direito){
                //troca(indice_do_pai_atual, indice_do_filho_esquerdo);
                troca(indice*2, indice);
                downheap(indice*2);
            } else if(indice_do_pai_atual > indice_do_filho_direito && indice_do_filho_direito < indice_do_filho_esquerdo){
                //troca(indice_do_pai_atual, indice_do_filho_direito);
                troca(indice*2+1, indice);
                downheap(indice*2+1);
            }
        }
    }
    
}
