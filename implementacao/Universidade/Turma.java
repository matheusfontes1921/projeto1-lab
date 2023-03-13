package Universidade;

import Perfis.Aluno;
import Perfis.Professor;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    //#REGION ATTRIBUTES
    List<Aluno> alunosDisciplina;
    List<Professor> professoresDisciplina;
    List<Disciplina> disciplinas;
    //#END REGION

    public Turma() {
        alunosDisciplina = new ArrayList<>();
        professoresDisciplina = new ArrayList<>();
        disciplinas = new ArrayList<>();
    }
}
