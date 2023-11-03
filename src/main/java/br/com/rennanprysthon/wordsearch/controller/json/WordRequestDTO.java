package br.com.rennanprysthon.wordsearch.controller.json;

import java.util.ArrayList;
import java.util.List;

public class WordRequestDTO {
    public WordRequestDTO() {
    }

    public WordRequestDTO(List<WordRowDTO> rows) {
        this.rows = rows;
    }

    private List<WordRowDTO> rows = new ArrayList<>();
    private int wordSize;

    public List<WordRowDTO> getRows() {
        return rows;
    }

    public int getWordSize() {
        return wordSize;
    }
}
