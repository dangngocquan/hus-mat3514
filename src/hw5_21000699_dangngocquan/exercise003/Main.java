package hw5_21000699_dangngocquan.exercise003;

public class Main {
    public static void main(String[] args) {
        new Test().run();
/*

Solution using        Input (Array tokens)                                                              Output (Expression tree)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, 6, /, 3, +, 2, ), *, (, 7, -, 4]
                                                                                                              4

                                                                                                           -

                                                                                                              7

                                                                                                        *

                                                                                                              2

                                                                                                           +
                                                                                                                 3
                                                                                                              /
                                                                                                                 6
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, 6, /, 3, +, 2, ), *, (, 7, -, 4]
                                                                                                              4

                                                                                                           -

                                                                                                              7

                                                                                                        *

                                                                                                              2

                                                                                                           +
                                                                                                                 3
                                                                                                              /
                                                                                                                 6
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, 5, +, 3, ), *, 2]
                                                                                                           2

                                                                                                        *
                                                                                                              3
                                                                                                           +
                                                                                                              5
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, 5, +, 3, ), *, 2]
                                                                                                           2

                                                                                                        *
                                                                                                              3
                                                                                                           +
                                                                                                              5
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, (, 5, +, 3, ), *, 2, ), /, (, 1, +, 3, )]
                                                                                                              3

                                                                                                           +

                                                                                                              1

                                                                                                        /

                                                                                                              2

                                                                                                           *
                                                                                                                 3
                                                                                                              +
                                                                                                                 5
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, (, 5, +, 3, ), *, 2, ), /, (, 1, +, 3, )]
                                                                                                              3

                                                                                                           +

                                                                                                              1

                                                                                                        /

                                                                                                              2

                                                                                                           *
                                                                                                                 3
                                                                                                              +
                                                                                                                 5
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, (, (, 2, *, 3, ), +, 4, ), *, (, 3, -, (, 1, +, 2, ), ), )]                            2
                                                                                                              +
                                                                                                                 1
                                                                                                           -

                                                                                                              3

                                                                                                        *

                                                                                                              4

                                                                                                           +
                                                                                                                 3
                                                                                                              *
                                                                                                                 2
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, (, (, 2, *, 3, ), +, 4, ), *, (, 3, -, (, 1, +, 2, ), ), )]                            2
                                                                                                              +
                                                                                                                 1
                                                                                                           -

                                                                                                              3

                                                                                                        *

                                                                                                              4

                                                                                                           +
                                                                                                                 3
                                                                                                              *
                                                                                                                 2
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, )]                                                                            Array tokens input is invalid. Blank brackets: "()".
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, )]                                                                            Array tokens input is invalid.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [10, 4]                                                                           Array tokens input is invalid. Token 10 and token 4 are missing operation.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [10, 4]                                                                           Array tokens input is invalid.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [10, +, 4, 18]                                                                    Array tokens input is invalid. Expression (10 + 4) and token 18 are missing operation.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [10, +, 4, 18]                                                                    Array tokens input is invalid.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [*, 4]                                                                            Array tokens input is invalid. Missing left expression of token *.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [*, 4]                                                                            Array tokens input is invalid. Missing right expression of token *.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [10, *, -]                                                                        Array tokens input is invalid. Missing expression between token * and token -.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [10, *, -]                                                                        Array tokens input is invalid. Missing right expression of token *.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [10, +, 4, )]                                                                     Array tokens input is invalid. Unpaired token: ')'.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [10, +, 4, )]                                                                     Array tokens input is invalid. Unpaired token: ')'.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, 104, )]                                                                       104
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, 104, )]                                                                       104
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, -, 104, )]                                                                         104
                                                                                                        -
                                                                                                             0
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, -, 104, )]                                                                         104
                                                                                                        -
                                                                                                             0
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [-, 104]                                                                               104
                                                                                                        -
                                                                                                             0
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [-, 104]                                                                               104
                                                                                                        -
                                                                                                             0
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 1            [(, -, 104, ), (, 1812, +, 12, (, 18, )]                                                            18
                                                                                                                    *
                                                                                                                          12
                                                                                                              +

                                                                                                                    1812

                                                                                                        *

                                                                                                                    104

                                                                                                              -

                                                                                                                    0

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Solution 2            [(, -, 104, ), (, 1812, +, 12, (, 18, )]                                                            18
                                                                                                                    *
                                                                                                                          12
                                                                                                              +

                                                                                                                    1812

                                                                                                        *

                                                                                                                    104

                                                                                                              -

                                                                                                                    0

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/
    }
}