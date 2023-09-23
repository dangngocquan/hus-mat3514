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
        private int animationStep = 0;

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
                    if (animationStep == 0) {
                        Location l1 = new Location(viewCards.xCards[j-1], viewCards.y0Card);
                        Location l2 = new Location(viewCards.xCards[j], viewCards.y0Card);
                        viewCards.pickUp5(j-1, l1, 10, period - 10);
                        viewCards.pickUp5(j, l2, 10, period - 10);
                        animationStep++;
                    } else if (animationStep == 1) {
                        Location l1 = new Location(viewCards.xCards[j-1], viewCards.y5Card);
                        Location l2 = new Location(viewCards.xCards[j], viewCards.y5Card);
                        viewCards.swap(j-1, l1, j, l2, 10, period - 10);
                        animationStep++;
                    }
                } else {
                    if (animationStep == 2) {
                        Location l1 = new Location(viewCards.xCards[j-1], viewCards.y5Card);
                        Location l2 = new Location(viewCards.xCards[j], viewCards.y5Card);
                        viewCards.pickDown5(j-1, l1, 10, period - 10);
                        viewCards.pickDown5(j, l2, 10, period - 10);
                        animationStep = 0;
                        j++;
                    } else {
                        if (animationStep == 0) {
                            Location l11 = new Location(viewCards.xCards[j-1], viewCards.y0Card);
                            Location l21 = new Location(viewCards.xCards[j], viewCards.y0Card);
                            viewCards.pickUp1(j-1, l11, 10, period - 10);
                            viewCards.pickUp1(j, l21, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l12 = new Location(viewCards.xCards[j-1], viewCards.y1Card);
                            Location l22 = new Location(viewCards.xCards[j], viewCards.y1Card);
                            viewCards.pickDown1(j-1, l12, 10, period - 10);
                            viewCards.pickDown1(j, l22, 10, period - 10);
                            animationStep = 0;
                            j++;
                        }
                    }
                }
            }
        }
    }
}
