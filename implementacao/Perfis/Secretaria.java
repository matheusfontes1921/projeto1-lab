package Perfis;

import Universidade.Disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Secretaria extends Usuario {

    //#REGION ATTRIBUTES
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    //#ENDREGION

    //Construtor para secretaria que possui os mesmos parametros do professor, exceto a lista de disciplinas
    public Secretaria(String nome, String email, String senha) {
        super(nome, email, senha);
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        disciplinas = new ArrayList<>();
    }

    /* deixei o esqueleto para ver se faz sentido para vocês
    como a secretaria tem que gerar curriculo com professores, alunos e disciplinas,
    faríamos um for each em cada um desses temas e retornaria um novo array contento isso tudo
     */
    private List<Disciplina> geraCurriculo() {
    for (Disciplina d : disciplinas) {
        disciplinas.add(d);
    }
    return disciplinas;
    }

    void notificaSistemaCobranca() {
    }


}
