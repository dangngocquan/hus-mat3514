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
        private int animationStep;


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
                    if (animationStep == 0) {
                        viewCards.pickUp1All(viewCards.y0Card, left, right, 10, period - 10);
                        animationStep++;
                    } else if (animationStep == 1) {
                        tempPivotValue = viewCards.getViewCards()[i];
                        tempPivotIndex = i;
                        Location l = new Location(viewCards.xCards[i], viewCards.y1Card);
                        viewCards.pickUp2(i, l, 10, period - 10);
                        i++;
                        animationStep = 0;
                    }
                } else if (i <= right) {
                    ViewCard v1 = viewCards.getViewCards()[i];
                    if (animationStep == 2) {
                        v1 = viewCards.getViewCards()[tempPivotIndex];
                    }
                    if (v1.compareTo(tempPivotValue) < 0) {
                        if (animationStep == 0) {
                            tempPivotIndex++;
                            Location l11 = new Location(
                                    viewCards.xCards[tempPivotIndex],
                                    viewCards.y1Card);
                            Location l21 = new Location(
                                    viewCards.xCards[i],
                                    viewCards.y1Card);
                            viewCards.pickUp1(tempPivotIndex, l11, 10, period - 10);
                            viewCards.pickUp1(i, l21, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l12 = new Location(
                                    viewCards.xCards[tempPivotIndex],
                                    viewCards.y2Card);
                            Location l22 = new Location(
                                    viewCards.xCards[i],
                                    viewCards.y2Card);
                            viewCards.swap(tempPivotIndex, l12, i, l22, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 2) {
                            Location l12 = new Location(
                                    viewCards.xCards[tempPivotIndex],
                                    viewCards.y2Card);
                            Location l22 = new Location(
                                    viewCards.xCards[i],
                                    viewCards.y2Card);
                            viewCards.pickDown1(tempPivotIndex, l12, 10, period - 10);
                            viewCards.pickDown1(i, l22, 10, period - 10);
                            i++;
                            animationStep = 0;
                        }
                    } else {
                        if (animationStep == 0) {
                            Location l1 = new Location(viewCards.xCards[i], viewCards.y1Card);
                            viewCards.pickUp1(i, l1, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l2 = new Location(viewCards.xCards[i], viewCards.y2Card);
                            viewCards.pickDown1(i, l2, 10, period - 10);
                            i++;
                            animationStep = 0;
                        }
                    }
                } else if (i == right + 1){
                    if (left != tempPivotIndex) {
                        if (animationStep == 0) {
                            Location l1 = new Location(
                                    viewCards.xCards[left],
                                    viewCards.y3Card);
                            Location l2 = new Location(
                                    viewCards.xCards[tempPivotIndex],
                                    viewCards.y1Card);
                            viewCards.swap(left, l1, tempPivotIndex, l2, 10, period - 10);
                            animationStep++;
                        } else if (animationStep == 1) {
                            Location l = new Location(
                                    viewCards.xCards[tempPivotIndex],
                                    viewCards.y3Card);
                            viewCards.pickDown2(
                                    tempPivotIndex, l,
                                    10, period - 10);
                            i++;
                            animationStep = 0;
                        }
                    } else {
                        viewCards.pickDown2(
                                tempPivotIndex,
                                new Location(
                                        viewCards.xCards[tempPivotIndex],
                                        viewCards.y3Card
                                ),
                                10, period - 10);
                        i++;
                    }
                } else {
                    viewCards.pickDown1All(viewCards.y1Card, left, right, 10, period - 10);
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
