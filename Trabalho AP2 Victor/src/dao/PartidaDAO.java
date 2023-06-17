package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import entidades.Partida;
import util.Arquivo;
import util.LeituraDados;

public class PartidaDAO {

    private String caminho;
    static ArrayList<Partida> partidas = new ArrayList<Partida>();
    private String nome, dataStr, local;
    private int ingressosInt, ingressosMeia;
    private double valor;
    private LocalDate data;
    private Partida partidaProcurada;
    private LeituraDados leitora;

    public PartidaDAO(LeituraDados leitora){
        this.leitora= leitora;
    }

    public PartidaDAO(String caminho) throws IOException {
        this.caminho = caminho;
        this.leitora = new LeituraDados();
    }
        

    public void criaPartida(){
        System.out.println("Insira as informações da partida:");
        System.out.print("Nome da partida: ");
        nome = leitora.lerTexto();
        if (procuraPartida(partidas, nome) != null) {
            System.out.println("Erro! Partida já foi criada!");
        } else {
            boolean dataFormatoCorreto = false;
            LocalDate data = null;
            while (!dataFormatoCorreto) {
                System.out.println("Informe a data no formato: dia/mês/ano: ");
                dataStr = leitora.lerTexto();
                try {
                    data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    dataFormatoCorreto = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Data no formato inválido! Insira novamente.");
                }
            }
            System.out.print("Local da partida: ");
            local = leitora.lerTexto();
            System.out.print("Número de ingressos tipo inteira: ");
            ingressosInt = this.leitora.lerInt();
            System.out.print("Número de ingressos tipo meia: ");
            ingressosMeia = leitora.lerInt();
            System.out.print("Valor do ingresso: ");
            valor = leitora.lerDouble();
            data = LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            partidas.add(new Partida(nome, data, local, ingressosInt, ingressosMeia, valor));
            System.out.println("Partida criada!");
        }
                    
    }

    public void editarPartida(){
        if (partidas.size() > 0) {
            System.out.print("Informe o nome da partida a ser editada: ");
            nome = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nome);
            if (partidaProcurada != null) {
                System.out.print("Data da partida: ");
                dataStr = leitora.lerTexto();
                System.out.print("Local da partida: ");
                local = leitora.lerTexto();
                System.out.print("Valor do ingresso: ");
                valor = leitora.lerDouble();
                data = LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                partidaProcurada.atualizaInfo(data, local, valor);
            } else {
                System.out.println("Partida não localizada!");
            }
        } else {
             System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void excluirPartida(){
        if (partidas.size() > 0) {
            System.out.print("Informe o nome da partida a ser excluída: ");
            nome = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nome);
            if (partidaProcurada != null) {
                partidas.remove(partidaProcurada);
                System.out.println("Partida removida!");
            } else {
                System.out.println("Partida não localizada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void retornaTodasPartidas(){
        if (partidas.size() > 0) {
            System.out.println("Informações das partidas:");
            for (Partida partida : partidas) {
                System.out.println(partida);
                System.out.println("");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }


    public void retornaUmaPartida(){
        if (partidas.size() > 0) {
            System.out.println("Infome o nome da partida: ");
            String nomeProcurado = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nomeProcurado);
            if(partidaProcurada != null){
                System.out.println(partidaProcurada);
            }else {
                System.out.println("Partida não localizada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public Partida procuraPartida(ArrayList<Partida> partidas, String nomeProcurado) {
        for (Partida partida : partidas) {
            if (nomeProcurado.equals(partida.getNome())) {
                return partida;
            }
        }

        return null;
    }


    public void exportar() throws IOException {
        List<String> linhas = new ArrayList<>();

        for (Partida partida : PartidaDAO.partidas) {
            linhas.add(partida.toString());
        }

        Arquivo.escrever(this.caminho, linhas);
    }


}
