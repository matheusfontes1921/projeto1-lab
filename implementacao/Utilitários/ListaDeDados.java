package Utilitários;

import java.io.*;
import java.security.spec.ECField;

public class ListaDeDados {
    private String caminho;
    private Writer writer;
    BufferedWriter escritor;

    BufferedReader leitor;

    public ListaDeDados(String caminho) throws FileNotFoundException {
        this.caminho = caminho;
        OutputStream os = new FileOutputStream(caminho);
        writer = new OutputStreamWriter(os);
        escritor = new BufferedWriter(writer);

        // Leitor

        FileInputStream stream = new FileInputStream(caminho);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader leitor = new BufferedReader(reader);
    }

    public boolean escrever(String conteudo) {
        try {
            escritor.write(conteudo);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao escrever");
        }
        return false;
    }

    public boolean contem(String conteudo) {
        try {
            var linha = leitor.readLine();
            while (linha != null) {
                if (linha.equals(conteudo)) return true;
                linha = leitor.readLine();
            }
        } catch (Exception e) {
            System.out.println("Erro ao achar a palavra");
        }

        return false;

    }
}
