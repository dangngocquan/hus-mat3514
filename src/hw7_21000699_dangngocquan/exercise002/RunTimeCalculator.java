package hw7_21000699_dangngocquan.exercise002;

import hw7_21000699_dangngocquan.exercise001.Generator;

public class RunTimeCalculator {
    public double sequentialSearchWithArray(int n, Integer x) {
        Integer[] data = new Generator().randomUniqueArray(n);
        long start = System.nanoTime();
        for (Integer e : data) {
            if (x.compareTo(e) == 0) break;
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    public double binarySearchWithSortedArray(int n, Integer x) {
        Integer[] sortedData = new Integer[n];
        for (int i = 0; i < n; i++) sortedData[i] = i;
        long start = System.nanoTime();
        int l = 0;
        int r = sortedData.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int compare = x.compareTo(sortedData[m]);
            if (compare == 0) break;
            if (compare < 0) r = m - 1;
            if (compare > 0) l = m + 1;
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    public double searchInBinarySearchTree(int n, Integer x) {
        BinarySearchTree<Integer> tree = new Generator().createUniqueBinarySearchTree(n);
        long start = System.nanoTime();
        tree.search(x);
        return (System.nanoTime() - start) / 1000000.0;
    }
}
