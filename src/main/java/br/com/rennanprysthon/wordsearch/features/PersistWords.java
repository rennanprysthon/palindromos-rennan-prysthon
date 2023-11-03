package br.com.rennanprysthon.wordsearch.features;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordRowDTO;
import br.com.rennanprysthon.wordsearch.infra.database.WordRowTable;
import br.com.rennanprysthon.wordsearch.infra.database.WordTable;
import br.com.rennanprysthon.wordsearch.infra.database.WordTableRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersistWords {
    private final WordTableRepository wordTableRepository;

    public PersistWords(WordTableRepository wordTableRepository) {
        this.wordTableRepository = wordTableRepository;
    }

    public void persistTable(WordRequestDTO wordRequestDTO, List<String> results) {
        WordTable wordTable = new WordTable();
        WordRowTable wordRowTable;

        for (WordRowDTO row : wordRequestDTO.getRows()) {
            wordRowTable = new WordRowTable();
            wordRowTable.setColumns(row.getColumns());
            wordTable.getRows().add(wordRowTable);
        }

        wordTable.setCreatedAt(new Date());
        wordTable.setResults(results);

        wordTableRepository.save(wordTable);

    }
}
