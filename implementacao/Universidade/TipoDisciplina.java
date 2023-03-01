package Universidade;

public enum TipoDisciplina {
    Obrigatoria(4),
    Optativa(2);

    final int valor;

    TipoDisciplina(int valor) {
        this.valor = valor;
    }
}
