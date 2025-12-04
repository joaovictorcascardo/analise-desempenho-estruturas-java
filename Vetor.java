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

    public void quickSort() {
        ordenarQuickSort(0, this.tamanhoAtualDoVetor - 1);
    }

    private void ordenarQuickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);

            ordenarQuickSort(inicio, indicePivo - 1);
            ordenarQuickSort(indicePivo, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int pivo = this.vetor[(inicio + fim) / 2];
        int esquerda = inicio;
        int direita = fim;

        while (esquerda <= direita) {
            while (this.vetor[esquerda] < pivo) {
                esquerda++;
            }
            while (this.vetor[direita] > pivo) {
                direita--;
            }

            if (esquerda <= direita) {
                trocar(esquerda, direita);
                esquerda++;
                direita--;
            }
        }
        return esquerda;
    }

    private void trocar(int i, int j) {
        int temp = this.vetor[i];
        this.vetor[i] = this.vetor[j];
        this.vetor[j] = temp;
    }

    public int buscaBinaria(int numero) {
        int inicio = 0;
        int fim = tamanhoAtualDoVetor - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (vetor[meio] == numero) {
                return meio;
            }
            if (vetor[meio] < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}