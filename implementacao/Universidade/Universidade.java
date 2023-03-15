package Universidade;

import Perfis.Aluno;
import Perfis.Professor;
import Perfis.Secretaria;
import Perfis.Usuario;
import Utilitarios.Arquivo;

import java.io.IOException;
import java.util.LinkedList;

public class Universidade {
    private LinkedList<Curso> cursos;
    private LinkedList<Usuario> usuarios;
    Arquivo listaDados;

    String nome;

    public Universidade(String nome) {
        this.nome = nome;
        usuarios = new LinkedList<>();
        cursos = new LinkedList<Curso>();
        listaDados = new Arquivo("implementacao/Utilitarios/listaUsuarios.txt");
        preencherUsuarioList();
    }

    private void preencherUsuarioList() {
        try {
            listaDados.lerLinha().forEach(linha -> {
                String[] linhaArray = Universidade.transformarStringEmVetor(linha);
                Usuario usuario;
                switch (linhaArray[3].toLowerCase()) {
                    case "aluno" -> {
                        usuarios.push(new Aluno(linhaArray[0], linhaArray[1], linhaArray[2]));
                        break;
                    }
                    case "professor" -> {
                        usuarios.add(new Professor(linhaArray[0], linhaArray[1], linhaArray[2], this));
                        break;
                    }
                    case "secretaria" -> {
                        usuarios.add(new Secretaria(linhaArray[0], linhaArray[1], linhaArray[2], this));
                        break;
                    }
                    default -> {
                        System.out.println("Error");
                        break;
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static String[] transformarStringEmVetor(String str) {
        String[] vetor = new String[4];
        String[] partes = str.split(" ");
        StringBuilder nome = new StringBuilder();
        int i = 1;
        while (!partes[i].contains("@")) {
            nome.append(partes[i]).append(" ");
            i++;
        }
        vetor[0] = nome.toString().trim();
        vetor[1] = partes[i]; // e-mail
        vetor[2] = partes[i + 1]; // senha
        vetor[3] = partes[0];
        return vetor;
    }

    public LinkedList<Usuario> getUsuarios() {
        return new LinkedList<>(usuarios);
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarios.stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst().orElse(null);
    }

}
