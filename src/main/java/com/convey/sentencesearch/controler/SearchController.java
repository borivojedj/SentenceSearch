package com.convey.sentencesearch.controler;

import com.convey.sentencesearch.data.response.SentenceSearchResponse;
import com.convey.sentencesearch.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SearchController {

    @Autowired
    private CountService countService;

    @GetMapping("/count")
    public SentenceSearchResponse count(@RequestParam String word) throws IOException {
        return countService.countWordOccurence(word);
    }
}
