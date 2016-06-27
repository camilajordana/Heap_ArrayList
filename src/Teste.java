public class Teste {

    public static void main(String[] args) {
        Heap my_heap = new Heap();
        // {5, 6, 10, 11, 30, 28, 15, 9, 14, 13, 7, 8, 20, 19, 12, 23, 25}
        
        my_heap.inserir(5);
        my_heap.inserir(6);
        my_heap.inserir(10);
        my_heap.inserir(11);
        my_heap.inserir(30);
        my_heap.inserir(28);
        my_heap.inserir(15);
        my_heap.inserir(9);
        my_heap.inserir(14);
        my_heap.inserir(13);
        my_heap.inserir(7);
        my_heap.inserir(8);
        my_heap.inserir(20);
        my_heap.inserir(19);
        my_heap.inserir(12);
        my_heap.inserir(23);
        my_heap.inserir(25);
        
        
        my_heap.exibir();
    }
    
}
