package Universidade;

import Perfis.Aluno;
import Perfis.Professor;
import Perfis.Usuario;
import Utilitarios.Arquivo;

import java.util.LinkedList;

public class Universidade {
    private LinkedList<Curso> cursos;
    private LinkedList<Usuario> usuarios;
    Arquivo listaDados;

    String nome;

    public Universidade(String nome) {
        this.nome = nome;
//        listaDados =
    }

    public LinkedList<Disciplina> getDisciplinas(Professor professor) {
        LinkedList<Disciplina> disciplinas = new LinkedList<>();
        this.cursos.forEach(curso -> curso.getDisciplinas().forEach(
                disciplina -> {
                    if (disciplina.getProfessor() == professor)
                        disciplinas.add(disciplina);
                }
        ));

        return disciplinas;
    }

    public void gerenciarDisciplinas() {
        cursos.forEach(curso -> curso.getDisciplinas().forEach(disciplina ->
                disciplina.ativarDisciplina()
        ));
    }

    public LinkedList<Disciplina> disciplinaPorAluno(Aluno aluno) {
        LinkedList<Disciplina> disciplinas = new LinkedList<>();
        this.cursos.forEach(curso -> curso.getDisciplinas().forEach(
                disciplina -> {
                    if (disciplina.alunosMatriculados().contains(aluno))
                        disciplinas.add(disciplina);
                }
        ));

        return disciplinas;
    }

    public LinkedList<Curso> getCursos() {
        return new LinkedList<>(cursos);
    }

    public boolean alunoJaMatriculado(Disciplina disciplina) {
        return cursos.stream().anyMatch(curso ->
                curso.getDisciplinas().stream().anyMatch(disciplina1 ->
                        disciplina1.getNome().equals(disciplina.getNome())));
    }


    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public Arquivo getListaDados() {
        return listaDados;
    }
}
