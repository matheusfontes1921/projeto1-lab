package Universidade;

public enum TipoDisciplina {
    /*ENUM que será implementado na classe Disciplina,
    onde ficarão disponíveis as opções de matéria optativa ou obrigatória
     */
    Obrigatoria("obrigatoria"),
    Optativa("optativa");

    private final String  valor;

    TipoDisciplina(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
