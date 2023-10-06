package hw4_21000699_dangngocquan.exercise003;

public class Main {
    public static void main(String[] args) {
        new Test().run();

        // Sample

        /*
        TEST VALID BRACKETS
            Expression                               Result
            ------------------------------------------------------------------
            (a-b)*(c+d)                              Valid
            (10+8)/((5-2)*17)                        Valid
            (a+b)*c-d)                               Invalid
            (10-8/((2+5)*17)                         Invalid
            )u-v)*(m+n)                              Invalid
            (1+((2+3)*(8*5)))                        Valid
            (5-(8-4)*(2+3))+(8/4)                    Valid

        TEST VALID EXPRESSIONS
            Expression                               Result
            ------------------------------------------------------------------
            (1+((2+3)*(8*5)))                        Valid
            (5-(8-4)*(2+3))+(8/4)                    Valid
            -1+2*3+4/4                               Valid
            1+2+3(2+1)                               Invalid
            1+2++3                                   Invalid
            1+(2+3+)                                 Invalid
            1+()+2                                   Invalid
            1+(*2+3)                                 Invalid
            1*(2+3)(4+5)                             Invalid
            1+(2+3)4                                 Invalid

        TEST CALCULATE EXPRESSIONS
            Expression                               Infix and Postfix                             Result
            ----------------------------------------------------------------------------------------------------------------
            (1+((2+3)*(8*5)))                        ( 1 + ( ( 2 + 3 ) * ( 8 * 5 ) ) )             201
            .                                        1 2 3 + 8 5 * * +                             .
            (5-(8-4)*(2+3))+(8/4)                    ( 5 - ( 8 - 4 ) * ( 2 + 3 ) ) + ( 8 / 4 )     -13
            .                                        5 8 4 - 2 3 + * - 8 4 / +                     .
            1+2*3-4                                  1 + 2 * 3 - 4                                 3
            .                                        1 2 3 * + 4 -                                 .
            1+2*3*(-2+5)                             1 + 2 * 3 * ( 0 - 2 + 5 )                     19
            .                                        1 2 3 * 0 2 - 5 + * +                         .
            1+2/(1-1)                                1 + 2 / ( 1 - 1 )                             Divide by zero
            .                                        1 2 1 1 - / +                                 .
            -3*2                                     0 - 3 * 2                                     -6
            .                                        0 3 2 * -                                     .
            -12+3*(-2)                               0 - 12 + 3 * ( 0 - 2 )                        -18
            .                                        0 12 - 3 0 2 - * +                            .
            1+()+2                                   Invalid                                       Invalid
            .                                        Invalid                                       .
        */
    }


}
