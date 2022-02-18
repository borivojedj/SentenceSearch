package com.convey.sentencesearch.data.model;

public class Sentence {
    private int count;
    private String sentence;

    public Sentence(int count, String sentence) {
        this.count = count;
        this.sentence = sentence;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
