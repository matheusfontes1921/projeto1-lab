import Perfis.Aluno;
import Perfis.Professor;
import Perfis.Secretaria;
import Universidade.Universidade;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    Universidade puc = new Universidade("Puc Minas");
    public static void main(String[] args) {

    }

    public void cadastraUsuario() {
        boolean invalido = true;
        var opcao = 0;
        Scanner entrada = new Scanner(System.in);

        while (invalido) {
            try {
                limpaConsole();
                System.out.println("Digite o número do tipo do Usuário que deseja cadastrar");
                System.out.println("1 - Aluno");
                System.out.println("2 - Professor");
                System.out.println("2 - Secretária");
                opcao = entrada.nextInt();
                invalido = false;
                switch (opcao) {
                    case 1 -> cadastraAluno();
                    case 2 -> cadastraProfessor();
                    case 3 -> cadastraSecretaria();
                    default -> System.out.println("Digite um numero entre 1 e 3");
                }
            } catch (Exception e) {
                System.out.println("Digite Um número válido");
            }
        }

        entrada.close();
    }

    private void cadastraSecretaria() {
        var dados = pegaDadosUsuario();
        Secretaria secretaria = new Secretaria(dados[0], dados[1], dados[2]);
    }

    private void cadastraProfessor() {
        var dados = pegaDadosUsuario();
        Professor professor = new Professor(dados[0], dados[1], dados[2], puc);
    }

    private void cadastraAluno() {
        var dados = pegaDadosUsuario();
        Aluno aluno = new Aluno(dados[0], dados[1], dados[2]);
        var alunoString = aluno.toString();
        if ()
    }

    private String[] pegaDadosUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Nome Completo");
        var nome = entrada.nextLine();
        System.out.println("Digite o email");
        var email = entrada.nextLine();
        var emailInvalido = true;
        while (emailInvalido) {
            if (!validaEmail(email)) System.out.println("Digite um email válido");
            else emailInvalido = false;
        }
        System.out.println("Digite a Senha");
        var senha = entrada.nextLine();
        return new String[]{nome, email, senha};
    }

    // se for usado so no main deixa private
    private void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // se for usado so no main deixa private
    private boolean validaEmail(String email) {

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}