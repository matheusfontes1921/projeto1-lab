package Universidade;

import java.util.LinkedList;


public class Curso {
    //#REGION ATTRIBUTES

    private String nome;
    private Integer creditos;
    private LinkedList<Disciplina> disciplinas = new LinkedList<>();

    //#END REGION

    public Curso(String nome, Integer creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return new LinkedList<>(this.disciplinas);
    }


}
