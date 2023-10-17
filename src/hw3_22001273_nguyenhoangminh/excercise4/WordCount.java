package hw3_22001273_nguyenhoangminh.excercise4;

public class WordCount {
    // Variables
    String word;
    int count = 0;

    public WordCount(String word) {
        this.word = word;
    }

    public String getWord() { return word; }

    public int getCount() { return count; }

    public void updateCount() { count++; }

    public boolean equals(WordCount wc) {
        return this.word.equals(wc.word);
    }

}
