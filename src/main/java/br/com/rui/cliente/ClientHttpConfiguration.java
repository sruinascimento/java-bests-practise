package br.com.rui.cliente;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttpConfiguration implements ClientHttp {
    private HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> dispararRequisicaoGet(String uri)  {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> dispararRequisicaoPost(String uri, JsonObject json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
