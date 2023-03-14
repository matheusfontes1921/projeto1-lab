package Utilitarios;

import java.io.*;

public class Arquivo {
    private File arquivo;

    public Arquivo(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
    }

    public boolean escrever(String texto) {
        try {
            FileWriter escritor = new FileWriter(arquivo, true);
            escritor.write(texto+"\n");
            escritor.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
        }
        return false;
    }

    public String lerLinha(int numLinha) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha = null;
        for (int i = 1; i <= numLinha; i++) {
            linha = leitor.readLine();
            if (linha == null) break;
        }
        return linha;
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
}
