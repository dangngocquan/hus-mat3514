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
            j = i+1;
            indexOfMinValue = i;
            if (i < viewCards.getViewCards().length) {
                viewCards.pickUp5(i, 0, (period - 40) / 4);
            }
        }

        @Override
        public void run() {
            if (j >= viewCards.getViewCards().length) {
                if (indexOfMinValue != i) {
                    int delay1 = 0;
                    int duration1 = (period - 40) / 4;
                    viewCards.pickUp3(indexOfMinValue, delay1, duration1);
                    int delay2 = delay1 + duration1 + 10;
                    int duration2 = (period - 40) / 4;
                    viewCards.swap(i, indexOfMinValue, delay2, duration2);
                    int delay3 = delay2 + duration2 + 10;
                    int duration3 = (period - 40) / 4;
                    viewCards.pickDown5(i, delay3, duration3);
                    viewCards.pickDown5(indexOfMinValue, delay3, duration3);
                } else {
                    viewCards.pickDown5(i, 0, (period - 40) / 4 * 3);
                }
                i++;
                indexOfMinValue = i;
                j = i+1;
                if (i < viewCards.getViewCards().length - 1) {
                    viewCards.pickUp5(i, (period - 40) / 4 * 3 + 10, (period - 40) / 4);
                } else {
                    timer.cancel();
                    timer.purge();
                }
            } else {
                if (i >= viewCards.getViewCards().length-1) {
                    timer.cancel();
                    timer.purge();
                } else {
                    ViewCard v1 = viewCards.getViewCards()[indexOfMinValue];
                    ViewCard v2 = viewCards.getViewCards()[j];
                    if (v2.compareTo(v1) < 0) {
                        if (indexOfMinValue == i) {
                            viewCards.pickUp2(j, 0, (period - 40) / 2);
                        } else {
                            viewCards.pickUp2(j, 0, (period - 40) / 2);
                            viewCards.pickDown2(indexOfMinValue, 0, (period - 40) / 2);
                        }
                        indexOfMinValue = j;
                    } else {
                        viewCards.pickUp1(j, 0, (period - 40) / 2);
                        viewCards.pickDown1(j, (period - 20) / 2, (period - 40) / 2);
                    }
                    j++;
                }
            }

        }
    }
}
