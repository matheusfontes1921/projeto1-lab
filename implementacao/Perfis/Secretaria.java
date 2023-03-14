package Perfis;

import Universidade.Disciplina;
import Universidade.Universidade;

import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Usuario {

    //#REGION ATTRIBUTES
    private Universidade universidade;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    //#ENDREGION

    //Construtor para secretaria que possui os mesmos parametros do professor, exceto a lista de disciplinas
    public Secretaria(String nome, String email, String senha, Universidade universidade) {
        super(nome, email, senha);
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        this.universidade = universidade;
    }

    /* deixei o esqueleto para ver se faz sentido para vocês
    como a secretaria tem que gerar curriculo com professores, alunos e disciplinas,
    faríamos um for each em cada um desses temas e retornaria um novo array contento isso tudo
     */
    private void geraCurriculo() {
        System.out.println("\n----------------------------------\n");
        universidade.getCursos().forEach(curso -> {
            System.out.println("|" + curso + "\t|\n");

            curso.getDisciplinas().forEach(disciplina -> {
                System.out.println("\t-" + disciplina.getNome() + "\n");
            });

            System.out.println("----------------------------------\n");
        });
    }

    void notificaSistemaCobranca() {
    }



    public String dadosUsuario() {
        return "Secretaria " + nome + " " + email + " " + senha;
    }
}
