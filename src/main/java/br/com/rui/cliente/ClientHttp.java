package br.com.rui.cliente;

import com.google.gson.JsonObject;

import java.net.http.HttpResponse;

public interface ClientHttp {
    HttpResponse<String> dispararRequisicaoGet(String uri);
    HttpResponse<String> dispararRequisicaoPost(String uri, JsonObject json);
}
