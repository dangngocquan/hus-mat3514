package hw5_21000699_dangngocquan.exercise002.b;

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
        Pre-order:
         *  +  /  6  3  2  -  7  4
        In-order:
        ((( 6  /  3 ) +  2 ) * ( 7  -  4 ))
        Post-order:
         6  3  /  2  +  7  4  -  *
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
        Pre-order:
         -  +  1  *  2  3  *  /  1  2  2
        In-order:
        (( 1  + ( 2  *  3 )) - (( 1  /  2 ) *  2 ))
        Post-order:
         1  2  3  *  +  1  2  /  2  *  -
        --------------------------------------------------------------------------------
        INPUT
        Expression string: 1+2+3*(1+2)/4
        Expression tree:



              4



           /
                    2
                 +
                    1
              *

                 3

        +



              2



           +



              1




        OUTPUT:
        Pre-order:
         +  +  1  2  /  *  3  +  1  2  4
        In-order:
        (( 1  +  2 ) + (( 3  * ( 1  +  2 )) /  4 ))
        Post-order:
         1  2  +  3  1  2  +  *  4  /  +
        --------------------------------------------------------------------------------
        INPUT
        Expression string: 1.2+2.3+3.4*(1.2+2.3)/4.5
        Expression tree:



                  4.5



             /
                            2.3
                       +
                            1.2
                  *

                       3.4

        +



                  2.3



             +



                  1.2




        OUTPUT:
        Pre-order:
         +  +  1.2  2.3  /  *  3.4  +  1.2  2.3  4.5
        In-order:
        (( 1.2  +  2.3 ) + (( 3.4  * ( 1.2  +  2.3 )) /  4.5 ))
        Post-order:
         1.2  2.3  +  3.4  1.2  2.3  +  *  4.5  /  +
        --------------------------------------------------------------------------------

        */

    }
}
