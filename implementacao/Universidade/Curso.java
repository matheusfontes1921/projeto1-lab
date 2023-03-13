package Universidade;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    //#REGION ATTRIBUTES

    private String nome;
    private Integer creditos;
    private List<Disciplina> disciplinas = new ArrayList<>();

    //#END REGION

    public Curso(String nome, Integer creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

}
