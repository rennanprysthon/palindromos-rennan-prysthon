package br.com.rennanprysthon.wordsearch.features;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordResultDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordRowDTO;
import br.com.rennanprysthon.wordsearch.infra.database.WordRowTable;
import br.com.rennanprysthon.wordsearch.infra.database.WordTable;
import br.com.rennanprysthon.wordsearch.infra.database.WordTableRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindResponses {

    private final WordTableRepository wordTableRepository;

    public FindResponses(WordTableRepository wordTableRepository) {
        this.wordTableRepository = wordTableRepository;
    }

    private String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return simpleDateFormat.format(date);
    }

    private WordResultDTO generateFromEntity(WordTable wordTable) {
        List<WordRowDTO> wordRowDTOS = new ArrayList<>();

        for (WordRowTable row : wordTable.getRows()) {
            wordRowDTOS.add(new WordRowDTO(row.getColumns()));
        }

        WordResultDTO wordResultDTO = new WordResultDTO(
            wordTable.getUuid(),
            wordRowDTOS,
            wordTable.getResults(),
            formatDate(wordTable.getCreatedAt())
        );

        return wordResultDTO;
    }

    public List<WordResultDTO> findResponses() {
        List<WordTable> words = wordTableRepository.findAll();

        return words.stream().map(this::generateFromEntity).toList();
    }

}
