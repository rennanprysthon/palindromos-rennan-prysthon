package br.com.rennanprysthon.wordsearch.controller;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordResultDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordSearchDTO;
import br.com.rennanprysthon.wordsearch.features.FindResponses;
import br.com.rennanprysthon.wordsearch.features.GenerateReportFromMatrix;
import br.com.rennanprysthon.wordsearch.features.PersistWords;
import br.com.rennanprysthon.wordsearch.features.SearchWord;
import br.com.rennanprysthon.wordsearch.infra.database.WordResultRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("word-search")
public class WordSearchController {
    @Autowired
    private GenerateReportFromMatrix generateReportFromMatrix;

    @Autowired
    private PersistWords persistWords;

    @Autowired
    private FindResponses findResponses;

    @Autowired
    private SearchWord searchWord;

    @PostMapping
    public ResponseEntity<List<String>> createWordSearchEntry(@RequestBody WordRequestDTO wordRequestDTO) {
        List<String> result = generateReportFromMatrix.findWordsInMatrix(wordRequestDTO);

        persistWords.persistTable(wordRequestDTO, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<WordResultDTO>> findAllWords(
        @RequestParam(name = "term", defaultValue = "") String term
    ) {
        List<WordResultDTO> wordResultDTOS = findResponses.findResponses();

        return ResponseEntity.ok(wordResultDTOS);
    }

    @GetMapping("/search")
    public ResponseEntity<List<WordSearchDTO>> searchWord(
        @RequestParam(name = "term", defaultValue = "") String term
    ) {
        List<WordSearchDTO> wordSearchDTOS  = searchWord.searchWord(term);

        return ResponseEntity.ok(wordSearchDTOS);
    }
}
