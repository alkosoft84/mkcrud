package com.pl.alkosoft.repositories;

import com.pl.alkosoft.model.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import com.google.gson.Gson;
import com.pl.alkosoft.model.PlayerJpa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Created by mwrobel on 30.10.15.
 */
public class jsonTest {
    @Test
    public void showJSON() throws Exception {
        Gson gson = new Gson();
        PlayerJpa playerJpa = new PlayerJpa();
        Player player = new Player();
        player.setName("testName");
        player.setReputation(2);
        player.setCharacter("testChar");
        playerJpa.setPlayer(player);
        playerJpa.setId("2");
        String json = gson.toJson(playerJpa);
        System.out.println(json);
    }

    @Test
    public void setJsonData() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        try {
            System.out.println("Reading JSON file from Java program");
            //String file = "/home/mwrobel/initData.json";
            String file = "" +
                    "./src/main/resources/initData/initData.json";
            FileReader fileReader = new FileReader(file);
            JSONArray json = (JSONArray) parser.parse(fileReader);
            System.out.println(json.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }


/*// set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

// send request and parse result
        ResponseEntity<String> loginResponse = restTemplate
                .exchange(urlString, HttpMethod.POST, entity, String.class);
        if (loginResponse.getStatusCode() == HttpStatus.OK) {
            JSONObject userJson = new JSONObject(loginResponse.getBody());
        } else if (loginResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            // nono... bad credentials
        }*/
    }

}
