package br.com.rennanprysthon.wordsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void firstDiagonal(String[][] matrix, int size) {
        List<String> words = new ArrayList<>();
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

            words.add(word.toString());
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

            words.add(word.toString());
        }

        for (String wordAux : words) {
            System.out.println(wordAux);

        }
    }
    public static void secondDiagonal(String[][] matrix, int size) {
        List<String> words = new ArrayList<>();
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

            words.add(word.toString());
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

            words.add(word.toString());
        }

        for (String wordAux : words) {
            System.out.println(wordAux);
        }
    }

    public static void main(String[] args) {
        String[][] matrix = new String[][] {
                {"1", "2", "3", "4", "5"},
                {"6", "7", "8", "9", "A"},
                {"B", "C", "D", "E", "F"},
                {"G", "H", "I", "J", "K"},
                {"L", "M", "N", "O", "P"},
        };

        //firstDiagonal(matrix, matrix.length);
        //secondDiagonal(matrix, matrix.length);
        findHorizontal(matrix, matrix.length);
        //findVerticals(matrix, matrix.length);
    }

    private static void findVerticals(String[][] matrix, int size) {
        for (int indexA = 0; indexA < size; indexA++) {
            for (int indexB = 0; indexB < size; indexB++) {
                System.out.printf("m[%d][%d]", indexA, indexB);
            }

            System.out.println();
        }
    }

    private static void findHorizontal(String[][] matrix, int size) {
        for (int indexA = 0; indexA < size; indexA++) {
            for (int indexB = 0; indexB < size; indexB++) {
                System.out.printf("m[%d][%d]", indexB, indexA);
            }

            System.out.println();
        }
    }

}
