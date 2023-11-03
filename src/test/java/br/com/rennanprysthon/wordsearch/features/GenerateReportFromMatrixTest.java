package br.com.rennanprysthon.wordsearch.features;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordRowDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenerateReportFromMatrixTest {
    @Test
    void shouldExtractMatrixFromDTO() {
        List<WordRowDTO> rows = new ArrayList<>();

        rows.add(new WordRowDTO(Arrays.asList(
            "A", "B", "C"
        )));
        rows.add(new WordRowDTO(Arrays.asList(
            "D", "E", "F"
        )));
        rows.add(new WordRowDTO(Arrays.asList(
            "G", "H", "J"
        )));

        WordRequestDTO wordRequestDTO = new WordRequestDTO(rows);

        GenerateReportFromMatrix generateReportFromMatrix = new GenerateReportFromMatrix();

        String[][] matrix = generateReportFromMatrix.extractMatrixFromDTO(wordRequestDTO);
        String[][] expected = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "J"},
        };

        assertArrayEquals(expected, matrix);
    }
}