public class AnaliseAVL {

    public void executarTesteParaTamanho(int tamanho) {
        System.out.println("\n==================================================");
        System.out.println("   ANALISANDO ARVORE AVL COM " + tamanho + " ELEMENTOS");
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

            ArvoreAVL avl = new ArvoreAVL();

            long inicio = System.nanoTime();
            for (int val : dados) {
                avl.insere(val);
            }
            somaInsercao += (System.nanoTime() - inicio);

            somaBusca += medirBuscas(avl, dados);
        }

        System.out.println("Cenário: " + tipoOrdenacao);
        imprimirTempo("Inserção", somaInsercao, repeticoes);
        imprimirTempo("Busca", somaBusca, repeticoes);
        System.out.println("---------------------------------------");
    }

    private long medirBuscas(ArvoreAVL avl, int[] dadosOriginais) {
        long inicio = System.nanoTime();
        int n = dadosOriginais.length;

        avl.busca(dadosOriginais[0]);
        avl.busca(dadosOriginais[n - 1]);
        avl.busca(dadosOriginais[n / 2]);

        avl.busca(dadosOriginais[(n * 2) / 10]);
        avl.busca(dadosOriginais[(n * 6) / 10]);
        avl.busca(dadosOriginais[(n * 8) / 10]);

        avl.busca(-12345);

        return System.nanoTime() - inicio;
    }

    private void imprimirTempo(String operacao, long tempoTotalNano, int repeticoes) {
        double mediaMs = (tempoTotalNano / (double) repeticoes) / 1_000_000.0;
        System.out.printf("  > %-20s: %.4f ms%n", operacao, mediaMs);
    }
}