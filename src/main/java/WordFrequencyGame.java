import java.util.*;
import java.util.stream.Collectors;


public class WordFrequencyGame {

    public String getResult(String inputStr) {
        List<Word> wordList = initWordList(inputStr);

        List countedFrequencyWordList = countWordFrequency(wordList);

        sortWordFrequencyDesc(countedFrequencyWordList);

        String formatWordList = formatWordList(wordList);

        return formatWordList;
    }

    private String formatWordList(List<Word> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Word word : inputList) {
            joiner.add(word.formatDesc());
        }
        return joiner.toString();
    }

    private void sortWordFrequencyDesc(List<Word> wordList) {
        wordList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());
    }

    private List<Word> countWordFrequency(List<Word> wordList) {
        return wordList.stream()
                .collect(Collectors.groupingBy(Word::getValue))
                .entrySet().stream().map(entry -> new Word(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
    }

    private List<Word> initWordList(String inputStr) {
        String[] wordValueArr = inputStr.split("\\s+");
        List<Word> wordList = Arrays.stream(wordValueArr).map(wordValue -> new Word(wordValue, 1)).collect(Collectors.toList());
        return wordList;
    }

}
