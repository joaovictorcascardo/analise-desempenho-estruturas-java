public class Main {
    public static void main(String[] args) {
        AnaliseVetor analisador = new AnaliseVetor();

        analisador.executarTesteParaTamanho(100);

        analisador.executarTesteParaTamanho(1000);

        analisador.executarTesteParaTamanho(10000);
    }
}