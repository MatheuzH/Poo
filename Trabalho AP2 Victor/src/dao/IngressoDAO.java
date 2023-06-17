package dao;

import java.util.ArrayList;

import entidades.Assento;
import entidades.Partida;
import entidades.ingresso.Ingresso;
import entidades.ingresso.IngressoInteira;
import entidades.ingresso.IngressoMeia;
import entidades.ingresso.TipoIngresso;
import util.LeituraDados;


public class IngressoDAO {
    private String opcaoIngresso, nomeBusca;
    private char letraAssento;
    private TipoIngresso tipo;
    private Ingresso ingresso = null;
    private int numeroAssento;
    private Assento assento;
    private Partida partidaVenda;
    private ArrayList<Partida> partidas = PartidaDAO.partidas;
    private static ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();
    private PartidaDAO partidaDAO;
    private LeituraDados leitora;

    public IngressoDAO(){
        this.leitora = new LeituraDados();
        this.partidaDAO = new PartidaDAO(leitora);
    }


    public void lerVendaIngresso(){
        
        if (partidas.size() > 0) {
            System.out.println("Vendendo um ingresso!");
            System.out.print("Informe o nome da partida que deseja comprar ingresso: ");
            nomeBusca = this.leitora.lerTexto();

            partidaVenda = partidaDAO.procuraPartida(partidas, nomeBusca);
            if (partidaVenda != null) {
                ingresso = venderIngresso(partidaVenda);
            } else {
                System.out.println("Erro! Partida com nome " + nomeBusca + " não encontrada!");
            }

        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public Ingresso venderIngresso(Partida partidaVenda) {
        System.out.print("Letra do assento: ");
        letraAssento = leitora.lerChar();
        System.out.print("Número do assento: ");
        numeroAssento = leitora.lerInt();
        assento = new Assento(numeroAssento, letraAssento);
        System.out.println("Nome da partida: " + partidaVenda.getNome());

        System.out.print("O seu ingresso é meia (s/n)? ");
        opcaoIngresso = this.leitora.lerTexto();
        
        if (opcaoIngresso.equals("s")) {
            tipo = TipoIngresso.MEIA;
            ingresso = new IngressoMeia(partidaVenda, assento);
        } else {
            tipo = TipoIngresso.INTEIRA;
            ingresso = new IngressoInteira(partidaVenda, assento);
        }
        partidaVenda.venderIngresso(tipo);
        ingressos.add(ingresso);
        return ingresso;
    }


    public void ingressosVendidos(){
        if (partidas.size() > 0) {
            System.out.println("Informe o nome da partida: ");
            String nomePartida = leitora.lerTexto();
            partidaVenda = partidaDAO.procuraPartida(partidas, nomePartida);
            if (partidaVenda != null) {
                boolean possuiIngressosVendidos = false; 
                for (Ingresso ingresso : ingressos) {
                    if (ingresso.getPartida().equals(partidaVenda)) {
                        System.out.println("\n Ingressos vendidos: ");
                        System.out.println(ingresso);
                        System.out.println("");
                        possuiIngressosVendidos = true;
                    }
                }
                if (!possuiIngressosVendidos) {
                    System.out.println("Você precisa primeiro vender um ingresso!");
                } 
            } else {
            System.out.println("Partida não encontrada!");
            }
        }else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void ingressoUmaPartida(){
        if (partidas.size() > 0) {
            boolean partidaEncontrada = false;
            System.out.println("Informe o nome da partida: ");
            String nomePartida = leitora.lerTexto();
            for (Partida partida : partidas) {
                if (partida.getNome().equals(nomePartida)) {
                    System.out.println("Ingressos disponíveis: " + partida.getIngressos());
                    partidaEncontrada = true;
                    break;
                }
            }
            if (!partidaEncontrada) {
                System.out.println("Partida não encontrada!");
            }
        }else {
        System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void ingressosTotal(){
        if (partidas.size() > 0) {
            System.out.println("Ingressos disponíveis:");
            for (Partida partida : partidas) {
                System.out.println(partida.getNome() + ": " + partida.getIngressos());
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }


    public void ultimoIngresso(){
        if (ingresso != null) {
            System.out.println("Informações sobre o último ingresso vendido:");
            System.out.println(ingresso);
        } else {
            System.out.println("Você precisa primeiro vender um ingresso!");
        }
    }

}
