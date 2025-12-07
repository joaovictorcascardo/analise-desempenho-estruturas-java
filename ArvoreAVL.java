public class ArvoreAVL {

    private class No {
        int valor;
        int altura;
        No esquerda, direita;

        public No(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    private No raiz;

    public void insere(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    public boolean busca(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private int getAltura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int getFatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.esquerda) - getAltura(no.direita);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        } else {
            return atual;
        }

        atual.altura = 1 + Math.max(getAltura(atual.esquerda), getAltura(atual.direita));

        int balanceamento = getFatorBalanceamento(atual);

        if (balanceamento > 1 && valor < atual.esquerda.valor) {
            return rotacaoDireita(atual);
        }

        if (balanceamento < -1 && valor > atual.direita.valor) {
            return rotacaoEsquerda(atual);
        }

        if (balanceamento > 1 && valor > atual.esquerda.valor) {
            atual.esquerda = rotacaoEsquerda(atual.esquerda);
            return rotacaoDireita(atual);
        }

        if (balanceamento < -1 && valor < atual.direita.valor) {
            atual.direita = rotacaoDireita(atual.direita);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        } else {
            return buscarRecursivo(atual.direita, valor);
        }
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }
}