package com.example.facts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.stream.IntStream;


@RestController
public class ChuckNorrisFactController {

    Random rand;
    //IntStream ints;
    List<String> chuckNorrisFacts;

    public ChuckNorrisFactController() {
        rand = new Random();
        chuckNorrisFacts = new ArrayList<>();

        chuckNorrisFacts.add("Chuck Norris does not sleep. He waits.");
        chuckNorrisFacts.add("Chuck Norris is currently suing NBC, claiming Law and Order are trademarked names for his left and right legs.");
        chuckNorrisFacts.add("Chuck Norris is the reason why Waldo is hiding.");
        chuckNorrisFacts.add("Chuck Norris counted to infinity - twice.");
        chuckNorrisFacts.add("There is no chin behind Chuck Norris' beard. There is only another fist.");
        chuckNorrisFacts.add("When Chuck Norris does a pushup, he isn't lifting himself up, he's pushing the Earth down.");
        chuckNorrisFacts.add("Chuck Norris is so fast, he can run around the world and punch himself in the back of the head.");
        chuckNorrisFacts.add("Chuck Norris' hand is the only hand that can beat a Royal Flush.");
        chuckNorrisFacts.add("Chuck Norris can lead a horse to water AND make it drink.");
        chuckNorrisFacts.add("Chuck Norris doesn't wear a watch, HE decides what time it is.");
        chuckNorrisFacts.add("Chuck Norris can slam a revolving door.");
        chuckNorrisFacts.add("Chuck Norris does not get frostbite. Chuck Norris bites frost");
        chuckNorrisFacts.add("Remember the Soviet Union? They decided to quit after watching a DeltaForce marathon on Satellite TV.");
        chuckNorrisFacts.add("Contrary to popular belief, America is not a democracy, it is a Chucktatorship");
        chuckNorrisFacts.add("If you have five dollars and Chuck Norris has five dollars, Chuck Norris has more money than you.");
        chuckNorrisFacts.add("There is no ‘ctrl' button on Chuck Norris's computer. Chuck Norris is always in control.");
        chuckNorrisFacts.add("Apple pays Chuck Norris 99 cents every time he listens to a song.");
        chuckNorrisFacts.add("Chuck Norris can sneeze with his eyes open.");
        chuckNorrisFacts.add("Chuck Norris can eat just one Lay's potato chip.");
        chuckNorrisFacts.add("Chuck Norris is suing Myspace for taking the name of what he calls everything around you.");
        chuckNorrisFacts.add("Chuck Norris destroyed the periodic table, because he only recognizes the element of surprise.");
        chuckNorrisFacts.add("Chuck Norris can kill two stones with one bird.");

        //ints = rand.ints(0,chuckNorrisFacts.size() -1);
    }


    @RequestMapping("/fact")
    public ChuckNorrisFact getFact() {
        return new ChuckNorrisFact(getRandomChuckNorrisFact());
    }

    private String getRandomChuckNorrisFact() {
        return chuckNorrisFacts.get(rand.nextInt(chuckNorrisFacts.size() -1));
}
