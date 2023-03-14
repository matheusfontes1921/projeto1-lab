import Perfis.Aluno;
import Perfis.Professor;
import Perfis.Secretaria;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Universidade.Universidade;

public class Main {
    public static Universidade puc = new Universidade("Puc Minas");

    public static void main(String[] args) {
        printaMenu();

    }

    private static void printaMenu() {
        boolean invalido = true;
        var opcao = 0;
        Scanner entrada = new Scanner(System.in);

        while (invalido) {
            try {
                limpaConsole();
                System.out.println("Bem vindo ao Sistema da universidade!");
                System.out.println("Digite o numero correspondente ao que deseja");
                System.out.println("1 - Cadastro");
                System.out.println("2 - Login");
                System.out.println("0 - Sair");
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1 -> cadastraUsuario();
                    case 2 -> fazerlogin();
                    case 0 -> invalido = false;
                    default -> {
                        System.out.println("Digite um numero entre 0 e 2");
                        invalido = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Digite Um número válido");
                entrada.nextLine(); // limpa o buffer de entrada
            }
        }
    }

    //TODO Login
    private static void fazerlogin() {
        boolean invalido = true;
        var opcao = 0;
        Scanner entrada = new Scanner(System.in);

        while (invalido) {
            try {
                printaUsuarios();
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1 -> {
                        System.out.println("login aluno");
                        invalido = false;
                    }
                    case 2 -> {
                        System.out.println("login prof");
                        invalido = false;
                    }
                    case 3 -> {
                        System.out.println("login secretaria");
                        invalido = false;
                    }
                    case 0 -> {
                        printaMenu();
                        invalido = false;
                    }
                    default -> System.out.println("Digite um número entre 1 e 3");
                }
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                entrada.nextLine();
            }
        }
    }

    private static void cadastraUsuario() {
        boolean invalido = true;
        var opcao = 0;
        Scanner entrada = new Scanner(System.in);

        while (invalido) {
            try {
                printaUsuarios();
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1 -> {
                        cadastraAluno();
                        invalido = false;
                    }
                    case 2 -> {
                        cadastraProfessor();
                        invalido = false;
                    }
                    case 3 -> {
                        cadastraSecretaria();
                        invalido = false;
                    }
                    case 0 -> {
                        printaMenu();
                        invalido = false;
                    }
                    default -> System.out.println("Digite um número entre 1 e 3");
                }
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                entrada.nextLine();
            }
        }
    }

    private static void printaUsuarios() {
        limpaConsole();
        System.out.println("Digite o número do tipo do Usuário");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Secretária");
        System.out.println("0 - Voltar ao menu");
    }

    private static void cadastraSecretaria() {
        var dados = pegaDadosUsuario();
        Secretaria secretaria = new Secretaria(dados[0], dados[1], dados[2], puc);
        var usuarioString = secretaria.dadosUsuario();
        if (!puc.getListaDados().contains(dados[1])) { // Consulta se o email ja existe na lista
            puc.getListaDados().escrever(usuarioString);
        } else System.out.println("Email já cadastrado");
    }

    private static void cadastraProfessor() {
        var dados = pegaDadosUsuario();
        Professor professor = new Professor(dados[0], dados[1], dados[2], puc);
        var usuarioString = professor.dadosUsuario();
        if (!puc.getListaDados().contains(dados[1])) { // Consulta se o email ja existe na lista
            puc.getListaDados().escrever(usuarioString);
        } else System.out.println("Email já cadastrado");
    }

    private static void cadastraAluno() {
        var dados = pegaDadosUsuario();
        Aluno aluno = new Aluno(dados[0], dados[1], dados[2]);
        var alunoString = aluno.dadosUsuario();
        if (!puc.getListaDados().contains(dados[1])) { // Consulta se o email ja existe na lista
            puc.getListaDados().escrever(alunoString);
        } else System.out.println("Email já cadastrado");
    }

    private static String[] pegaDadosUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Nome Completo");
        var nome = entrada.nextLine();
        System.out.println("Digite o email");
        var email = entrada.nextLine();
        var emailInvalido = true;
        while (emailInvalido) {

            if (!validaEmail(email)) {
                System.out.println("Digite um email válido");
                email = entrada.nextLine();
            } else emailInvalido = false;
        }
        System.out.println("Digite a Senha");
        var senha = entrada.nextLine();
        return new String[]{nome, email, senha};
    }

    // se for usado so no main deixa private
    private static void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // se for usado so no main deixa private
    private static boolean validaEmail(String email) {

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String[] transformarStringEmVetor(String str) {
        String[] vetor = new String[3];
        String[] partes = str.split(" ");
        StringBuilder nome = new StringBuilder();
        int i = 1;
        while (!partes[i].contains("@")) {
            nome.append(partes[i] + " ");
            i++;
        }
        vetor[0] = nome.toString().trim();
        vetor[1] = partes[i]; // e-mail
        vetor[2] = partes[i + 1]; // senha
        return vetor;
    }
}