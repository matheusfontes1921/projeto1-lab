package Universidade;

import Perfis.Aluno;
import Perfis.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private static final Integer LIMITE_ALUNOS = 60;

    private String nome;
    private Professor professor;
    private TipoDisciplina tipo;
    private List<Aluno> alunos = new ArrayList<>();

    Disciplina(String nome, Professor professor, TipoDisciplina tipo) {
        this.nome = nome;
        this.professor = professor;
        this.tipo = tipo;
    }


    public void adicionarAluno(Aluno aluno) {
        if (disciplinaMatriculavel() && aluno.matricular(this))
            throw new Error("Numero maximo de alunos atingido");
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public boolean matriculaAtiva() {
        return disciplinaMatriculavel() && dentroPeriodoMatricula();
    }

    private boolean disciplinaMatriculavel() {
        return alunos.size() != LIMITE_ALUNOS;
    }


    //METODOS STUB / NAO UTILIZADOS
    // TODO DEFINIR COMO SERÁ O PERIODO DE MATRICULA  E IMPLEMENTAR O METODO
    private boolean dentroPeriodoMatricula() {
        return true;
    }

    //TODO ATIVAR DISCIPLINA
    void ativarDisciplina() {
    }

    //#region GETTERS & SETTERS
    public TipoDisciplina getTipoDisciplina() {
        return tipo;
    }

    public List<Aluno> alunosMatriculados() {
        return this.alunos;
    }
    //#endregion
}
