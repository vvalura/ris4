package by.bsuir.lr4;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class MessageCollector {
    private static final int MAX_MESSAGES = 5;
    private List<String> messages = new ArrayList<>();

    public boolean collectMessage(String message) {
        messages.add(message);
        return messages.size() >= MAX_MESSAGES;
    }
    public String getMessageWithMaxVowels() {
        String messageWithMaxVowels = null;
        int maxVowels = -1;

        for (String message : messages) {
            int vowelCount = countVowels(message);
            if (vowelCount > maxVowels) {
                maxVowels = vowelCount;
                messageWithMaxVowels = message;
            }
        }

        return messageWithMaxVowels;
    }

    public String getMessageWithMinVowels() {
        String messageWithMinVowels = null;
        int minVowels = Integer.MAX_VALUE;

        for (String message : messages) {
            int vowelCount = countVowels(message);
            if (vowelCount < minVowels) {
                minVowels = vowelCount;
                messageWithMinVowels = message;
            }
        }

        return messageWithMinVowels;
    }

    private int countVowels(String text) {
        int count = 0;
        String vowels = "аеёиоуыэюя";
        for (char c : text.toLowerCase().toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    public void clear(){
        messages.clear();
    }
}