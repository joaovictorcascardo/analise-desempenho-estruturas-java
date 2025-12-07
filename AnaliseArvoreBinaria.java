public class AnaliseArvoreBinaria {

    public void executarTesteParaTamanho(int tamanho) {
        System.out.println("\n==================================================");
        System.out.println("   ANALISANDO ARVORE BINARIA COM " + tamanho + " ELEMENTOS");
        System.out.println("==================================================");

        rodarCenario(tamanho, "Ordenada");
        rodarCenario(tamanho, "Inversa");
        rodarCenario(tamanho, "Aleatória");
    }

    private void rodarCenario(int tamanho, String tipoOrdenacao) {
        long somaInsercao = 0;
        long somaBusca = 0;

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
            ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
            long inicio = System.nanoTime();
            for (int val : dados) {
                arvore.insere(val);
            }
            somaInsercao += (System.nanoTime() - inicio);
            somaBusca += medirBuscas(arvore, dados);
        }

        System.out.println("Cenário: " + tipoOrdenacao);
        imprimirTempo("Inserção", somaInsercao, repeticoes);
        imprimirTempo("Busca", somaBusca, repeticoes);
        System.out.println("---------------------------------------");
    }

    private long medirBuscas(ArvoreBinariaBusca arvore, int[] dadosOriginais) {
        long inicio = System.nanoTime();
        int n = dadosOriginais.length;
        arvore.busca(dadosOriginais[0]);
        arvore.busca(dadosOriginais[n - 1]);
        arvore.busca(dadosOriginais[n / 2]);
        arvore.busca(-12345);

        return System.nanoTime() - inicio;
    }

    private void imprimirTempo(String operacao, long tempoTotalNano, int repeticoes) {
        double mediaMs = (tempoTotalNano / (double) repeticoes) / 1_000_000.0;
        System.out.printf("  > %-20s: %.4f ms%n", operacao, mediaMs);
    }
}