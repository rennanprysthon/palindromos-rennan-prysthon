package br.com.rennanprysthon.wordsearch.controller.json;

import java.util.ArrayList;
import java.util.List;

public class WordResultDTO {

    public WordResultDTO(String uuid, List<WordRowDTO> rows, List<String> results, String createdAt) {
        this.uuid = uuid;
        this.rows = rows;
        this.createdAt = createdAt;
        this.results = results;
    }

    private String uuid;
    private List<WordRowDTO> rows = new ArrayList<>();
    private List<String> results = new ArrayList<>();
    private String createdAt;
    public List<WordRowDTO> getRows() {
        return rows;
    }

    public List<String> getResults() {
        return results;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUuid() {
        return uuid;
    }
}
