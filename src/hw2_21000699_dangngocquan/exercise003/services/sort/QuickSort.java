package hw2_21000699_dangngocquan.exercise003.services.sort;

import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        quickSort(a, 0, a.length-1);
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(a, left, right);
            quickSort(a, left, pivotIndex-1);
            quickSort(a, pivotIndex+1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        T pivotValue = a[left];
        int pivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i].compareTo(pivotValue) < 0) {
                pivotIndex++;
                T temp = a[i];
                a[i] = a[pivotIndex];
                a[pivotIndex] = temp;
            }
        }
        T temp = a[left];
        a[left] = a[pivotIndex];
        a[pivotIndex] = temp;

        return pivotIndex;
    }


    public static void sortWithAnimation(Timer timer, ViewCards viewCards, int period) {
        timer.schedule(new
                Task(timer, viewCards, period), 0, period);
    }

    private static class Task extends TimerTask {
        private Timer timer;
        private ViewCards viewCards;
        private int period;
        private int left;
        private int right;
        private int i;
        private ViewCard tempPivotValue;
        private int tempPivotIndex;
        private Stack<Integer> lefts;
        private Stack<Integer> rights;


        public Task(Timer timer, ViewCards viewCards, int period) {
            this.timer = timer;
            this.viewCards = viewCards;
            this.period = period;
            i = 0;
            lefts = new Stack<>();
            rights = new Stack<>();
            left = 0;
            right = viewCards.getViewCards().length-1;
        }

        @Override
        public void run() {
            if (left < right) {
                if (i == left) {
                    int delay1 = 10;
                    int duration1 = (period - 40) / 2;
                    int delay2 = delay1 + duration1 + 10;
                    int duration2 = (period - 40) / 2;

                    viewCards.pickUp1All(left, right, delay1, duration1);

                    tempPivotValue = viewCards.getViewCards()[i];
                    tempPivotIndex = i;
                    Location l = new Location(viewCards.getLocationX(i), 10 + tempPivotValue.getHeight() / 4);
                    viewCards.pickUp2(i, l, delay2, duration2);
                    i++;
                } else if (i <= right) {
                    ViewCard v1 = viewCards.getViewCards()[i];
                    if (v1.compareTo(tempPivotValue) < 0) {
                        tempPivotIndex++;
                        int delay1 = 10;
                        int duration1 = (period - 40) / 2;
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 4;
                        int delay3 = delay2 + duration2 + 10;
                        int duration3 = (period - 40) / 4;

                        Location l11 = new Location(
                                viewCards.getLocationX(tempPivotIndex),
                                10 + tempPivotValue.getHeight() / 4);
                        Location l21 = new Location(
                                viewCards.getLocationX(i),
                                10 + tempPivotValue.getHeight() / 4 );

                        viewCards.pickUp1(tempPivotIndex, l11, delay1, duration1);
                        viewCards.pickUp1(i, l21, delay1, duration1);

                        Location l12 = new Location(
                                viewCards.getLocationX(tempPivotIndex),
                                10 + tempPivotValue.getHeight() / 4 * 2);
                        Location l22 = new Location(
                                viewCards.getLocationX(i),
                                10 + tempPivotValue.getHeight() / 4 * 2);
                        viewCards.swap(tempPivotIndex, l12, i, l22, delay2, duration2);

                        viewCards.pickDown1(tempPivotIndex, l12, delay3, duration3);
                        viewCards.pickDown1(i, l22, delay3, duration3);

                    } else {
                        Location l1 = new Location(viewCards.getLocationX(i), 10 + tempPivotValue.getHeight() / 4);
                        int delay1 = 10;
                        int duration1 = (period - 40) / 2;

                        Location l2 = new Location(l1.getX(), 10 + viewCards.getViewCards()[i].getHeight() / 4 * 2);
                        int delay2 = delay1 + duration1 + 10;
                        int duration2 = (period - 40) / 2;

                        viewCards.pickUp1(i, l1, delay1, duration1);
                        viewCards.pickDown1(i, l2, delay2, duration2);
                    }
                    i++;
                } else if (i == right + 1){
                    int delay1 = 10;
                    int duration1 = (period - 40) / 2;
                    int delay2 = delay1 + duration1 + 10;
                    int duration2 = (period - 40) / 2;

                    if (left != tempPivotIndex) {
                        Location l1 = new Location(
                                viewCards.getLocationX(left),
                                10 + viewCards.getViewCards()[left].getHeight() / 4 * 3);
                        Location l2 = new Location(
                                viewCards.getLocationX(tempPivotIndex),
                                10 + tempPivotValue.getHeight() / 4);
                        viewCards.swap(left, l1, tempPivotIndex, l2, delay1, duration1);
                        viewCards.pickDown2(
                                tempPivotIndex, new Location(l2.getX(), l1.getY()),
                                delay2, duration2);
                    } else {
                        viewCards.pickDown2(
                                tempPivotIndex,
                                new Location(
                                        viewCards.getLocationX(tempPivotIndex),
                                        10 + viewCards.getViewCards()[tempPivotIndex].getHeight() / 4 * 3
                                ),
                                10, duration1 + duration2);
                    }
                    i++;
                } else {
                    viewCards.pickDown1All(left, right, 10, period - 20);
                    lefts.add(tempPivotIndex+1);
                    rights.add(right);
                    lefts.add(left);
                    rights.add(tempPivotIndex-1);
                    left = lefts.pop();
                    right = rights.pop();
                    i = left;
                }
            } else {
                if (lefts.isEmpty()) {
                    timer.cancel();
                    timer.purge();
                } else {
                    left = lefts.pop();
                    right = rights.pop();
                    i = left;
                }
            }
        }
    }
}
