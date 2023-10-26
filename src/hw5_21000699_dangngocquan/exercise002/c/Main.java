package hw5_21000699_dangngocquan.exercise002.c;

public class Main {
    public static void main(String[] args) {
        new Test().run();
        // Sample

        /*

        INPUT
        Expression string: (6/3+2)*(7-4)
        Expression tree:
              4
           -
              7
        *
              2
           +
                 3
              /
                 6

        OUTPUT:
        12.0
        --------------------------------------------------------------------------------
        INPUT
        Expression string: 1+2*3-1/2*2
        Expression tree:
              2
           *
                 2
              /
                 1
        -
                 3
              *
                 2
           +
              1

        OUTPUT:
        6.0
        --------------------------------------------------------------------------------
        INPUT
        Expression string: (1/2)+0.3
        Expression tree:
             0.3
        +
                  2
             /
                  1

        OUTPUT:
        0.8
        --------------------------------------------------------------------------------
        INPUT
        Expression string: (1/2+0.5+3.2)/2/3
        Expression tree:
             3
        /
                  2
             /
                       3.2
                  +
                            0.5
                       +
                                 2
                            /
                                 1

        OUTPUT:
        0.7000000000000001
        --------------------------------------------------------------------------------
        INPUT
        Expression string: 3/0+2
        Expression tree:
           2
        +
              0
           /
              3

        OUTPUT:
        Divide by zero.
        --------------------------------------------------------------------------------
        INPUT
        Expression string: -1.2+0.3*2
        Expression tree:
                  2
             *
                  0.3
        +
                  1.2
             -
                  0

        OUTPUT:
        -0.6
        --------------------------------------------------------------------------------
        INPUT
        Expression string: -1.2/3
        Expression tree:
                  3
             /
                  1.2
        -
             0

        OUTPUT:
        -0.39999999999999997
        --------------------------------------------------------------------------------
        INPUT
        Expression string: -1.2/3+0.4
        Expression tree:
             0.4
        +
                       3
                  /
                       1.2
             -
                  0

        OUTPUT:
        5.551115123125783E-17
        --------------------------------------------------------------------------------
        INPUT
        Expression string: 1.5*3
        Expression tree:
             3
        *
             1.5

        OUTPUT:
        4.5
        --------------------------------------------------------------------------------
        INPUT
        Expression string: -1.2/3+0.4+1.5*3
        Expression tree:
                  3
             *
                  1.5
        +
                  0.4
             +
                            3
                       /
                            1.2
                  -
                       0

        OUTPUT:
        4.5
        --------------------------------------------------------------------------------*/

    }
}
