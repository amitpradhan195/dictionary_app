package com.example.dictionaryapp;

public class modelDictionary {

    private String word;
    private int wordId;
    private String meaning;

    public modelDictionary(String word, int wordId, String meaning) {
        this.word = word;
        this.wordId = wordId;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}
