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

    public int buscaSequencial(int numero) {
        for (int i = 0; i < tamanhoAtualDoVetor; i++) {
            int ElementoAtual = vetor[i];
            if (numero == ElementoAtual) {
                return i;
            }
        }
        return -1;
    }

    public void bubbleSort() {
        for (int i = 0; i < tamanhoAtualDoVetor - 1; i++) {
            for (int j = 0; j < tamanhoAtualDoVetor - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}