import Perfis.Aluno;
import Perfis.Professor;
import Perfis.Secretaria;
import Perfis.Usuario;
import Universidade.Universidade;
import Universidade.Curso;
import Universidade.Disciplina;
import Utilitarios.Arquivo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Universidade puc = new Universidade("Puc Minas");
    public static String tipo;

    public static void main(String[] args) {
        printaMenu();
        //        Usuario usuario = login(email, senha)

    }

    public static void printaMenu() {
        Usuario usuario = null;
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
                invalido = false;
                switch (opcao) {
                    case 1 -> {
                        cadastraUsuario();
                        break;
                    }
                    case 2 -> {
                        usuario = fazerlogin();
                        String tClass = usuario.getClass().getCanonicalName();
                        switch (tClass) {
                            case "Perfis.Aluno" -> {
                                alunoActions((Aluno) usuario);
                                break;
                            }
                            case "Perfis.Professor" -> {
                                professorActions((Professor) usuario);
                                break;
                            }
                            case "Perfis.Secretaria" -> {
                                secretariaActions((Secretaria) usuario);
                                break;
                            }
                        }
                        break;
                    }
                    case 0 -> {
                        invalido = false;
                        break;
                    }
                    default -> {
                        System.out.println("Digite um numero entre 0 e 2");
                        invalido = true;
                    }
                }
            } catch (Exception e) {
                if (e.getMessage().equals("voltar")) {
                    System.out.println("Digite uma opção");
                    entrada.nextLine();
                } else {
                    System.out.println("Digite uma opção valida");
                    entrada.nextLine();
                }

                System.out.println(e.getMessage());
                // limpa o buffer de entrada
            }
        }

        entrada.close();
    }

    private static void secretariaActions(Secretaria usuario) {
        boolean invalido = true;
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while (invalido) {
            limpaConsole();
            System.out.println("Digite o número da ação que deseja fazer");
            System.out.println("1 - Gerar curriculo");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> {
                    usuario.geraCurriculo();
                }
                case 0 -> {
                    printaMenu();
                    invalido = false;
                }
                default -> System.out.println("Digite um número entre 1 e 3");
            }
        }
    }

    private static void professorActions(Professor usuario) {
        boolean invalido = true;
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while (invalido) {
            limpaConsole();
            System.out.println("Digite o número da ação que deseja fazer");
            System.out.println("1 - Ver alunos matriculados por disciplina");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> {
                    usuario.alunosMatriculadosPorDisciplina();

                    invalido = false;
                }
                case 0 -> {
                    printaMenu();
                    invalido = false;
                }
                default -> System.out.println("Digite um número entre 1 e 3");
            }
        }
    }

    private static void alunoActions(Aluno usuario) {
        boolean invalido = true;
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while (invalido) {
            limpaConsole();
            System.out.println("Digite o número da ação que deseja fazer");
            System.out.println("1 - Matricular");
            System.out.println("2 - Cancelar Matricula");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Nome da disciplina");
                    String disciplina = entrada.nextLine();
                    System.out.println("Nome do cusro");
                    String curso = entrada.nextLine();
                    boolean matriculou = matricular(disciplina, curso, usuario, puc);
                    System.out.println(matriculou);
                    invalido = false;
                }
                case 2 -> {
                    System.out.println("Nome da disciplina");
                    String disciplina = entrada.nextLine();
                    System.out.println("Nome do cusro");
                    String curso = entrada.nextLine();
                    desmatricular(disciplina, curso, usuario, puc);
                    invalido = false;
                }
                case 0 -> {
                    printaMenu();
                    invalido = false;
                }
                default -> System.out.println("Digite um número entre 1 e 3");
            }
        }

    }

    //TODO Login
    private static Usuario fazerlogin() {
        Scanner entrada = new Scanner(System.in);
        printaUsuarios();
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println("login aluno");
                tipo = "aluno";

                return logar();
            }
            case 2 -> {
                System.out.println("login prof");
                tipo = "professor";

                return logar();
            }
            case 3 -> {
                System.out.println("login secretaria");
                tipo = "secretaria";

                return logar();
            }
            case 0 -> {
                throw new RuntimeException("voltar");
            }
            default -> {
                System.out.println("Opção Login invalida");
                return fazerlogin();
            }
        }
    }

    private static Usuario logar() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Email: ");
        String email = entrada.nextLine();
        while (!validaEmail(email)) {
            System.out.println("Email invalido");
            System.out.println("Email: ");
            email = entrada.nextLine();
        }
        System.out.println("Senha:\n");
        String senha = entrada.nextLine();

        String linha = puc.getListaDados().procuraUsuario(email);

        if (linha.equals(""))
            throw new RuntimeException("Dados incorretos");

        String[] vetor = Universidade.transformarStringEmVetor(linha);

        if (!vetor[2].equals(senha))
            throw new RuntimeException("Dados incorretos");

        Usuario usuario = puc.getUsuarioByEmail(email);
        if (usuario == null)
            throw new RuntimeException("Server error");

        return usuario;
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

    private static void cadastraAluno() {
        var dados = pegaDadosUsuario();
        Aluno aluno = new Aluno(dados[0], dados[1], dados[2]);

        var usuarioString = aluno.dadosUsuario();
        if (!puc.getListaDados().contains(dados[1])) {
            puc.getListaDados().escrever(usuarioString);
        } else System.out.println("Email já cadastrado");
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

    private static boolean matricular(String disciplinaNome, String cursoNome, Aluno aluno, Universidade universidade) {
        Disciplina disciplina = selectDisciplina(cursoNome, disciplinaNome, universidade);

        Disciplina disciplina1 = aluno.matricular(disciplina);

        return disciplina == disciplina1;
    }

    private static void desmatricular(String disciplinaNome, String cursoNome, Aluno aluno, Universidade universidade) {
        Disciplina disciplina = selectDisciplina(cursoNome, disciplinaNome, universidade);

        aluno.cancelarMatricula(disciplina);
    }

    private static Disciplina selectDisciplina(String cursoNome, String disciplinaNome, Universidade universidade) {
        Curso curso = universidade.getCursos().stream()
                .filter(curso1 ->
                        curso1.getNome().equals(cursoNome))
                .findFirst().orElse(null);

        if (curso == null)
            throw new RuntimeException("Curso não existe!");

        Disciplina disciplina = curso.getDisciplinas().stream()
                .filter(curso1 ->
                        curso1.getNome().equals(disciplinaNome))
                .findFirst().orElse(null);
        if (disciplina == null)
            throw new RuntimeException("Disciplina não existe!");

        return disciplina;
    }
}