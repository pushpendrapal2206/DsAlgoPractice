package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 * <p>
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> wordsInCurrentLine = new ArrayList<>();
        int currentLineLength = 0;

        List<String> output = new ArrayList<>();
        int wordArrayLength = 0;
        for (String word : words) {
            if (currentLineLength + word.length() + wordsInCurrentLine.size() > maxWidth) {
                int totalSpacesInCurrentLine = maxWidth - currentLineLength;
                int numberOfSpacesForEqualDistribution = totalSpacesInCurrentLine / Math.max(1, wordsInCurrentLine.size() - 1);
                int remainingSpacesAfterEqualDistribution = totalSpacesInCurrentLine % Math.max(1, wordsInCurrentLine.size() - 1);

                insertSpacesBetweenWords(wordsInCurrentLine, numberOfSpacesForEqualDistribution);

                if (remainingSpacesAfterEqualDistribution > 0) {
                    insertSingleSpaceBetweenWords(wordsInCurrentLine, remainingSpacesAfterEqualDistribution);
                }
                addToOutput(wordsInCurrentLine, output);

                wordsInCurrentLine = new ArrayList<>();
                currentLineLength = 0;
            }

            wordsInCurrentLine.add(word);
            currentLineLength = currentLineLength + word.length();
            if (wordArrayLength == words.length - 1) {
                handleLastLine(maxWidth, currentLineLength, wordsInCurrentLine);
                addToOutput(wordsInCurrentLine, output);
            }
            wordArrayLength++;
        }
        return output;
    }

    private static void addToOutput(List<String> wordsInCurrentLine, List<String> output) {
        StringBuilder sb = new StringBuilder();
        for (String justifiedWord : wordsInCurrentLine) {
            sb.append(justifiedWord);
        }
        output.add(sb.toString());
    }

    private void handleLastLine(int maxWidth, int currentLineLength, List<String> wordsInCurrentLine) {
        int totalSpacesInCurrentLine = maxWidth - currentLineLength;
        int spacesInBetween = wordsInCurrentLine.size() - 1;
        insertSingleSpaceBetweenWords(wordsInCurrentLine, spacesInBetween);
        int remainingSpaces = totalSpacesInCurrentLine - spacesInBetween;
        StringBuilder lastWord = new StringBuilder(wordsInCurrentLine.get(wordsInCurrentLine.size() - 1));

        for (int space = 0; space < remainingSpaces; space++) {
            lastWord.append(" ");
        }
        wordsInCurrentLine.set(wordsInCurrentLine.size() - 1, lastWord.toString());
    }

    private void insertSingleSpaceBetweenWords(List<String> wordsInCurrentLine, int remainingSpacesAfterEqualDistribution) {
        for (int i = 0; i < wordsInCurrentLine.size() - 1 && remainingSpacesAfterEqualDistribution > 0; i++, remainingSpacesAfterEqualDistribution--) {
            wordsInCurrentLine.set(i, wordsInCurrentLine.get(i) + " ");
        }
    }

    private void insertSpacesBetweenWords(List<String> wordsInCurrentLine, int numberOfSpacesForEqualDistribution) {
        for (int j = 0; j < wordsInCurrentLine.size() - 1; j++) {
            StringBuilder currWord = new StringBuilder(wordsInCurrentLine.get(j));
            for (int i = 0; i < numberOfSpacesForEqualDistribution; i++) {
                currWord.append(" ");
            }
            wordsInCurrentLine.set(j, currWord.toString());
        }
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        List<String> output = tj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        System.out.println(output);
    }
}
