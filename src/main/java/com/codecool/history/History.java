package com.codecool.history;

public interface History {

    /**
     * Simply adds String sequence to a list
     *
     * @param text: the String sequence what needs to be added
     */
    void add(String text);

    /**
     * Removes all matched String sequence from a list
     *
     * @param wordToBeRemoved: the sentence or word what needs to be removed from the list
     */
    void removeWord(String wordToBeRemoved);

    /**
     * Returns back the size of the list
     */
    int size();

    /**
     * Clears the list
     */
    void clear();

    /**
     * Replaces a String sequence to another
     *
     * @param from: searched replaceable sentence or word
     * @param to: replacing String sequence
     */
    void replaceOneWord(String from, String to);

    /**
     * Replaces a String array of sequences to another
     *
     * @param fromWords: searched replaceable String elements of array (in order)
     * @param toWords: replacing String elements of array (in order)
     */
    void replaceMoreWords(String[] fromWords, String[] toWords);

    /**
     * DON'T rewrite this method!
     * replaces all occurrences of sentences or words with sentences or words.
     * The tests are using this method instead of replaceOneWord() or replaceMoreWords().
     *
     * @param from: the sentence or word what needs to be replaced
     * @param to:   the sentence or word which replaces the sentence found in 'from'
     */
    default void replace(String from, String to) {
        String[] fromWords = from.split("\\s+");
        String[] toWords = to.split("\\s+");
        if (fromWords.length == 1 && toWords.length == 1) {
            replaceOneWord(from, to);
        } else {
            replaceMoreWords(fromWords, toWords);
        }
    }
}
