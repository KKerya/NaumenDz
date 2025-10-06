package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Task4 {
    public static void run() throws  IOException, InterruptedException{
        SyncHttpClientExample.getHttpRequest();
    }
}

class SyncHttpClientExample
{
    public static void getHttpRequest() throws IOException, InterruptedException
    {
        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/user-agent"))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());
            String temp = json.getString("");
            System.out.println("" + temp);
        }
    }
}


