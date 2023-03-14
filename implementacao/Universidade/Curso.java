package Universidade;

import java.util.LinkedList;


public class Curso {
    //#REGION ATTRIBUTES

    private final Universidade universidade;
    private String nome;
    private Integer creditos;
    private LinkedList<Disciplina> disciplinas = new LinkedList<>();

    //#END REGION

    public Curso(String nome, Integer creditos, Universidade universidade) {
        if(universidade.getCursos().stream().anyMatch(curso -> curso.getNome().equals(nome)))
            throw new RuntimeException("Curso já existe");

        this.nome = nome;
        this.creditos = creditos;
        this.universidade = universidade;
    }

    public void addDisciplina(Disciplina disciplina) {
        if(disciplinas.stream().anyMatch(disciplina1 -> disciplina1.getNome().equals(disciplina.getNome())))
            disciplinas.add(disciplina);
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return new LinkedList<>(this.disciplinas);
    }


    public String getNome() {
        return nome;
    }

    public Universidade getUniversidade() {
        return universidade;
    }
}
