package Universidade;

public enum TipoDisciplina {
    Obrigatoria(4),
    Optativa(2);

    int valor;

    TipoDisciplina(int valor) {
        this.valor = valor;
    }
}
