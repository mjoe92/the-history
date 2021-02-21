package com.codecool.history;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListHistory implements History {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        text = text.replaceAll("\n", " ")
                .replaceAll(System.lineSeparator(), " ")
                .replaceAll("\t", " ")
                .replaceAll(" +", " ");
        String[] words = text.split(" ");

        wordsLinkedList.addAll(Arrays.asList(words));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {

        wordsLinkedList.removeAll(Collections.singleton(wordToBeRemoved));

    }

    @Override
    public int size() {
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {

        Collections.replaceAll(wordsLinkedList, from, to);

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        String word = "////" + String.join("////", wordsLinkedList) + "////";
        String fromWord = "//" + String.join("////", fromWords) + "//";
        String toWord = "//" + String.join("///", toWords) + "//";
        wordsLinkedList = Arrays.asList(word
                .replace(fromWord, toWord)
                .replaceAll("////", "///")
                .substring(3)
                .split("///")
        );
/*
        int i = 0;
        while (i < wordsLinkedList.size()) {
            if (!wordsLinkedList.get(i).equals(fromWords[0])) {
                i++;
                continue;
            }

            boolean match = true;
            for (int j = 1; j < fromWords.length; j++) {
                int currentIdx = i + j;
                if (currentIdx > (wordsLinkedList.size() - 1)) {
                    // end of string
                    match = false;
                    i++;
                    break;
                }

                if (!wordsLinkedList.get(currentIdx).equals(fromWords[j])) {
                    match = false;
                    i++;
                    break;
                }
            }

            if (match) {
                for (int j = 0; j < fromWords.length; j++) {
                    wordsLinkedList.remove(i);
                }
                for (int j = 0; j < toWords.length; j++) {
                    wordsLinkedList.add(i + j, toWords[j]);
                }
                i += toWords.length;
            }
        }
        */
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
