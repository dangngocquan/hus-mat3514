package hw2_21000699_dangngocquan.exercise003.services;

import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.models.Card;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Service {
    public static void sortCards(Card[] a) {
        Arrays.sort(a, new CompareCard());
    }

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

    public static int getRandomNumber(int from, int to) {
        int range = to - from;
        int randomNum = (int) (Math.floor(Math.random() * range)) + from;
        return randomNum;
    }

    public static Integer getRandomValueOfList(List<Integer> values) {
        if (values.size() == 0) return null;
        int randomIndex = getRandomNumber(0, values.size());
        int value = values.get(randomIndex);
        return value;
    }

    public static Card[] createCards(int numberCards, int maxRankCard) {
        List<Integer> list = new LinkedList<>();
        int listSize = (maxRankCard + 1) * 4;
        for (int i = 0; i < listSize; i++) list.add(i);

        Card[] cards = new Card[numberCards];
        for (int i = 0; i < numberCards; i++) {
            int randomIndex = getRandomValueOfList(list);
            list.remove(Integer.valueOf(randomIndex));
            cards[i] = new Card(
                    randomIndex/4,
                    randomIndex%4,
                    Config.CARD_RANKS[randomIndex/4],
                    Config.CARD_SUITS[randomIndex%4]
            );
        }
        return cards;
    }

    public static void shuffleCards(ViewCard[] viewCards) {
        for (int i = 0; i < viewCards.length; i++) {
            int j = (int) Math.floor(Math.random() * viewCards.length);
            ViewCard temp = viewCards[i];
            viewCards[i] = viewCards[j];
            viewCards[j] = temp;
        }
    }
}
