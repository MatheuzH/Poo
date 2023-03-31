public class IngressoVIP extends Ingresso implements Pagamento {
    double valorAdicional;


    public double calcularValor() {
        return this.valor + this.valorAdicional;
    }

    @Override
    public String toString() {
        return "Valor do ingresso " + this.calcularValor();
    }


    @Override
    public double efetuarPagamento(){
        return 100 * 0.58;
    }



}
