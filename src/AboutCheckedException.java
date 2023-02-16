import javax.swing.*;
import java.io.*;

public class AboutCheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "lista-de-pessoas.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Verifique o arquivo enviado");
            e.printStackTrace();
        } finally {
            System.out.println("Chgou no finally");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        }while (line != null);
        bw.flush();
        br.close();
    }
}