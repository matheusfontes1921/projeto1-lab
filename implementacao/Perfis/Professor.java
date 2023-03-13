package Perfis;

import Universidade.Curso;
import Universidade.Disciplina;

import java.util.*;

public class Professor extends Usuario {
    Curso curso;

    /*Construtor para criação de novo professor, sendo que o mesmo
    será identificado através de nome, email e senha.
    Além disso, na inicialização de um usuário do tipo professor será
    passado por parâmetro uma lista de disciplinas lecionados por esse.
     */
    public Professor(String nome, String email, String senha, Curso curso) {
        super(nome, email, senha);

        this.curso = curso;
    }

    public Map<Disciplina, LinkedList<Aluno>> alunosMatriculadosPorDisciplina() {
        Map<Disciplina, LinkedList<Aluno>> alunoPorDisciplina = new HashMap<>();

        for (Disciplina disciplina : this.curso.getDisciplinas()) {
            alunoPorDisciplina.put(disciplina, disciplina.alunosMatriculados());
        }
        return alunoPorDisciplina;
    }
}
