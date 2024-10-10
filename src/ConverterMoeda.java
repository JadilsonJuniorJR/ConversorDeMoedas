public class ConverterMoeda {
    private final double valor;
    private final double taxaDeConversao;

    public ConverterMoeda(double valor, double conversionRate) {
        //Calculando a conversão das moedas
        this.valor= valor;
        this.taxaDeConversao=conversionRate;

    }

    public double CalcularConversao(){
        return valor*taxaDeConversao;
    }

}
