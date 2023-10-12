package hw4_21000699_dangngocquan.exercise001;

public class Main {
    public static void main(String[] args) {
        new Test().run();
        // Sample

        /*
        Enter your full name
        INPUT       : dangngocquan

        CODE EXECUTE:
        StackInterface stack = new LinkedListStack();
        for (int i = 0; i < fullName.length(); i++) {
            if (i % 2 == 0) stack.push(fullName.charAt(i));
            if (i % 3 == 0) stack.pop();
        }

        RUNTIME     :
        i     Action          Stack
        ------------------------------------------
        0     stack.push(d)   [d]
        0     stack.pop()     []
        1     none            []
        2     stack.push(n)   [n]
        3     stack.pop()     []
        4     stack.push(n)   [n]
        5     none            [n]
        6     stack.push(o)   [n, o]
        6     stack.pop()     [n]
        7     none            [n]
        8     stack.push(q)   [n, q]
        9     stack.pop()     [n]
        10    stack.push(a)   [n, a]
        11    none            [n, a]

        OUTPUT      : [n, a]
        */
    }
}
