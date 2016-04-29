package com.pl.alkosoft;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.pl.alkosoft.repositories.PlayerRepositoryMongo;

@SpringBootApplication
public class MkCrudStarter implements CommandLineRunner {
    @Autowired
    private PlayerRepositoryMongo playerRepositoryMongo;



    private static final Logger log = LoggerFactory.getLogger(MkCrudStarter.class);
    private static final String TEST_DATA_PATH = "./src/main/resources/initData/initData.json";
    private static final String WEBSERVICE_PATH = "http://localhost:8080/mkcrudinit";

    public static void main(String[] args) {
        SpringApplication.run(MkCrudStarter.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {
        clearMongoDb();
        loadTestData();
    }

    private void clearMongoDb() {
        playerRepositoryMongo.deleteAll();
    }

    private void loadTestData() throws IOException, ParseException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        JSONArray jsonData = getTestData();

        jsonData.stream()
                .map(x -> new HttpEntity(x, headers))
                .forEach(x -> {
                    log.info(x.toString());
                    restTemplate.postForLocation(WEBSERVICE_PATH, x);
                });

        /*
         * for (int i = 0; i < jsonData.size(); i++) { HttpEntity request = new
         * HttpEntity(jsonData.get(i), headers);
         * restTemplate.postForLocation(WEBSERVICE_PATH, request);
         * log.info(request.toString()); }
         */
    }

    private JSONArray getTestData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader(TEST_DATA_PATH);
        return (JSONArray) parser.parse(fileReader);
    }
}
