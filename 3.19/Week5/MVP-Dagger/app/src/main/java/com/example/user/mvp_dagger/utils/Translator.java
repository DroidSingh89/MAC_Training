package com.example.user.mvp_dagger.utils;

import com.example.user.mvp_dagger.model.Sentence;

import java.util.Arrays;
import java.util.List;

public class Translator {


    public static Sentence toPigLatin(Sentence sentence) {

        String str = sentence.getSentence();
        List<String> words = Arrays.asList(str.split("\\s+"));

        StringBuilder latinBuilder = new StringBuilder();
        for (String word : words) {
            translateWord(latinBuilder, word);
        }

        sentence.setSentence(latinBuilder.toString());
        return sentence;

    }

    private static void translateWord(StringBuilder latinBuilder, String word) {

        String vowels = "AEIOUaeiou";

        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            index = vowels.indexOf(word.charAt(i));
            if (index > -1) {
                index = i;
                break;
            }
        }
        String newWord = word.substring(index, word.length()) + word.substring(0, index) + "ay";

        latinBuilder.append(newWord).append(" ");



    }

}
