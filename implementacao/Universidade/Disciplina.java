package Universidade;

import Perfis.Aluno;
import Perfis.Professor;

import java.util.LinkedList;

public class Disciplina {

    //#REGION ATTRIBUTES
    private static final Integer LIMITE_ALUNOS = 60;
    private static final Integer LIMITE_MIN_ALUNOS = 3;

    private final String nome;
    private Curso curso;
    private Professor professor;
    private final TipoDisciplina tipo;
    private LinkedList<Aluno> alunos = new LinkedList<>();
    private Boolean ativa = false;

    //#ENDREGION

    //Construtor para inicialização do aluno, professor e tipo da disciplina
    //utilização do enum
    Disciplina(String nome, Professor professor, TipoDisciplina tipo, Curso curso) {
        if(curso.getDisciplinas().stream().anyMatch(disciplina -> disciplina.getNome().equals(nome)))
            throw new RuntimeException("Disciplina já existe");

        this.curso = curso;
        this.nome = nome;
        this.professor = professor;
        this.tipo = tipo;
    }


    /*
        @param aluno o aluno que será inserido da classe aluno
        se a disciplina está disponível, o aluno será inserido no array de alunos na disciplina
     */
    public void matricular(Aluno aluno) {
        if (!this.disciplinaMatriculavel())
            throw new RuntimeException("Numero maximo de alunos atingido");
        else if (aluno.disciplinaIsMax(this.tipo))
            throw new RuntimeException("Numero maximo de displinas " + this.tipo.getValor() + " alcançada");
        else if(curso.getUniversidade().alunoJaMatriculado(this))
            throw new RuntimeException("Aluno já matriculado nessa disciplina");

        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public boolean matriculaAtiva() {
        return disciplinaMatriculavel() && dentroPeriodoMatricula();
    }

    private boolean disciplinaMatriculavel() {
        return alunos.size() < LIMITE_ALUNOS;
    }


    //METODOS STUB / NAO UTILIZADOS
    // TODO DEFINIR COMO SERÁ O PERIODO DE MATRICULA  E IMPLEMENTAR O METODO
    private boolean dentroPeriodoMatricula() {
        return true;
    }

    // DONE ATIVAR DISCIPLINA
    public void ativarDisciplina() {
        if (this.alunos.size() >= LIMITE_MIN_ALUNOS)
            this.ativa = true;
    }

//  #region GETTERS & SETTERS

    public TipoDisciplina getTipoDisciplina() {
        return tipo;
    }

    public LinkedList<Aluno> alunosMatriculados() {
        return new LinkedList<>(this.alunos);
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String imprimeAlunos() {
        StringBuilder resultado = new StringBuilder();

        for (var aluno : alunos) {
            resultado.append(aluno).append("\n");
        }
        return resultado.toString();
    }

    public boolean isAberta() {
        return ativa;
    }

//  #endregion

    @Override
    public String toString() {
        if(ativa)
            return nome + "\n" + tipo + "\n" + imprimeAlunos() + "\n";
        return nome + " - " + "Disciplina cancelada";
    }

}
