package br.com.rennanprysthon.wordsearch.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Palindrome {
    private static String reverseString(String word) {
        Stack<String> wordStack = new Stack<>();
        StringBuilder reverseWord = new StringBuilder();

        for (int i = 0; i < word.toCharArray().length; i++) {
            wordStack.push(String.valueOf(word.toCharArray()[i]));
        }


        while(!wordStack.empty()) {
            reverseWord.append(wordStack.pop());
        }

        return reverseWord.toString();
    }

    public static boolean isPalindrome(String word) {
        String reverseString = reverseString(word);
        return reverseString.equals(word);
    }

    public static List<String> findPalindromes(String words, int wordSize) {
        int wordLength = words.length();
        List<String> allWords = new ArrayList<>();

        for (int index = wordSize; index <= wordLength; index++) {
            allWords.addAll(findWords(words, index));
        }

        return allWords.stream().filter(Palindrome::isPalindrome).collect(Collectors.toList());
    }

    public static List<String> findWords(String word, int wordSlice) {
        List<String> result = new ArrayList<>();
        int wordSize = word.length() - wordSlice;

        StringBuilder wordBuilder;

        for (int indexA = 0; indexA <= wordSize; indexA++) {
            int count = 0;
            wordBuilder = new StringBuilder();

            while(count < wordSlice) {
               wordBuilder.append(word.charAt(indexA + count));

                count++;
            }

            result.add(wordBuilder.toString());
        }

        return result;
    }

    public static List<String> findPalindromeInWords(List<String> words, int wordSize) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            result.addAll(findPalindromes(word, wordSize));
        }

        return result;
    }
}
