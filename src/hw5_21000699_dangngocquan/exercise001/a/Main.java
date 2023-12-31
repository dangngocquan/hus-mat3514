package hw5_21000699_dangngocquan.exercise001.a;

public class Main {
    public static void main(String[] args) {
       new Test().run();
       // Sample
        /*

        TEST ARRAY BINARY TREE

        Method                    Return          Binary Tree
        ------------------------------------------------------------------------------------------
        root()                    1
        ------------------------------------------------------------------------------------------
        size()                    0
        ------------------------------------------------------------------------------------------
        isEmpty()                 true
        ------------------------------------------------------------------------------------------
        numberChildren(1)         0
        ------------------------------------------------------------------------------------------
        setRoot(A)                                A
        ------------------------------------------------------------------------------------------
        setLeft(1, A0)                            A
                                                      A0
        ------------------------------------------------------------------------------------------
        setRight(1, A1)                               A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        element(1)                A                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        element(2)                A0                  A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        element(3)                A1                  A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        root()                    1                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        size()                    3                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        isEmpty()                 false               A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        numberChildren(1)         2                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        parent(2)                 1                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        parent(3)                 1                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        left(1)                   2                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        right(1)                  3                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        sibling(2)                3                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        sibling(3)                2                   A1
                                                  A
                                                      A0
        ------------------------------------------------------------------------------------------
        setLeft(2, A00)                                A1
                                                  A
                                                       A0
                                                            A00
        ------------------------------------------------------------------------------------------
        setLeft(3, A10)                                A1
                                                            A10
                                                  A
                                                       A0
                                                            A00
        ------------------------------------------------------------------------------------------
        setRight(2, A01)                               A1
                                                            A10
                                                  A
                                                            A01
                                                       A0
                                                            A00
        ------------------------------------------------------------------------------------------
        size()                    6                    A1
                                                            A10
                                                  A
                                                            A01
                                                       A0
                                                            A00
        ------------------------------------------------------------------------------------------
        setLeft(4, A000)                                A1
                                                              A10
                                                  A
                                                              A01
                                                        A0
                                                              A00
                                                                    A000
        ------------------------------------------------------------------------------------------
        size()                    7                     A1
                                                              A10
                                                  A
                                                              A01
                                                        A0
                                                              A00
                                                                    A000
        ------------------------------------------------------------------------------------------
        setLeft(1, null)                               A1
                                                            A10
                                                  A
        ------------------------------------------------------------------------------------------
        size()                    3                    A1
                                                            A10
                                                  A
        ------------------------------------------------------------------------------------------

        */
    }
}
