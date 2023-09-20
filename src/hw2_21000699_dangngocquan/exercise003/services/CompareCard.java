package hw2_21000699_dangngocquan.exercise003.services;

import hw2_21000699_dangngocquan.exercise003.models.Card;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getRank() * 4 + o1.getSuit() - o2.getRank() * 4 - o2.getSuit();
    }
}
