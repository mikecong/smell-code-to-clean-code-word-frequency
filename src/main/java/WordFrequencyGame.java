import java.util.*;


public class WordFrequencyGame {
    public String getResult(String inputStr) {
                List<Input> inputList = initWordList(inputStr);
                inputList = countWordFrequency(inputList);
                sortWordFrequencyDesc(inputList);
                String formatWordList = formatWordList(inputList);
                return formatWordList;
    }

    private String formatWordList(List<Input> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private void sortWordFrequencyDesc(List<Input> inputList) {
        inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private List<Input> countWordFrequency(List<Input> inputList) {
        Map<String, List<Input>> map1 = new HashMap<>();
        for (Input input1 : inputList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map1.containsKey(input1.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input1);
                map1.put(input1.getValue(), arr);
            } else {
                map1.get(input1.getValue()).add(input1);
            }
        }
        Map<String, List<Input>> map = map1;

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        inputList = list;
        return inputList;
    }

    private List<Input> initWordList(String inputStr) {
        String[] arr = inputStr.split("\\s+");

        List<Input> inputList = new ArrayList<>();
        for (String s : arr) {
            Input input = new Input(s, 1);
            inputList.add(input);
        }
        return inputList;
    }

}
