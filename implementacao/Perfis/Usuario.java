package Perfis;

public abstract class Usuario implements ILogavel {

    //#REGION ATTRIBUTES
    protected String nome;
    protected String email;
    protected String senha;
    //#endregion

    // private final String senhaReal = "123";
    private static int id = 0;

    public Usuario(String nome, String email, String senha) {
        id = gerarID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private int gerarID() {
        return id++;
    }

    /* método de logar que será implementado na interface logável
    private boolean logar(String senha) {
        return (this.senha.equals(senhaReal));
    }
    */

    @Override
    public String toString() {
        return nome + " " + email;
    }

}
