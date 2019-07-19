package com.example.facts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.lang.Exception;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class ChuckNorrisFactController {

    Random rand;
    List<String> chuckNorrisFacts;
    final String factFile = "/static/chuck_norris_facts.txt";


    public ChuckNorrisFactController() {
        rand = new Random();
        chuckNorrisFacts = new ArrayList<>();

        InputStream factsStream = getFactsFromResource(factsFile);
        loadChuckNorrisFacts(factsStream);
    }


    @RequestMapping("/fact")
    public ChuckNorrisFact getFact() {
        return new ChuckNorrisFact(getRandomChuckNorrisFact());
    }

    @RequestMapping("/count")
    public Integer getCountOfChuckNorrisFacts() {
        return chuckNorrisFacts.size();
    }

    @RequestMapping("/citation")
    public String getCitation() {
        return "Credit for all these Chuck Norris facts goes to " +
            "http://www.killcure.com/2009/10/06/the-ultimate-list-of-chuck-norris-jokes/ " +
            "from which I blatently copied the whole list. My thanks to Varun for posting it.";
    }


    private InputStream getFactsFromResource(String resource) {
        return ChuckNorrisFactController.class.getResourceAsStream(resource);
    }

    private String getRandomChuckNorrisFact() {
        return chuckNorrisFacts.get(rand.nextInt(chuckNorrisFacts.size() -1));
    }

    private void loadChuckNorrisFacts(InputStream factsStream) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(factsStream, "UTF-8"));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                chuckNorrisFacts.add(line);
            }

            System.out.println("Imported " + chuckNorrisFacts.size() + " Chuck Norris facts.");

        }
        catch (IOException e) {
            e.printStackTrace();
            //throw e;
        }
    }

}
