public class Main {
    public static void main(String[] args) {
        System.out.println("##################################################");
        System.out.println("              INICIANDO BATERIA: VETORES");
        System.out.println("##################################################");

        AnaliseVetor analiseVetor = new AnaliseVetor();
        analiseVetor.executarTesteParaTamanho(100);
        analiseVetor.executarTesteParaTamanho(1000);
        analiseVetor.executarTesteParaTamanho(10000);

        System.out.println("\n\n");
        System.out.println("##################################################");
        System.out.println("          INICIANDO BATERIA: ARVORE BINARIA");
        System.out.println("##################################################");

        AnaliseArvoreBinaria analiseArvore = new AnaliseArvoreBinaria();
        analiseArvore.executarTesteParaTamanho(100);
        analiseArvore.executarTesteParaTamanho(1000);
        analiseArvore.executarTesteParaTamanho(10000);

        System.out.println("\n\n");
        System.out.println("##################################################");
        System.out.println("            INICIANDO BATERIA: ARVORE AVL");
        System.out.println("##################################################");

        AnaliseAVL analiseAVL = new AnaliseAVL();
        analiseAVL.executarTesteParaTamanho(100);
        analiseAVL.executarTesteParaTamanho(1000);
        analiseAVL.executarTesteParaTamanho(10000);
    }
}