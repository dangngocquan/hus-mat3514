package hw7_21000699_dangngocquan.exercise003;

public class Main {
    public static void main(String[] args) {
        new Test().run();

/*

TEST AVL BINARY SEARCH TREE

Method                    Return          Binary Search Tree
------------------------------------------------------------------------------------------
insert(value=10)          true            10
------------------------------------------------------------------------------------------
insert(value=5)           true            10
                                              5
------------------------------------------------------------------------------------------
insert(value=2)           true                10
                                          5
                                              2
------------------------------------------------------------------------------------------
insert(value=1)           true                10
                                          5
                                              2
                                                  1
------------------------------------------------------------------------------------------
insert(value=3)           true                10
                                          5
                                                  3
                                              2
                                                  1
------------------------------------------------------------------------------------------
insert(value=4)           true                    10
                                              5
                                                  4
                                          3
                                              2
                                                  1
------------------------------------------------------------------------------------------
insert(value=15)          true                        15
                                                  10
                                              5
                                                  4
                                          3
                                              2
                                                  1
------------------------------------------------------------------------------------------
insert(value=20)          true                        20
                                                  15
                                              10
                                          5
                                                  4
                                              3
                                                  2
                                                      1
------------------------------------------------------------------------------------------
insert(value=19)          true                    20
                                                      19
                                              15
                                                  10
                                          5
                                                  4
                                              3
                                                  2
                                                      1
------------------------------------------------------------------------------------------
insert(value=18)          true                    20
                                              19
                                                      18
                                                  15
                                                      10
                                          5
                                                  4
                                              3
                                                  2
                                                      1
------------------------------------------------------------------------------------------
insert(value=17)          true                        20
                                                  19
                                              18
                                                      17
                                                  15
                                                      10
                                          5
                                                  4
                                              3
                                                  2
                                                      1
------------------------------------------------------------------------------------------

*/
    }
}
