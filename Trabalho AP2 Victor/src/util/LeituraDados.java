package util;

import java.util.Scanner;


public class LeituraDados {
    private Scanner scanner;

    public LeituraDados() {
        scanner = new Scanner(System.in);
    }

    public String lerTexto() {
        return scanner.nextLine();
    }

    public double lerDouble() {
        double valor = scanner.nextDouble();
        limparBuffer();
        return valor;
    }

    public int lerInt() {
        int valor = scanner.nextInt();
        limparBuffer();
        return valor;
    }

    public char lerChar(){
        char letra = scanner.next().charAt(0);
        limparBuffer();
        return letra;
    }

    private void limparBuffer() {
        scanner.nextLine(); 
    }
}
