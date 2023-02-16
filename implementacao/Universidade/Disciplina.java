package Universidade;

import Perfis.Aluno;
import Perfis.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private Integer LIMITE_ALUNOS = 60;
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
        if(numeroMatriculas() == 60)
            throw new Error("Numero maximo de alunos atingido");

        alunos.add(aluno);
    }
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Integer numeroMatriculas() {
        return this.alunos.size();
    }

    public List<Aluno> alunosMatriculados() {
        return new ArrayList<>(this.alunos);
    }

    public String getNome() {
        return this.nome;
    }
}
