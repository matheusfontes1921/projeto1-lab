package Perfis;

import Universidade.Curso;
import Universidade.Disciplina;
import Universidade.Universidade;

import java.util.*;

public class Professor extends Usuario {
    Universidade universidade;

    /*Construtor para criação de novo professor, sendo que o mesmo
    será identificado através de nome, email e senha.
    Além disso, na inicialização de um usuário do tipo professor será
    passado por parâmetro uma lista de disciplinas lecionados por esse.
     */
    public Professor(String nome, String email, String senha, Universidade universidade) {
        super(nome, email, senha);

        this.universidade = universidade;
    }

    public void alunosMatriculadosPorDisciplina() {
        universidade.getDisciplinas(this).forEach(System.out::println);
    }


}
