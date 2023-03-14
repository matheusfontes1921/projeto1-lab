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
        listaDados = new Arquivo("implementacao/Utilitarios/listaUsuarios.txt");
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

    public boolean validaLogin(String email, String senha) {
        if (listaDados.procuraUsuario(email).equals("")) {
            return false;
        } else {
            var dados = transformarStringEmVetor(listaDados.procuraUsuario(email));
            return dados[1].equals(email) && dados[2].equals(senha);
        }
    }

    private static String[] transformarStringEmVetor(String str) {
        String[] vetor = new String[3];
        String[] partes = str.split(" ");
        StringBuilder nome = new StringBuilder();
        int i = 1;
        while (!partes[i].contains("@")) {
            nome.append(partes[i] + " ");
            i++;
        }
        vetor[0] = nome.toString().trim();
        vetor[1] = partes[i]; // e-mail
        vetor[2] = partes[i + 1]; // senha
        return vetor;
    }

}
