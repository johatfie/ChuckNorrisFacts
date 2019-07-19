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

    public ChuckNorrisFactController() {
        rand = new Random();
        chuckNorrisFacts = new ArrayList<>();

        //chuckNorrisFacts.add("Chuck Norris does not sleep. He waits.");
        //chuckNorrisFacts.add("Chuck Norris is currently suing NBC, claiming Law and Order are trademarked names for his left and right legs.");
        //chuckNorrisFacts.add("Chuck Norris is the reason why Waldo is hiding.");
        //chuckNorrisFacts.add("Chuck Norris counted to infinity - twice.");
        //chuckNorrisFacts.add("There is no chin behind Chuck Norris' beard. There is only another fist.");
        //chuckNorrisFacts.add("When Chuck Norris does a pushup, he isn't lifting himself up, he's pushing the Earth down.");
        //chuckNorrisFacts.add("Chuck Norris is so fast, he can run around the world and punch himself in the back of the head.");
        //chuckNorrisFacts.add("Chuck Norris' hand is the only hand that can beat a Royal Flush.");
        //chuckNorrisFacts.add("Chuck Norris can lead a horse to water AND make it drink.");
        //chuckNorrisFacts.add("Chuck Norris doesn't wear a watch, HE decides what time it is.");
        //chuckNorrisFacts.add("Chuck Norris can slam a revolving door.");
        //chuckNorrisFacts.add("Chuck Norris does not get frostbite. Chuck Norris bites frost");
        //chuckNorrisFacts.add("Remember the Soviet Union? They decided to quit after watching a DeltaForce marathon on Satellite TV.");
        //chuckNorrisFacts.add("Contrary to popular belief, America is not a democracy, it is a Chucktatorship");
        //chuckNorrisFacts.add("If you have five dollars and Chuck Norris has five dollars, Chuck Norris has more money than you.");
        //chuckNorrisFacts.add("There is no ‘ctrl' button on Chuck Norris's computer. Chuck Norris is always in control.");
        //chuckNorrisFacts.add("Apple pays Chuck Norris 99 cents every time he listens to a song.");
        //chuckNorrisFacts.add("Chuck Norris can sneeze with his eyes open.");
        //chuckNorrisFacts.add("Chuck Norris can eat just one Lay's potato chip.");
        //chuckNorrisFacts.add("Chuck Norris is suing Myspace for taking the name of what he calls everything around you.");
        //chuckNorrisFacts.add("Chuck Norris destroyed the periodic table, because he only recognizes the element of surprise.");
        //chuckNorrisFacts.add("Chuck Norris can kill two stones with one bird.");

        try {
            //ints = rand.ints(0,chuckNorrisFacts.size() -1);
            InputStream factsStream = ChuckNorrisFactController.class.getResourceAsStream("/static/chuck_norris_facts.txt");
            loadChuckNorrisFacts(factsStream);

            //loadChuckNorrisFacts(ChuckNorrisFactController.class.getResource("/static/chuck_norris_facts.txt").toURI());
            //loadChuckNorrisFacts("../src/main/resources/static/chuck_norris_facts.txt");
        }
        //catch (URISyntaxException e) {
            //e.printStackTrace();
        //}
        //catch (Exception e) {
            //e.printStackTrace();
        //}
        finally {  }
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

    private String getRandomChuckNorrisFact() {
        return chuckNorrisFacts.get(rand.nextInt(chuckNorrisFacts.size() -1));
    }

    //private void loadChuckNorrisFacts(String fileName) {
    //private void loadChuckNorrisFacts(URI fileName) {
    private void loadChuckNorrisFacts(InputStream factsStream) {

        try {
            //List<String> facts = Files.readAllLines(Paths.get(fileName));
            //List<String> facts = Files.readAllLines(Paths.get(fileName));
            //
            BufferedReader br = new BufferedReader(new InputStreamReader(factsStream, "UTF-8"));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                chuckNorrisFacts.add(line);
            }

            System.out.println("Imported " + chuckNorrisFacts.size() + " Chuck Norris facts.");

            //for(String fact : facts) {
                //chuckNorrisFacts.add(fact);
            //}

            //File f = new File("src/main/resources/static/chuck_norris_facts.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
            //throw e;
        }
        //catch (Exception e) {
            //e.printStackTrace();
            ////throw e;
        //}
    }
}
