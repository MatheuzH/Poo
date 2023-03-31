public class Cinema extends Evento {
    String cinema, sala, genero;

    @Override
    public void gravar() {
        System.out.println("Você não deveria gravar um filme...");
    }

    Cinema(String nome, String local, int capacidade, Ingresso ingresso) {
        super(nome,local,capacidade,ingresso);
    }

    @Override
    public String toString() {
        String msg;
        msg = "Filme " + this.nome + "\n";
        msg += "Cinema " + this.cinema + ", sala " + this.sala + "\n";
        msg += "Gênero: " + this.genero + "\n";
        msg += "local: " + this.local + "\n";
        msg += "capacidade da sala: " + this.capacidade + " pessoas";

        return msg;
    }
}

