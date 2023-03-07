package Universidade;

public enum TipoDisciplina {
    /*ENUM que será implementado na classe Disciplina,
    onde ficarão disponíveis as opções de matéria optativa ou obrigatória
     */
    Obrigatoria(4),
    Optativa(2);

    final int valor;

    TipoDisciplina(int valor) {
        this.valor = valor;
    }
}
