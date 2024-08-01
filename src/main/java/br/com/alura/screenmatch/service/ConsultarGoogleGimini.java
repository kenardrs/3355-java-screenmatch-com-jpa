package br.com.alura.screenmatch.service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsultarGoogleGimini {

    private static final String API_KEY = EnvServices.getValue("GIMINI_API_KEY");
    private static final String ENDERECO = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=";

    public static int obterTraducao(String texto) throws IOException, InterruptedException {
        System.out.println(texto);
        var data = "{\"contents\":[{\"role\": \"user\",\"parts\":[{\"text\": \"Traduza para o português do Brasil o texto: " + texto + "\"}]}]}";
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECO+API_KEY))
                .POST(BodyPublishers.ofString(data))
                .header("Content-type", "application/json")
                .build();

        // Obter dados da tradução
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        var json = response.body();
//        ConverteDados conversor = new ConverteDados();
//        GiminiTranslation text = conversor.obterDados(json, GiminiTranslation.class);
//        System.out.println(text);
        ObjectMapper mapper = new ObjectMapper();
        var translation = mapper.readTree(json)
                .get("candidates")
                .get(0)
                .get("content")
                .get("parts")
                .get(0)
                .get("text")
                .asText();

        System.out.println(translation);
        return response.statusCode();
    }
}
