package hw2_21000699_dangngocquan.exercise003.services.sort;

import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

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
            if (i >= viewCards.getViewCards().length - 1) {
                timer.cancel();
                timer.purge();
            } else {
                if (j == i) {
                    Location l = new Location(viewCards.getLocationX(indexOfMinValue), 10);
                    viewCards.pickUp2(indexOfMinValue, l, 10, period - 20);
                    j++;
                } else if (j >= viewCards.getViewCards().length) {
                    if (indexOfMinValue != i) {
                        Location l11 = new Location(viewCards.getLocationX(i), 10);
                        int delay1 = 10;
                        int duration1 = (period - 40) / 4;

                        Location l12 = new Location(l11.getX(), l11.getY() + viewCards.getViewCards()[i].getHeight() / 4 * 2);
                        Location l22 = new Location(viewCards.getLocationX(indexOfMinValue), l12.getY());
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 2;

//                        Location l13 = new Location(l22.getX(), l22.getY());
//                        Location l23 = new Location(l12.getX(), l12.getY());
                        int delay3 = delay2 + duration2 + 10;
                        int duration3 = (period - 40) / 4;

                        viewCards.pickUp2(i, l11, delay1, duration1);
                        viewCards.swap(i, l12, indexOfMinValue, l22, delay2, duration2);
                        viewCards.pickDown2(i, l12, delay3, duration3);
                        viewCards.pickDown2(indexOfMinValue, l22, delay3, duration3);
                    } else {
                        Location l = new Location(viewCards.getLocationX(i), 10 + viewCards.getViewCards()[i].getHeight() / 4 * 2);
                        viewCards.pickDown2(i, l, 10, period - 20);
                    }
                    i++;
                    j = i;
                    indexOfMinValue = i;
                } else {
                    ViewCard v1 = viewCards.getViewCards()[indexOfMinValue];
                    ViewCard v2 = viewCards.getViewCards()[j];
                    if (v2.compareTo(v1) < 0) {
                        Location l1 = new Location(
                                viewCards.getLocationX(indexOfMinValue),
                                10 + viewCards.getViewCards()[i].getHeight() / 4 * 2);
                        Location l2 = new Location(
                                viewCards.getLocationX(j),
                                10);

                        viewCards.pickDown2(indexOfMinValue, l1, 10, period - 40);
                        viewCards.pickUp2(j, l2, 10, period - 40);
                        indexOfMinValue = j;
                    } else {
                        Location l1 = new Location(viewCards.getLocationX(j), 10);
                        int delay1 = 10;
                        int duration1 = (period - 40) / 2;

                        Location l2 = new Location(l1.getX(), 10 + viewCards.getViewCards()[i].getHeight() / 4);
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 2;

                        viewCards.pickUp1(j, l1, delay1, duration1);
                        viewCards.pickDown1(j, l2, delay2, duration2);
                    }
                    j++;
                }
            }

        }
    }
}
