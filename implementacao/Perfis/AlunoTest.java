//package Perfis;
//
//import Perfis.Aluno;
//import Perfis.Professor;
//import Universidade.Disciplina;
//import Universidade.TipoDisciplina;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//
//public class AlunoTest {
//    /*
//    Classe utilizada para testes que envolvem
//    inicialização de disciplina, criação de novos alunos e professores,
//
//     */
//    static Aluno aluno;
//    static Professor professor;
//    static Disciplina obrigatoria;
//    static Disciplina optativa;
//
//    @BeforeAll
//    static void init() {
//        aluno = new Aluno("Lucas", "lucassr614@gmail.com", "123");
//        professor = new Professor("Caram", "caram.pucminas.br", "123");
//        obrigatoria = new Disciplina("FPAA", professor, TipoDisciplina.Obrigatoria);
//        optativa = new Disciplina("Cidade Inteligente", professor, TipoDisciplina.Optativa);
//    }
//
//
//    @Test
//    void adicionaDisciplinasValidas() {
//        init();
//        for (int i = 0; i < 1; i++) {
//            aluno.matricular(optativa);
//        }
//        for (int i = 0; i < 3; i++) {
//            aluno.matricular(obrigatoria);
//        }
//
//        Assertions.assertTrue(aluno.matricular(optativa));
//        Assertions.assertTrue(aluno.matricular(obrigatoria));
//    }
//
//    @Test
//    void adicionaDisciplinasInvalidas() {
//        init();
//        for (int i = 0; i < 2; i++) {
//            aluno.matricular(optativa);
//        }
//        for (int i = 0; i < 4; i++) {
//            aluno.matricular(obrigatoria);
//        }
//        Assertions.assertFalse(aluno.matricular(optativa));
//        Assertions.assertFalse(aluno.matricular(obrigatoria));
//    }
//
//}