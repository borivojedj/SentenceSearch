package com.convey.sentencesearch.service;

import com.convey.sentencesearch.data.response.SentenceSearchResponse;
import com.convey.sentencesearch.service.impl.CountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CountServiceTest {

    @Test
    public void countWordsInSentenceShouldReturnExactMatch(){
        String sentence = "This is an example sentence";
        String word = "example";

        CountService countService = mock(CountServiceImpl.class);
        int count = ReflectionTestUtils.invokeMethod(countService, "countWordsInSentence", sentence, word);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void countWordsInSentenceShouldNotReturnPartialMatch(){
        String sentence = "This is a partial match";
        String word = "part";

        CountService countService = mock(CountServiceImpl.class);
        int count = ReflectionTestUtils.invokeMethod(countService, "countWordsInSentence", sentence, word);
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void countWordOccurenceTest() throws IOException {
        String word = "eggplant";
        CountService countService = new CountServiceImpl();
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        ReflectionTestUtils.setField(countService,"filePath", resourceLoader.getResource("classpath:testexample.txt"));

        SentenceSearchResponse response = countService.countWordOccurence(word);
        assertThat(response.getSentences()).hasSize(3);
        assertThat(response.getSentences().get(0).getCount()).isEqualTo(2);
        assertThat(response.getSentences().get(1).getCount()).isEqualTo(1);
        assertThat(response.getSentences().get(2).getCount()).isEqualTo(0);

    }
}
