package Perfis;

public abstract class Usuario implements Logavel {
    private String senha;
    private static int id = 0;
    private String nome;

    public Usuario(String nome, String email, String senha) {
        id = gerarID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private int gerarID() {
        return id++;
    }

    private String email;


}
