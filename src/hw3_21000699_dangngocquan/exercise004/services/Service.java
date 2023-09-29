package hw3_21000699_dangngocquan.exercise004.services;

import hw3_21000699_dangngocquan.exercise004.models.MyArrayList;
import hw3_21000699_dangngocquan.exercise004.models.MyList;
import hw3_21000699_dangngocquan.exercise004.models.WordCount;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Service {
    public static JFrame getFrame(Component theComponent) {
        Component currParent = theComponent;
        JFrame theFrame = null;
        while (currParent != null) {
            if (currParent instanceof JFrame) {
                theFrame = (JFrame) currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return theFrame;
    }

    public static MyList<WordCount> getListWord(String document) {
        String[] words = document.split("[\s.,]+");
        MyList<WordCount> listWord = new MyArrayList<>();
        if (document.isBlank()) return listWord;
        for (String word : words) {
            WordCount wordCount = new WordCount(word.toLowerCase(), 1);
            int index = listWord.indexOf(wordCount);
            if (index == -1) {
                listWord.add(wordCount);
            } else {
                WordCount wordCount0 = listWord.get(index);
                wordCount0.setCount(wordCount0.getCount() + 1);
            }
        }
        return listWord;
    }

    public static <T extends Comparable<T>> void sortList(MyList<T> list) {
        T[] dataNodes = (T[]) (new Comparable[list.size()]);
        Iterator<T> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            dataNodes[index++] = iterator.next();
        }
        MergeSort.sort(dataNodes);
        index = 0;
        while (index < dataNodes.length) {
            list.set(index, dataNodes[index]);
            index++;
        }
    }
}
