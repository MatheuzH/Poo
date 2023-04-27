import java.util.Scanner;

public class Partida {
    String nome;
    String data;
    String local;
    int ingressoInteira;
    int ingressoMeia;

 public String getNome() {
    return nome;
 }
 public String getData() {
    return data;
 }
 public String getLocal() {
    return local;
 }
 public int getIngressos() {
    return this.ingressoInteira + this.ingressoMeia;
 }


 Scanner receber = new Scanner(System.in);

    public void criarPartida() { 
      System.out.println("Informe o nome da partida: ");
      nome = receber.nextLine();
      System.out.println("Informe a data da partida: ");
      data = receber.nextLine();
      System.out.println("Informe o local da partida: ");
      local = receber.nextLine();
      System.out.println("Informe quantos ingressos inteiras teram: ");
      ingressoInteira = receber.nextInt();
      System.out.println("Informe quantos ingressos meias teram ");
      ingressoMeia = receber.nextInt();
   }
 
   public void mostrarInfos() {
      System.out.println("-----Informações da partida-----\n");
      System.out.println("Nome da partida: " + nome);
      System.out.println("Data da partida: " + data);
      System.out.println("Local da partida: " + local);
      System.out.println("Existem, " + ingressoInteira + " ingressos inteiras");
      System.out.println("Existem, " + ingressoMeia + " ingressos meias\n");
   }

   public boolean isIngressoDisponivel(Tipoingresso tipo, int quantidade){
      if(tipo == Tipoingresso.INTEIRA ) {
         	if (this.ingressoInteira >= quantidade) {
               return true;
            }
      }
      else if(tipo == Tipoingresso.MEIA ) {
         if (this.ingressoMeia >= quantidade) {
            return true;
         }
   }
     
      return false;
   }

   public double venderIngresso(Tipoingresso tipo, int quantidade){
      double ValorTotal = 0;
      if(!(isIngressoDisponivel(tipo, quantidade))){
         System.out.println("Não há ingressos disponíveis");
         return 0;
      }
      if(tipo == Tipoingresso.INTEIRA ){
         ValorTotal = quantidade * 100;
         ingressoInteira = ingressoInteira - quantidade;
      }
      else if(tipo == Tipoingresso.MEIA ){
         ValorTotal = quantidade * 100/2;
         ingressoMeia = ingressoMeia - quantidade;
      }


      return ValorTotal;
   }



   
   





}



