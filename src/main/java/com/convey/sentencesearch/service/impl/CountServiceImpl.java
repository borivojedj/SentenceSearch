package com.convey.sentencesearch.service.impl;

import com.convey.sentencesearch.data.model.Sentence;
import com.convey.sentencesearch.data.response.SentenceSearchResponse;
import com.convey.sentencesearch.service.CountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountServiceImpl implements CountService {

    @Value("${example.file.path}")
    private Resource filePath;

    @Override
    public SentenceSearchResponse countWordOccurence(String word) throws IOException {
        List<Sentence> sentences = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(filePath.getInputStream()))) {
            br.lines().forEach(line -> {
                int count = countWordsInSentence(line, word);
                sentences.add(new Sentence(count, line));
            });
        }
        return new SentenceSearchResponse(word,
                sentences.stream()
                        .sorted(Comparator.comparing(Sentence::getCount).reversed())
                        .collect(Collectors.toList()));
    }

    private int countWordsInSentence(String sentence, String word) {
        return (int) Arrays.stream(sentence.toLowerCase(Locale.ROOT).trim().split("\\s+"))
                .filter(wordInSentence -> wordInSentence.equals(word.toLowerCase(Locale.ROOT)))
                .count();
    }
}
