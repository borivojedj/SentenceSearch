package com.convey.sentencesearch.data.response;

import com.convey.sentencesearch.data.model.Sentence;

import java.util.List;

public class SentenceSearchResponse {
    private String word;
    private List<Sentence> sentences;

    public SentenceSearchResponse() {
    }

    public SentenceSearchResponse(String word, List<Sentence> sentences) {
        this.word = word;
        this.sentences = sentences;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
