package Perfis;

import Universidade.Disciplina;
import Universidade.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

    private List<Disciplina> listaDisciplinas;

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha);
        listaDisciplinas = new ArrayList<>() {
        };
    }

    /**
     * Método que adiciona uma disciplina a grade do aluno
     * @param disciplina A disciplina que será inserida
     * @return TRUE caso a disciplina for inserida, False caso não couber mais disciplinas
     */
    public boolean matricular(Disciplina disciplina) {
        if (podeMatricular(disciplina.getTipoDisciplina())) {
            listaDisciplinas.add(disciplina);
            return true;
        }
        return false;
    }

    /**
     * Verifica se o aluno Pode adicionar mais uma disciplina na sua lista de disciplinas
     * @param tipoDisciplina Optativa ou Obrigatoria
     * @return True se poder, False caso nao caibam mais disciplinas do tipo
     */
    public boolean podeMatricular(TipoDisciplina tipoDisciplina) {
        if (tipoDisciplina.equals(TipoDisciplina.Obrigatoria))
            return listaDisciplinas.stream().filter(disciplina -> disciplina.getTipoDisciplina().equals(TipoDisciplina.Obrigatoria)).count() < 4;
        else
            return listaDisciplinas.stream().filter(disciplina -> disciplina.getTipoDisciplina().equals(TipoDisciplina.Optativa)).count() < 2;
    }
}
