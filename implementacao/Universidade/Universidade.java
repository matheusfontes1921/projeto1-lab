package Universidade;

import Perfis.Professor;
import Utilitários.ListaDeDados;

import java.util.LinkedList;

public class Universidade {
    private LinkedList<Curso> cursos;
    private LinkedList<Professor> professores;
    ListaDeDados listaDados;

    String nome;

    public Universidade(String nome) {
        this.nome = nome;
        listaDados =
    }

    public LinkedList<Disciplina> getDisciplinas(Professor professor) {
        LinkedList<Disciplina> disciplinas = new LinkedList<>();
        this.cursos.forEach(curso -> {
            curso.getDisciplinas().forEach(
                    disciplina -> {
                        if (disciplina.getProfessor() == professor)
                            disciplinas.add(disciplina);
                    }
            );
        });

        return disciplinas;
    }

}
