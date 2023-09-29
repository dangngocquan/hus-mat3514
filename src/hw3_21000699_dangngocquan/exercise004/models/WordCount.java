package hw3_21000699_dangngocquan.exercise004.models;

public class WordCount implements Comparable<WordCount> {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        return word.equals(((WordCount) o).getWord());
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(WordCount o) {
        if (count == o.getCount()) {
            return word.compareTo(o.getWord());
        }
        return o.getCount() - count;
    }
}
