package br.com.rennanprysthon.wordsearch.controller.json;

import java.util.List;

public class WordRowDTO {
    public WordRowDTO() {
    }

    public WordRowDTO(List<String> columns) {
        this.columns = columns;
    }

    private List<String> columns;

    public List<String> getColumns() {
        return columns;
    }

}
