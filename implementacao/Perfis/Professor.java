package Perfis;

import Universidade.Disciplina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Professor extends Usuario {
    private List<Disciplina> disciplinas;

    public Professor(String nome, String email, String senha, List<Disciplina> disciplinas) {
        super(nome, email, senha);
        disciplinas = new ArrayList<>();
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
