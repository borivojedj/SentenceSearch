package com.convey.sentencesearch.service;

import com.convey.sentencesearch.data.response.SentenceSearchResponse;

import java.io.IOException;

public interface CountService {
    public SentenceSearchResponse countWordOccurence(String word) throws IOException;
}
