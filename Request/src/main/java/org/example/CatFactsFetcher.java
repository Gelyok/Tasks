package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CatFactsFetcher {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        CloseableHttpResponse response = httpClient.execute(request);

        ObjectMapper objectMapper = new ObjectMapper();
        List<org.example.CatFact> catFacts = objectMapper.readValue(response.getEntity().getContent(), objectMapper.getTypeFactory().constructCollectionType(List.class, org.example.CatFact.class));
        List<CatFact> filteredCatFacts = catFacts.stream()
                .filter(fact -> fact.getUpvotes() != null)
                .collect(Collectors.toList());

        filteredCatFacts.forEach(System.out::println);

        httpClient.close();
    }
}
