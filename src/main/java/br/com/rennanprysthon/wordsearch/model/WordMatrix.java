package br.com.rennanprysthon.wordsearch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordMatrix {
    private final String[][] matrix;
    private final int wordSize;

    public WordMatrix(String[][] matrix, int wordSize) {
        this.matrix = matrix;
        this.wordSize = wordSize;
    }

    public static WordMatrixBuilder builder() {
        return new WordMatrixBuilder();
    }

    private List<String> findAllHorizontalWords() {
        List<String> result = new ArrayList<>();
        int size = matrix.length;

        StringBuilder word;
        for (String[] strings : matrix) {
            word = new StringBuilder();
            for (int indexB = 0; indexB < size; indexB++) {
                word.append(strings[indexB]);
            }

            result.add(word.toString());
        }

        return result;
    }
    private List<String> findAllVerticalWords() {
        List<String> result = new ArrayList<>();
        int size = matrix.length;
        StringBuilder word;

        for (int indexA = 0; indexA < size; indexA++) {
            word = new StringBuilder();
            for (int indexB = 0; indexB < size; indexB++) {
                word.append(matrix[indexB][indexA]);
            }

            result.add(word.toString());
        }

        return result;
    }
    private List<String> findAllFirstDiagonalsWords() {
        List<String> result = new ArrayList<>();
        int size = matrix.length;
        StringBuilder word;

        for (int k = 0; k <= size - 1; k++) {
            int i = k;
            int j = 0;
            word = new StringBuilder();

            while(i >= 0) {
                word.append(matrix[i][j]);
                i--;
                j++;
            }

            result.add(word.toString());
        }

        for (int k = 1; k <= size - 1; k++) {
            int i = size - 1;
            int j = k;
            word = new StringBuilder();

            while (j <= size - 1) {
                word.append(matrix[i][j]);
                i--;
                j++;
            }

            result.add(word.toString());
        }

        return result;
    }
    private List<String> findAllSecondDiagonalsWords() {
        List<String> result = new ArrayList<>();
        int size = matrix.length;
        StringBuilder word;

        for (int k = 0; k < size ; k++) {
            int i = k;
            int j = size - 1;

            word = new StringBuilder();

            while(i >= 0) {
                word.append(matrix[i][j]);

                i--;
                j--;
            }

            result.add(word.toString());
        }

        for (int k = size - 2; k >= 0 ; k--) {
            int i = size - 1;
            int j = k;

            word = new StringBuilder();

            while(j >= 0) {
                word.append(matrix[i][j]);

                i--;
                j--;
            }

            result.add(word.toString());
        }

        return result;
    }

    public List<String> findAllWords() {
        List<String> result = new ArrayList<>();

        result.addAll(findAllHorizontalWords());
        result.addAll(findAllVerticalWords());
        result.addAll(findAllFirstDiagonalsWords());
        result.addAll(findAllSecondDiagonalsWords());

        return result.stream().filter(word -> word.length() >= wordSize).collect(Collectors.toList());
    }

    public static class WordMatrixBuilder {
        private static final int MAXIMUM_COLUMN_ROW_SIZE = 10;
        private String[][] matrix;
        private int wordSize;

        public WordMatrixBuilder withMatrix(String[][] matrix) {
            this.matrix = matrix;
            return this;
        }

        public WordMatrix build() {
            return new WordMatrix(matrix, wordSize);
        }

        public WordMatrixBuilder withWordSize(int wordSize) {
            this.wordSize = wordSize;
            return this;
        }
    }
}
