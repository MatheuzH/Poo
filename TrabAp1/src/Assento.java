import java.util.Scanner;

public class Assento {
    int numero;
    char fila; 

    public int getNumero(){
    return numero;
    }

    public char getFila(){
    return fila;
    }


    Scanner assento = new Scanner(System.in);

    public void escolherAssento() {
    System.out.println("--Assentos--");
    System.out.println("informe o número do assento: ");
    numero = assento.nextInt();
    System.out.println("Informe a fila do assento: ");
    fila = assento.next().charAt(fila);

    }
}
