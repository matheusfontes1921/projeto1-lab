package Utilitarios;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Arquivo {
    private File arquivo;

    public Arquivo(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
    }

    public boolean escrever(String texto) {
        try {
            FileWriter escritor = new FileWriter(arquivo, true);
            escritor.write(texto + "\n");
            escritor.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        }
        return false;
    }

    public List<String> lerLinha() throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        return leitor.lines().toList();
    }

    public boolean contains(String texto) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains(texto)) {
                    leitor.close();
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro no arquivo");
        }

        return false;
    }

    public String procuraUsuario(String email) {
        String resultado="";
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains(email)) {
                    resultado += linha;
                    return resultado;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro no arquivo");
        }
        return resultado;
    }
}
