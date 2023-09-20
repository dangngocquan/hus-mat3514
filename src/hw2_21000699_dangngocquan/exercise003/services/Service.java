package hw2_21000699_dangngocquan.exercise003.services;

import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.models.Card;
import hw2_21000699_dangngocquan.exercise003.services.animation.Animation;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

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

    public static Card[] createCards() {
        Card[] cards = new Card[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = new Card(
                    i/4,
                    i%4,
                    Config.CARD_RANKS[i/4],
                    Config.CARD_SUITS[i%4]
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

    public static void swapViewCards(ViewCard[] viewCards, int i1, int i2, double dx) {
        ViewCard viewCard1 = viewCards[i1];
        ViewCard viewCard2 = viewCards[i2];
        viewCards[i1] = viewCard2;
        viewCards[i2] = viewCard1;

        double speed = 2;
        int delay1 = (int) (1000 / speed);
        int duration1 = (int) (500 / speed);
        int delay2 = delay1 + duration1;
        int duration2 = (int) (500/speed);
        int delay3 = delay2 + duration2;
        int duration3 = (int)(500/speed);

        Animation.translate(
                viewCard1,
                0,
                viewCard1.getHeight() + 10,
                delay1, duration1, viewCards.length - 1 - i1);
        Animation.translate(
                viewCard1,
                (int) (dx * (i2 - i1)),
                0,
                delay2, duration2, viewCards.length - 1 - i2);
        Animation.translate(
                viewCard1,
                0,
                - viewCard1.getHeight() - 10,
                delay3, duration3, viewCards.length - 1 - i2);

        Animation.translate(
                viewCard2,
                0,
                viewCard2.getHeight() + 10,
                delay1, duration1, viewCards.length-1-i2);
        Animation.translate(
                viewCard2,
                (int) (dx * (i1 - i2)),
                0,
                delay2, duration2, viewCards.length-1-i1);
        Animation.translate(
                viewCard2,
                0,
                - viewCard2.getHeight() - 10,
                delay3, duration3, viewCards.length-1-i1);

    }
}
