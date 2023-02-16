//codigo de exemplo para tratamento de erros com try catch - UncheckedExeption
import javax.swing.*;
import java.util.Scanner;

public class AboutUncheckedException { //UncheckedExeption

    public static int dividir(int a, int b){return a / b;}

    public static void main(String[] args) {

        boolean continueLooping = true;

        do {

            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado " + resultado);
                continueLooping = false;

            } catch (NumberFormatException e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida: informe um número " + e.getMessage());

            } catch (ArithmeticException e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir por zero: informe um número " + e.getMessage());

            } finally {
                System.out.println("Chegou no finally!");
            }
        }while (continueLooping);

    }
}