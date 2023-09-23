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
        private int animationStep;

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
                    Location l = new Location(viewCards.xCards[indexOfMinValue], viewCards.y0Card);
                    viewCards.pickUp2(indexOfMinValue, l, 10, period - 10);
                    j++;
                } else if (j >= viewCards.getViewCards().length) {
                    if (indexOfMinValue != i) {
                        if (animationStep == 0) {
                            Location l1 = new Location(viewCards.xCards[i], viewCards.y2Card);
                            Location l2 = new Location(viewCards.xCards[indexOfMinValue], viewCards.y2Card);
                            viewCards.swap(i, l1, indexOfMinValue, l2, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l1 = new Location(viewCards.xCards[i], viewCards.y2Card);
                            Location l2 = new Location(viewCards.xCards[indexOfMinValue], viewCards.y2Card);
                            viewCards.pickDown2(i, l1, 10, period - 10);
                            viewCards.pickDown2(indexOfMinValue, l2, 10, period - 10);
                            animationStep = 0;
                            i++;
                            j = i;
                            indexOfMinValue = i;
                        }
                    } else {
                        Location l = new Location(viewCards.xCards[i], viewCards.y2Card);
                        viewCards.pickDown2(i, l, 10, period - 10);
                        i++;
                        j = i;
                        indexOfMinValue = i;
                    }
                } else {
                    ViewCard v1 = viewCards.getViewCards()[indexOfMinValue];
                    ViewCard v2 = viewCards.getViewCards()[j];
                    if (v2.compareTo(v1) < 0) {
                        if (indexOfMinValue != i) {
                            Location l1 = new Location(
                                    viewCards.xCards[indexOfMinValue], viewCards.y2Card);
                            Location l2 = new Location(
                                    viewCards.xCards[j], viewCards.y0Card);

                            viewCards.pickDown2(indexOfMinValue, l1, 10, period - 10);
                            viewCards.pickUp2(j, l2, 10, period - 10);
                            indexOfMinValue = j;
                            j++;
                        } else {
                            Location l2 = new Location(
                                    viewCards.xCards[j], viewCards.y0Card);
                            viewCards.pickUp2(j, l2, 10, period - 10);
                            indexOfMinValue = j;
                            j++;
                        }
                    } else {
                        if (animationStep == 0) {
                            Location l1 = new Location(viewCards.xCards[j], viewCards.y0Card);
                            viewCards.pickUp1(j, l1, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l2 = new Location(viewCards.xCards[j], viewCards.y1Card);
                            viewCards.pickDown1(j, l2, 10, period - 10);
                            animationStep = 0;
                            j++;
                        }
                    }
                }
            }

        }
    }
}
