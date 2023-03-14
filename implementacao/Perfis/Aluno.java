package Perfis;

import Universidade.Disciplina;
import Universidade.TipoDisciplina;

public class Aluno extends Usuario {
    private final Integer MaxOBRIGATORIAS = 4;
    private final Integer MaxOPTATIVAS = 2;


    private Integer numObrigatorias = 0;
    private Integer numOptativas = 0;
    private Integer valorMensalidade;


    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha);
    }


    /**
     * Método que adiciona uma disciplina a grade do aluno
     *
     * @param disciplina A disciplina que será inserida
     */
    public void matricular(Disciplina disciplina) {
        disciplina.matricular(this);

        if (disciplina.getTipoDisciplina() == TipoDisciplina.Obrigatoria)
            numObrigatorias++;
        else
            numOptativas++;
    }

    /**
     * Retira a Disciplina da lista de disciplinas do aluno
     *
     * @param disciplina O aluno será removido da disciplina
     */
    public void cancelarMatricula(Disciplina disciplina) {
        disciplina.removerAluno(this);

        if (disciplina.getTipoDisciplina() == TipoDisciplina.Obrigatoria)
            numObrigatorias--;
        else
            numOptativas--;
    }

    public void setNumObrigatorias(Integer numObrigatorias) {
        this.numObrigatorias = numObrigatorias;
    }

    public boolean disciplinaIsMax(TipoDisciplina tipo) {
        if (tipo == TipoDisciplina.Obrigatoria)
            return numObrigatorias <= MaxOBRIGATORIAS;
        else
            return numOptativas <= MaxOPTATIVAS;
    }

    public void setNumOptativas(Integer numOptativas) {
        this.numOptativas = numOptativas;
    }

    public void setValorMensalidade(Integer valor) {
        this.valorMensalidade = valor;
    }

    public Integer getValorMensalidade() {
        return valorMensalidade;
    }

    @Override
    public String dadosUsuario() {
        return "Aluno " + nome + " " + email + " " + senha;
    }

}

