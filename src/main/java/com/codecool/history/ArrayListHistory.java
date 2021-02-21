package com.codecool.history;

import java.util.*;

public class ArrayListHistory implements History  {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        text = text.replaceAll("\n", " ")
                .replaceAll(System.lineSeparator(), " ")
                .replaceAll("\t", " ")
                .replaceAll(" +", " ");
        String[] words = text.split(" ");

        wordsArrayList.addAll(Arrays.asList(words));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
/*
        int i = 0;
        int j = 0;
        while (i >= 0) {
            //List<String> list = wordsArrayList.subList(i, wordsArrayList.size());
            j = Collections.indexOfSubList(wordsArrayList, Arrays.asList(fromWords));
            if (i >= 0) {
                List<String> chosenList = wordsArrayList.subList(i, i + fromWords.length);
                chosenList.clear();
                chosenList.addAll(Arrays.asList(toWords));
            }
            List<String> firstSection = wordsArrayList.subList()
        }
        */

        String word = "////" + String.join("////", wordsArrayList) + "////";
        String fromWord = "//" + String.join("////", fromWords) + "//";
        String toWord = "//" + String.join("///", toWords) + "//";
        wordsArrayList = Arrays.asList(word
                .replace(fromWord, toWord)
                .replaceAll("////", "///")
                .substring(3)
                .split("///")
        );

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
