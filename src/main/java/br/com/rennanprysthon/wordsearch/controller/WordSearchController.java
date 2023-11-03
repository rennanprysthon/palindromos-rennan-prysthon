package br.com.rennanprysthon.wordsearch.controller;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordResultDTO;
import br.com.rennanprysthon.wordsearch.features.FindResponses;
import br.com.rennanprysthon.wordsearch.features.GenerateReportFromMatrix;
import br.com.rennanprysthon.wordsearch.features.PersistWords;
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

    @PostMapping
    public ResponseEntity<List<String>> createWordSearchEntry(@RequestBody WordRequestDTO wordRequestDTO) {
        List<String> result = generateReportFromMatrix.findWordsInMatrix(wordRequestDTO);

        persistWords.persistTable(wordRequestDTO, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<List<WordResultDTO>> findAllWords() {
        List<WordResultDTO> wordResultDTOS = findResponses.findResponses();

        return ResponseEntity.ok(wordResultDTOS);
    }
}
