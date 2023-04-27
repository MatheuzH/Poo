import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     Scanner menu = new Scanner(System.in);
     Partida infospartida = new Partida();
     System.out.println("\nOlá seja bem vindo, o que você deseja fazer hoje?\n");
     int infos;
     
         
        while (true) {
            System.out.println("---Menu---\n");
            System.out.println("1 - Cadastrar uma nova partida");
            System.out.println("2 - Informações sobre a partida");
            System.out.println("3 - Comprar um ingresso");
            System.out.println("4 - Exibir número de ingressos restantes");
            System.out.println("5 - Exibir informações do ultimo ingresso vendido");
            System.out.println("6 - Sair do MENU");

            infos = menu.nextInt();

            switch (infos) {
                case 1:
                 infospartida.criarPartida();
                 System.out.println("\n --Partida Cadastrada-- \n");
                 break;
                case 2:
                 infospartida.mostrarInfos();
                 break;
                case 3:
                 
                 break;
                case 4:
                 System.out.println("\n Ingressos restantes: ");
                 System.out.println(infospartida.getIngressos());
                 break;
                case 5:
                 System.out.println("\n vc selecionou 5\n");
                 break;
                case 6:
                 System.out.println("\n Fechando MENU\n");
                 break;
                default:
                 System.out.println("\n Selecione uma opção válida!\n");
            }

            if (infos == 6) {
                break;
            }
        }
            menu.close();
            
        
        



        }

        public void comprarIngresso(Partida infoPartida) {
            Scanner comprar = new Scanner(System.in);
            char ingresso;
            int quantidade;
            Tipoingresso tipo = null;
      
            System.out.println("Informe se o ingresso é M/I");
            ingresso = comprar.next().charAt(0);
            if(ingresso == 'M') {
                tipo = Tipoingresso.MEIA;
            }
            else if(ingresso == 'I') {
                tipo = Tipoingresso.INTEIRA;
            }
            System.out.println("Informe a quantidade de ingressos: ");
            quantidade = comprar.nextInt();
      
      
           infoPartida.venderIngresso(tipo,quantidade);
      
      
            comprar.close();
      
        }





        

    



            
    }
    


