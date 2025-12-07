# 📊 Análise de Desempenho de Estruturas de Dados

Este projeto foi desenvolvido como requisito avaliativo da disciplina de **Estrutura de Dados** do curso de **Análise e Desenvolvimento de Sistemas** (FAMINAS).

O objetivo principal é implementar "do zero" (sem uso de bibliotecas de coleções nativas) e comparar o desempenho de três estruturas de dados fundamentais em cenários de estresse computacional.

## 🚀 Estruturas Analisadas

1.  **Vetor (Array):** Implementação de lista contígua com redimensionamento manual.
    - _Algoritmos de Ordenação:_ Bubble Sort ($O(n^2)$) e Quick Sort ($O(n \log n)$).
    - _Algoritmos de Busca:_ Sequencial e Binária.
2.  **Árvore Binária de Busca (ABB):** Estrutura hierárquica sem balanceamento.
3.  **Árvore AVL:** Árvore binária de busca auto-balanceada (rotações automáticas).

## 🧪 Metodologia de Teste

Para garantir a precisão da análise, o sistema executa baterias de testes automatizados considerando:

- **Volumes de Dados:** 100, 1.000 e 10.000 elementos.
- **Cenários de Entrada:**
  - _Ordenado:_ Simula o pior caso para árvores não balanceadas.
  - _Inverso:_ Testa o custo máximo de reordenação.
  - _Aleatório:_ Simula o cenário real (Seed fixa `42` para reprodutibilidade).
- **Métricas:** Tempo de execução medido em nanossegundos (`System.nanoTime`) com média aritmética de 5 execuções por cenário para mitigar ruídos do Sistema Operacional e da JVM.

## 📂 Estrutura do Projeto

O código-fonte está organizado da seguinte forma:

```text
/
├── Main.java                  # Ponto de entrada (Gerencia a bateria de testes)
├── GeradorDados.java          # Classe utilitária para criar vetores de teste
├── AnaliseVetor.java          # Lógica de teste para Vetores (Ordenação/Busca)
├── AnaliseArvoreBinaria.java  # Lógica de teste para ABB
├── AnaliseAVL.java            # Lógica de teste para AVL
│
├── /Estruturas                # Implementações das Estruturas de Dados
│   ├── /Vetor
│   │   └── Vetor.java
│   ├── /ArvoreDeBuscaBinaria
│   │   └── ArvoreBinariaBusca.java
│   └── /ArvoreAVL
│       └── ArvoreAVL.java
│
└── README.md                  # Documentação do projeto
```
