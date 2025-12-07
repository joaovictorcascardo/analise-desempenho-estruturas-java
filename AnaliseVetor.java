public class AnaliseVetor {

    public void executarTesteParaTamanho(int tamanho) {
        System.out.println("\n==================================================");
        System.out.println("   ANALISANDO VETOR COM " + tamanho + " ELEMENTOS");
        System.out.println("==================================================");

        rodarCenario(tamanho, "Ordenada");
        rodarCenario(tamanho, "Inversa");
        rodarCenario(tamanho, "Aleatória");
    }

    private void rodarCenario(int tamanho, String tipoOrdenacao) {
        long somaInsercao = 0;
        long somaBuscaSeq = 0;
        long somaBuscaBin = 0;
        long somaBubble = 0;
        long somaQuick = 0;

        int repeticoes = 5;

        for (int i = 0; i < repeticoes; i++) {
            int[] dados;
            if (tipoOrdenacao.equals("Ordenada")) {
                dados = GeradorDados.gerarOrdenado(tamanho);
            } else if (tipoOrdenacao.equals("Inversa")) {
                dados = GeradorDados.gerarInverso(tamanho);
            } else {
                dados = GeradorDados.gerarAleatorio(tamanho);
            }

            Vetor vetor = new Vetor(tamanho);
            long inicio = System.nanoTime();
            for (int val : dados) {
                vetor.insere(val);
            }
            somaInsercao += (System.nanoTime() - inicio);

            somaBuscaSeq += medirBuscas(vetor, dados, false);

            Vetor vBinaria = clonarVetor(tamanho, dados);
            vBinaria.quickSort();

            somaBuscaBin += medirBuscas(vBinaria, dados, true);

            Vetor vBubble = clonarVetor(tamanho, dados);
            inicio = System.nanoTime();
            vBubble.bubbleSort();
            somaBubble += (System.nanoTime() - inicio);

            Vetor vQuick = clonarVetor(tamanho, dados);
            inicio = System.nanoTime();
            vQuick.quickSort();
            somaQuick += (System.nanoTime() - inicio);
        }

        System.out.println("Cenário: " + tipoOrdenacao);
        imprimirTempo("Inserção", somaInsercao, repeticoes);
        imprimirTempo("Busca Sequencial", somaBuscaSeq, repeticoes);
        imprimirTempo("Busca Binária", somaBuscaBin, repeticoes);
        imprimirTempo("BubbleSort", somaBubble, repeticoes);
        imprimirTempo("QuickSort", somaQuick, repeticoes);
        System.out.println("---------------------------------------");
    }

    private long medirBuscas(Vetor vetor, int[] dadosOriginais, boolean ehBinaria) {
        long inicio = System.nanoTime();

        int n = dadosOriginais.length;
        int primeiro = dadosOriginais[0];
        int ultimo = dadosOriginais[n - 1];
        int meio = dadosOriginais[n / 2];
        int inexistente = -12345;

        if (ehBinaria) {
            vetor.buscaBinaria(primeiro);
            vetor.buscaBinaria(ultimo);
            vetor.buscaBinaria(meio);
            vetor.buscaBinaria(inexistente);
        } else {
            vetor.buscaSequencial(primeiro);
            vetor.buscaSequencial(ultimo);
            vetor.buscaSequencial(meio);
            vetor.buscaSequencial(inexistente);
        }

        return System.nanoTime() - inicio;
    }

    private Vetor clonarVetor(int tamanho, int[] dados) {
        Vetor v = new Vetor(tamanho);
        for (int val : dados) {
            v.insere(val);
        }
        return v;
    }

    private void imprimirTempo(String operacao, long tempoTotalNano, int repeticoes) {
        double mediaMs = (tempoTotalNano / (double) repeticoes) / 1_000_000.0;
        System.out.printf("  > %-20s: %.4f ms%n", operacao, mediaMs);
    }
}