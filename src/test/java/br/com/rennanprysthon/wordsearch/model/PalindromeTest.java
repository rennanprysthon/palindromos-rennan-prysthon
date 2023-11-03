package br.com.rennanprysthon.wordsearch.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PalindromeTest {
    @Test
    void shouldReturnFalseIfNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("AABAR"));
    }

    @Test
    void shouldReturnTrueIfNotPalindrome() {
        assertTrue(Palindrome.isPalindrome("AABAA"));
    }

    @Test
    void shouldNotReturnAnyPalindromes() {
        String words = "YYASDFA";

        List<String> result = Palindrome.findPalindromes(words, 5);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnAllWordsInString() {
        String word = "ABCD";
        List<String> expected = List.of("ABC", "BCD");

        List<String> result = Palindrome.findWords(word, 3);

        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void shouldReturnAllWordsInStringPartTwo() {
        String word = "ABCDEF";
        List<String> expected = List.of(
            "ABCD",
            "BCDE",
            "CDEF"
        );

        List<String> result = Palindrome.findWords(word, 4);

        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void findPalindromes() {
        String words = "AASAABBABB";

        List<String> expected = Arrays.asList("AASAA", "BBABB", "ABBA");

        List<String> result = Palindrome.findPalindromes(words, 4);

        assertTrue(result.size() == expected.size() && result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void findPalindromesInArray() {
        List<String> words = Arrays.asList(
                "AOSSO", "YRZXL", "JSAPM", "JKPRZ", "YLERA",
                "AYJJY", "ORSKL", "SZAPE", "SXPRR", "OLMZA",
                "ZPZO", "ARARA", "RPSY", "JSZS", "YKAXO", "LPPL"
        );

        List<String> expected = Arrays.asList(
            "OSSO", "YJJY", "LPPL", "ARARA"
        );

        List<String> result = Palindrome.findPalindromeInWords(words, 4);

        assertTrue(expected.size() == result.size());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }
}
