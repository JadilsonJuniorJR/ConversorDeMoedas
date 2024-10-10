import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolitacaoCliente {

    private static String ApiKey = "7f10ab90456abcc18d12fa20";

    public static void EnviaSolicitacao(String moeda1, String moeda2, double valor) {
        try {

            String url_str = "https://v6.exchangerate-api.com/v6/" + ApiKey + "/pair/"+ moeda1 +"/"+ moeda2;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_str))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            //Transformando um Json em Titulo Classe
            String json = response.body();

            // Convertendo o JSON
            Gson gson = new Gson();
            RetornoAPI retorno = gson.fromJson(json, RetornoAPI.class);

            ConverterMoeda converterMoeda = new ConverterMoeda(valor, retorno.getConversionRate() );

            System.out.println("\n\nO valor de "+valor+" ["+ moeda1 +"] corresponde ao valor final de =>> "+
                    converterMoeda.CalcularConversao() + " [" + moeda2+"]");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
