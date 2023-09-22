package hw2_21000699_dangngocquan.exercise003.services.sort;


import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;

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
                    viewCards.pickUp1(j-1, 10, (period - 40) / 2);
                    viewCards.pickUp1(j, 10, (period - 40) / 2);
                    viewCards.pickDown1(j-1, (period - 40) / 2 + 10, (period - 40) / 2);
                    viewCards.pickDown1(j, (period - 40) / 2 + 10, (period - 40) / 2);
                }
                j++;
            }
        }
    }
}
