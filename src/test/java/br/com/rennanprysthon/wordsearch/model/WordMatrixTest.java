package br.com.rennanprysthon.wordsearch.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class WordMatrixTest {
    @Test
    void shouldGetAllWords() {
        String[][] matrix = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
        };

        WordMatrix wordMatrix = WordMatrix
            .builder()
            .withMatrix(matrix)
            .withWordSize(3)
            .build();

        List<String> result = wordMatrix.findAllWords();
        List<String> expected = Arrays.asList("123", "456", "789", "147", "258", "369", "951", "753");

        assertTrue(result.size() == expected.size() && result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void shouldGetAllWordsWithDifferentWordSize() {
        String[][] matrix = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        WordMatrix wordMatrix = WordMatrix
                .builder()
                .withMatrix(matrix)
                .withWordSize(2)
                .build();

        List<String> result = wordMatrix.findAllWords();
        List<String> expected = Arrays.asList("123", "456", "789", "147", "258", "369", "951", "753", "42", "86", "62", "84");

        assertTrue(result.size() == expected.size() && result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void shouldGetAllWordsWithMoreItems() {
        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"4", "5", "6", "7"},
                {"8", "9", "A", "B" },
                {"C", "D", "E", "F" }
        };

        WordMatrix wordMatrix = WordMatrix
            .builder()
            .withMatrix(matrix)
            .withWordSize(3)
            .build();

        List<String> result = wordMatrix.findAllWords();
        List<String> expected = Arrays.asList(
            "1234",
            "4567",
            "89AB",
            "CDEF",
            "148C",
            "259D",
            "36AE",
            "47BF",
            "B62",
            "FA51",
            "E94",
            "853",
            "C964",
            "DA7"
        );

        assertTrue(result.size() == expected.size() && result.containsAll(expected) && expected.containsAll(result));
    }


    @Test
    void caseTest() {
        String[][] words = {
            {"A", "O", "S", "S", "O"},
            {"Y", "R", "Z", "X", "L"},
            {"J", "S", "A", "P", "M"},
            {"J", "K", "P", "R", "Z"},
            {"Y", "L", "E", "R", "A"},
        };
        WordMatrix wordMatrix = WordMatrix
            .builder()
            .withMatrix(words)
            .withWordSize(4)
            .build();


        List<String> result = wordMatrix.findAllWords();
        List<String> expected = Arrays.asList(
            "AOSSO", "YRZXL", "JSAPM", "JKPRZ", "YLERA",
            "AYJJY", "ORSKL", "SZAPE", "SXPRR", "OLMZA",
            "ZPZO", "ARARA", "RPSY", "JSZS", "YKAXO", "LPPL"
        );


        assertTrue(result.size() == expected.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));

    }
}
