package br.com.rennanprysthon.wordsearch.features;

import br.com.rennanprysthon.wordsearch.controller.json.WordRequestDTO;
import br.com.rennanprysthon.wordsearch.controller.json.WordRowDTO;
import br.com.rennanprysthon.wordsearch.model.Palindrome;
import br.com.rennanprysthon.wordsearch.model.WordMatrix;
import br.com.rennanprysthon.wordsearch.model.WordMatrixInvalidException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateReportFromMatrix {
    String[][] extractMatrixFromDTO(WordRequestDTO wordRequestDTO) {
        validateDTO(wordRequestDTO);
        int matrixSize = wordRequestDTO.getRows().size();

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int indexA = 0; indexA < wordRequestDTO.getRows().size(); indexA++) {
            for (int indexB = 0; indexB < wordRequestDTO.getRows().get(indexA).getColumns().size(); indexB++) {
                matrix[indexA][indexB] = wordRequestDTO.getRows().get(indexA).getColumns().get(indexB);
            }
        }

        return matrix;
    }

    public List<String> findWordsInMatrix(WordRequestDTO wordRequestDTO) {
        String[][] matrix = extractMatrixFromDTO(wordRequestDTO);
        WordMatrix wordMatrix =  WordMatrix.builder()
            .withWordSize(4)
            .withMatrix(matrix)
            .build();

        List<String> words = wordMatrix.findAllWords();

        return Palindrome.findPalindromeInWords(words, wordRequestDTO.getWordSize());

    }

    void validateDTO(WordRequestDTO wordRequestDTO) {
        int baseSize = wordRequestDTO.getRows().size();

        for (WordRowDTO row : wordRequestDTO.getRows()) {
            if (row.getColumns().size() != baseSize) {
                throw new WordMatrixInvalidException(
                    String.format(
                        "You should inform a matrix with correct sizes. You sent [%d][%d]",
                        baseSize,
                        row.getColumns().size()
                    )
                );
            }
        }
    }
}
