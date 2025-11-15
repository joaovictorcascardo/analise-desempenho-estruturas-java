public class Vetor {
    private int[] vetor;
    private int tamanhoAtualDoVetor;

    public Vetor(int capacidadeMaximaDoVetor) {
        this.vetor = new int[capacidadeMaximaDoVetor];
        this.tamanhoAtualDoVetor = 0;
    }

    public void insere(int numero) {
        if (vetor.length == tamanhoAtualDoVetor) {
            System.out.println("Erro: Vetor está cheio!");
        } else {
            vetor[tamanhoAtualDoVetor] = numero;
            tamanhoAtualDoVetor++;
        }
    }

    public void imprime() {
        for (int i = 0; i < tamanhoAtualDoVetor; i++) {
            System.out.println(vetor[i]);
        }
    }
}