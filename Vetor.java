public class Vetor {
    private int[] vetor;
    private int tamanhoAtualDoVetor;

    public Vetor(int capacidadeMaximaDoVetor) { 
        this.vetor = new int[capacidadeMaximaDoVetor]; 
        this.tamanhoAtualDoVetor = 0; 
    }
}