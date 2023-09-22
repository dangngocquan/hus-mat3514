package hw2_21000699_dangngocquan.exercise003.services.sort;

import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;

import java.util.Timer;
import java.util.TimerTask;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int indexOfMinValue = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j].compareTo(a[indexOfMinValue]) < 0) {
                    indexOfMinValue = j;
                }
            }
            if (indexOfMinValue != i) {
                T temp = a[indexOfMinValue];
                a[indexOfMinValue] = a[i];
                a[i] = temp;
            }
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
        private int indexOfMinValue;

        public Task(Timer timer, ViewCards viewCards, int period) {
            this.timer = timer;
            this.viewCards = viewCards;
            this.period = period;
            i = 0;
            j = i;
            indexOfMinValue = i;
        }

        @Override
        public void run() {
            System.out.println(i + " " + j);
            if (i >= viewCards.getViewCards().length - 1) {
                viewCards.pickDown1(viewCards.getViewCards().length - 1, 10, period - 20);
                timer.cancel();
                timer.purge();
            } else {
                if (j == i) {
                    int delay1 = 10;
                    int duration1 = (period - 40) / 2;
                    int delay2 = delay1 + duration1 + 10;
                    int duration2 = (period - 40) / 2;
                    if (i == 0) {
                        viewCards.pickUp1All(i, viewCards.getViewCards().length-1, delay1, duration1);
                        viewCards.pickUp2(indexOfMinValue, delay2, duration2);
                    } else {
                        viewCards.pickUp2(indexOfMinValue, delay2, duration2);
                    }
                    j++;
                } else if (j >= viewCards.getViewCards().length) {
                    if (indexOfMinValue != i) {
                        int delay1 = 10;
                        int duration1 = (period - 40) / 4;
                        viewCards.pickUp2(i, delay1, duration1);
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 2;
                        viewCards.swap(i, indexOfMinValue, delay2, duration2);
                        int delay3 = delay2 + duration2 + 10;
                        int duration3 = (period - 40) / 4;
                        viewCards.pickDown3(i, delay3, duration3);
                        viewCards.pickDown2(indexOfMinValue, delay3, duration3);
                    } else {
                        viewCards.pickDown3(i, 10, period - 20);
                    }
                    i++;
                    j = i;
                    indexOfMinValue = i;
                } else {
                    ViewCard v1 = viewCards.getViewCards()[indexOfMinValue];
                    ViewCard v2 = viewCards.getViewCards()[j];
                    if (v2.compareTo(v1) < 0) {
                        viewCards.pickDown2(indexOfMinValue, 10, period - 40);
                        viewCards.pickUp2(j, 10, period - 40);
                        indexOfMinValue = j;
                    } else {
                        int delay1 = 10;
                        int duration1 = (period - 40) / 2;
                        viewCards.pickUp1(j, delay1, duration1);
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 2;
                        viewCards.pickDown1(j, delay2, duration2);
                    }
                    j++;
                }
            }

        }
    }
}
