package Perfis;

import Universidade.Disciplina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Professor extends Usuario {
    private String nome;
    private List<Disciplina> disciplinas;


    Professor(String nome) {
        this.nome = nome;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Map<Disciplina, List<Aluno>> alunosMatriculadosPorDisciplina() {
        Map<Disciplina, List<Aluno>> alunoPorDisciplina = new HashMap<>();
        for (Disciplina disciplina : this.disciplinas) {
            alunoPorDisciplina.put(disciplina, disciplina.alunosMatriculados());
        }

        return alunoPorDisciplina;
    }
}
