package Perfis;

import Universidade.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private List<Disciplina> disciplinas;

    public Professor(String nome, String email, String senha) {
        super(nome, email, senha);
        disciplinas = new ArrayList<>();
    }


}
