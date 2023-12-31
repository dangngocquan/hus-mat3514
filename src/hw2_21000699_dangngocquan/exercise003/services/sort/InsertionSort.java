package hw2_21000699_dangngocquan.exercise003.services.sort;

import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

import java.util.Timer;
import java.util.TimerTask;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T valueInsert = a[i];
            int j = i-1;
            while (j >= 0) {
                if (a[j].compareTo(valueInsert) > 0) {
                    a[j+1] = a[j];
                    j--;
                } else {
                    break;
                }
            }
            a[j+1] = valueInsert;
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
            if (i == 0) {
                viewCards.pickUp1All(Config.INITIAL_Y_CARDS, 1, viewCards.getViewCards().length - 1, 10, period - 10);
                i = 1;
            } else {
                if (i >= viewCards.getViewCards().length) {
                    timer.cancel();
                    timer.purge();
                } else {
                    if (j < 0) {
                        Location l = new Location(
                                viewCards.xCards[0], viewCards.y3Card);
                        viewCards.pickDown3(0, l,10, period - 10);
                        i++;
                        j = i;
                    } else if (j == i) {
                        Location l = new Location(
                                viewCards.xCards[i],
                                viewCards.y1Card);
                        viewCards.pickUp2(i, l, 10, period - 10);
                        j--;
                    } else {
                        ViewCard v1 = viewCards.getViewCards()[j];
                        ViewCard v2 = viewCards.getViewCards()[j+1];
                        if (v1.compareTo(v2) > 0) {
                            Location l1 = new Location(
                                    viewCards.xCards[j],
                                    viewCards.y0Card );
                            Location l2 = new Location(
                                    viewCards.xCards[j+1], viewCards.y3Card);
                            viewCards.swap(j, l1, j+1, l2, 10, period - 10);
                            j--;
                        } else {
                            Location l = new Location(
                                    viewCards.xCards[j+1], viewCards.y3Card);
                            viewCards.pickDown3(j+1, l ,10, period - 10);
                            i++;
                            j = i;
                        }
                    }
                }
            }
        }
    }

}
