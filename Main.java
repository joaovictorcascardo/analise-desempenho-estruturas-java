public class Main {
    public static void main(String[] args) {
        Vetor novoVetor = new Vetor(4);
        novoVetor.insere(10);
        novoVetor.insere(10);
        novoVetor.imprime();
        int indiceEncontrado = novoVetor.buscaSequencial(10);
        System.out.println("Elemento encontrado no índice: " + indiceEncontrado);
    }
}