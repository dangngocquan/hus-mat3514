package hw3_20000550_duongduyhieu.Bai4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCount {
    
    public static void main(String[] args) {
        // Đọc nội dung từ file văn bản
        String text = readTextFromFile("sample.txt");

        // Tách các từ từ văn bản và lưu vào danh sách
        String[] words = text.split("\\s+");
        List<WordCountItem> wordList = new ArrayList<>();

        for (String word : words) {
            // Loại bỏ các ký tự đặc biệt và chuyển thành chữ thường
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                WordCountItem wordItem = new WordCountItem(word);
                if (wordList.contains(wordItem)) {
                    int index = wordList.indexOf(wordItem);
                    WordCountItem existingWordItem = wordList.get(index);
                    existingWordItem.incrementCount();
                } else {
                    wordList.add(wordItem);
                }
            }
        }

        // In ra số lần xuất hiện của các từ
        for (WordCountItem wordItem : wordList) {
            System.out.println(wordItem.getWord() + ": " + wordItem.getCount());
        }
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    // Lớp đại diện cho từ và số lần xuất hiện của nó
    static class WordCountItem {
        private String word;
        private int count;

        public WordCountItem(String word) {
            this.word = word;
            this.count = 1;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        public void incrementCount() {
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordCountItem that = (WordCountItem) o;
            return word.equals(that.word);
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }
}
