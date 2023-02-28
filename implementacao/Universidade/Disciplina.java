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
        if (alunosMatriculados() >= 60 && aluno.podeMatricular(getTipoDisciplina()))
            throw new Error("Numero maximo de alunos atingido");

        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Integer alunosMatriculados() {
        return this.alunos.size();
    }

    public TipoDisciplina getTipoDisciplina() {
        return tipo;
    }
}
