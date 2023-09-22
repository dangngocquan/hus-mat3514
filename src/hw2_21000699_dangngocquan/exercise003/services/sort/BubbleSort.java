package hw2_21000699_dangngocquan.exercise003.services.sort;


import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

import java.util.Timer;
import java.util.TimerTask;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length-1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < a.length-i; j++) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    isSorted = false;
                    T temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            if (isSorted) break;
        }
    }

    public static void sortWithAnimation(Timer timer, ViewCards viewCards, int period) {
        timer.schedule(new Task(timer, viewCards, period), 0, period);
    }

    private static class Task extends TimerTask {
        private Timer timer;
        private ViewCards viewCards;
        private int period;
        private int i;
        private int j;

        public Task(Timer timer, ViewCards viewCards, int period) {
            this.timer = timer;
            this.viewCards = viewCards;
            this.period = period;
            i = 0;
            j = 1;
        }

        @Override
        public void run() {
            if (j >= viewCards.getViewCards().length - i) {
                j = 1;
                i++;
            }
            if (i >= viewCards.getViewCards().length-1) {
                timer.cancel();
                timer.purge();
            } else {
                ViewCard v1 = viewCards.getViewCards()[j-1];
                ViewCard v2 = viewCards.getViewCards()[j];
                if (v1.compareTo(v2) > 0) {
                    viewCards.pickAndSwapCards(j-1, j, 10,  period - 20);
                } else {
                    int delay1 = 10;
                    int duration1 = (period - 40) / 2;
                    Location l11 = new Location(viewCards.getLocationX(j-1), 10);
                    Location l21 = new Location(viewCards.getLocationX(j), 10);

                    int delay2 = delay1 + duration1 + 10;
                    int duration2 = (period - 40) / 2;
                    Location l12 = new Location(l11.getX(), l11.getY() + v1.getHeight() / 4);
                    Location l22 = new Location(l21.getX(), l21.getY() + v2.getHeight() / 4);

                    viewCards.pickUp1(j-1, l11, delay1, duration1);
                    viewCards.pickUp1(j, l21, delay1, duration1);

                    viewCards.pickDown1(j-1, l12, delay2, duration2);
                    viewCards.pickDown1(j, l22, delay2, duration2);
                }
                j++;
            }
        }
    }
}
