import java.util.Random;

public class GeradorDados {
    private static final long SEED = 42;

    public static int[] gerarOrdenado(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++)
            dados[i] = i;
        return dados;
    }

    public static int[] gerarInverso(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++)
            dados[i] = tamanho - 1 - i;
        return dados;
    }

    public static int[] gerarAleatorio(int tamanho) {
        int[] dados = new int[tamanho];
        Random random = new Random(SEED);
        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 2);
        }
        return dados;
    }
}