package br.com.rennanprysthon.wordsearch.controller.json;

import java.util.List;

public class WordSearchDTO {
    private String word;

    public WordSearchDTO(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
