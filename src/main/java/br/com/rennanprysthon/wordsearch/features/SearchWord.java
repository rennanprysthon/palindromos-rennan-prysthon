package br.com.rennanprysthon.wordsearch.features;

import br.com.rennanprysthon.wordsearch.controller.json.WordSearchDTO;
import br.com.rennanprysthon.wordsearch.infra.database.WordResultRepository;
import br.com.rennanprysthon.wordsearch.infra.database.WordResultTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchWord {

    @Autowired
    private WordResultRepository wordResultRepository;

    public List<WordSearchDTO> searchWord(String term) {

        List<WordResultTable> wordResult = wordResultRepository.findAllByResultWordContainingIgnoreCase(term);

        return wordResult.stream().map(wordResultTable -> new WordSearchDTO(wordResultTable.getResultWord())).toList();
    }
}
