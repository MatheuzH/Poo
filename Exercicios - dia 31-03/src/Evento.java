public abstract class Evento {
    String nome;
    String local;
    double capacidade;
    Ingresso ingresso;

    Evento(String nome, String local, int capacidade, Ingresso ingresso){
        this.nome = nome;
        this.local= local;
        this.capacidade = capacidade;
        this.ingresso = ingresso;
    }


    public double calcularReceita(){
        return this.ingresso.valor * this.capacidade;
    }


    public abstract void gravar();

    public boolean verificarCapacidade(int numPessoas) {
        if (numPessoas <= this.capacidade) {
            return true;
        }
        return false;
    }






}
