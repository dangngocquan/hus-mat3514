package hw3_22001273_nguyenhoangminh.excercise4;

import hw3_22001273_nguyenhoangminh.excercise3.SimpleLinkedList;

public class WordLinkedList extends SimpleLinkedList<WordCount> {
    // Variables
    SimpleLinkedList<WordCount> resultList;
    String[] strArray;
    WordCount temp;

    public WordLinkedList(String str) {
        strArray = str.toLowerCase().split("[, ?.@]+");
        resultList = new SimpleLinkedList<>();
        for (String s : strArray) {
            temp = new WordCount(s);
            if (resultList.isEmpty()) {
                resultList.add(temp);
                resultList.get(indexOf(temp)).updateCount();
            } else {
                if (!isContain(temp)) {
                    resultList.addBot(temp);
                    resultList.get(indexOf(temp)).updateCount();
                } else {
                    resultList.get(indexOf(temp)).updateCount();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < resultList.size(); ++i) {
            str.append("(");
            str.append(resultList.get(i).getWord());
            str.append(",");
            str.append(resultList.get(i).getCount());
            str.append(") ");
        }
        return str.toString();
    }

    @Override
    public boolean isContain(WordCount wc) {
        return indexOf(wc) != -1;
    }

    @Override
    public int indexOf(WordCount wc) {
        for (int i = 0; i < resultList.size(); ++i) {
            if (wc.equals(resultList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public String[][] toTable() {
        String[][] statTable = new String[resultList.size()][2];
        // fill words column
        for (int i = 0; i < statTable.length; ++i) {
            statTable[i][0] = resultList.get(i).getWord();
        }
        // fill frequency column
        for (int i = 0; i < statTable.length; ++i) {
            statTable[i][1] = Integer.toString(resultList.get(i).getCount());
        }
        return statTable;
    }

}