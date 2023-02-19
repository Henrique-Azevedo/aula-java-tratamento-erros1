import javax.swing.*;
import java.io.*;

    public class AboutCheckedException {
    public static void main(String[] args) throws ImpossivelAbrirArquivoException {
        String nomeDoArquivo = "listaa-de-pessoas.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (IOException e) {
            throw new ImpossivelAbrirArquivoException("lista-de-pessoas.txt");
            //JOptionPane.showMessageDialog(null, "Verifique o arquivo enviado");
            //e.printStackTrace();
        } finally {
            System.out.println("Chegou no finally");
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

class ImpossivelAbrirArquivoException extends Exception{

        private String nomeDoArquivoT;

    public ImpossivelAbrirArquivoException(String nomeDoArquivoT) {
        super("O arquivo nao foi carregado verifique a pasta ou o diretorio");
        this.nomeDoArquivoT = nomeDoArquivoT;

    }
}











