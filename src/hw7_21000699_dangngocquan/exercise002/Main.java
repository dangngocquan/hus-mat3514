package hw7_21000699_dangngocquan.exercise002;

public class Main {
    public static void main(String[] args) {
        new Test().run();

/*

TEST BINARY SEARCH TREE

Method                    Return          Binary Search Tree
------------------------------------------------------------------------------------------
insert(value=5)           true            5
------------------------------------------------------------------------------------------
insert(value=6)           true               6
                                          5
------------------------------------------------------------------------------------------
insert(value=4)           true               6
                                          5
                                             4
------------------------------------------------------------------------------------------
insert(value=3)           true               6
                                          5
                                             4
                                                3
------------------------------------------------------------------------------------------
findMin()                 3                  6
                                          5
                                             4
                                                3
------------------------------------------------------------------------------------------
search(value=5)           5                  6
                                          5
                                             4
                                                3
------------------------------------------------------------------------------------------
search(value=7)           null               6
                                          5
                                             4
                                                3
------------------------------------------------------------------------------------------
delete(value=6)           5               5
                                             4
                                                3
------------------------------------------------------------------------------------------
insert(value=1)           true            5
                                             4
                                                3
                                                   1
------------------------------------------------------------------------------------------
insert(value=2)           true            5
                                             4
                                                3
                                                      2
                                                   1
------------------------------------------------------------------------------------------
insert(value=7)           true               7
                                          5
                                             4
                                                3
                                                      2
                                                   1
------------------------------------------------------------------------------------------
insert(value=6)           true               7
                                                6
                                          5
                                             4
                                                3
                                                      2
                                                   1
------------------------------------------------------------------------------------------
delete(value=1)           5                  7
                                                6
                                          5
                                             4
                                                3
                                                   2
------------------------------------------------------------------------------------------

TEST SEARCH n = 100000
Sequential search with array: 7.9225ms
Binary search with sorted array: 0.004ms
Search with Binary Search Tree: 0.0718ms

TEST SEARCH n = 1000000
Sequential search with array: 13.4501ms
Binary search with sorted array: 0.0029ms
Search with Binary Search Tree: 0.0136ms

TEST SEARCH n = 10000000
Sequential search with array: 249.869ms
Binary search with sorted array: 0.0049ms
Search with Binary Search Tree: 0.0213ms

TEST SEARCH n = 100000000
Sequential search with array: 1571.4541ms
Binary search with sorted array: 0.0068ms
Search with Binary Search Tree: Out of memory when creating sample

*/
    }
}
