package programa;

import java.io.IOException;

import dao.IngressoDAO;
import dao.PartidaDAO;
import util.LeituraDados;


public class Gestor {
    LeituraDados leitora;
    PartidaDAO partidaDAO;
    IngressoDAO ingressoDAO;

    public Gestor(String caminho) throws IOException {
        this.leitora = new LeituraDados();
        this.partidaDAO = new PartidaDAO(caminho);
        this.ingressoDAO = new IngressoDAO();
    }

    public String opcoes() {
            String msg;

            msg = "\n------\n";
            msg += "Sistema de compra de ingressos!\n";
            msg += "Insira a opção desejada conforme o menu abaixo, ou digite outra mensagem para sair do programa:\n";
            msg += "1 - Cadastrar uma nova partida;\n";
            msg += "2 - Realizar a venda de um ingresso;\n";
            msg += "3 - Exibir informações de todas as partida;\n";
            msg += "4 - Exibir informações de uma partida; \n";
            msg += "5 - Exibir o número de ingressos restantes de todas as partidas;\n";
            msg += "6 - Exibir o número de ingressos restantes de uma partida;\n";
            msg += "7 - Exibir ingressos vendidos em uma partida;\n";
            msg += "8 - Exibir informações sobre o último ingresso vendido;\n";
            msg += "9 - Excluir uma partida;\n";
            msg += "10 - Editar informações de uma partida;\n";
           

        return msg;
    }

    public String run() throws IOException {
        String opcao = leitora.lerTexto();
            switch (opcao) {
                case "1":
                    partidaDAO.criaPartida();
                    break;
                case "2":
                    ingressoDAO.lerVendaIngresso();;
                    break;
                case "3":
                    partidaDAO.retornaTodasPartidas();
                    break;
                case "4":
                    partidaDAO.retornaUmaPartida();
                    break;
                case "5":
                    ingressoDAO.ingressosTotal();
                    break;
                case "6":
                    ingressoDAO.ingressoUmaPartida();
                    break;
                case "7":
                    ingressoDAO.ingressosVendidos();
                    break;
                case "8":
                    ingressoDAO.ultimoIngresso();
                    break;
                case "9":
                    partidaDAO.excluirPartida();
                    break;
                case "10":
                    partidaDAO.editarPartida();
                    break;
                default:
                    partidaDAO.exportar();
                    System.out.println("Saindo do programa...");
                    opcao = "";
            }
            
        return opcao;
    }
       
} 


