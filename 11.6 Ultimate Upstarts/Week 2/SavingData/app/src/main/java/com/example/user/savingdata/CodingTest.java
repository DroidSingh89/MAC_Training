package com.example.user.savingdata;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by singh on 11/13/17.
 */

public class CodingTest {

    public static void main(String[] args) {


        String[] votes = new String[]{"Michael", "Michael", "Mary", "Mary"};


        System.out.println(electionWinner(votes));
    }

    public static String electionWinner(String[] votes) {
        HashMap<String, Integer> voteCount = new HashMap<>();
        List<String> winningCandidates = new ArrayList<>();

        //count all the votes
        for (String candidate : votes) {
            Integer count = voteCount.get(candidate);
            if (count == null) {
                voteCount.put(candidate, 1);

            } else {
                voteCount.put(candidate, count + 1);
            }
        }

        //find max entry
        Map.Entry<String, Integer> maxEntry = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {

            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;

            }
        }


        maxVotes = maxEntry.getValue();

        //check to see if have multiple winners
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() == maxVotes) {
                winningCandidates.add(entry.getKey());
            }

        }


        Collections.sort(winningCandidates);


        //choose the winner alphabetically
        String winner = winningCandidates.get(winningCandidates.size() - 1);

        return winner;


    }
}
