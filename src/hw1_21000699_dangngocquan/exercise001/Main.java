package hw1_21000699_dangngocquan.exercise001;

public class Main {
    public static void main(String[] args) {
        byte value1 = 104;          // 1 byte - [-2^7, 2^7-1]
        short value2 = 104;         // 2 bytes - [-2^15, 2^15-1]
        int value3 = 104;           // 4 bytes - [-2^31, 2^31-1]
        long value4 = 104;          // 8 bytes - [-2^63, 2^63-1]
        float value5 = 104.104f;    // 4 bytes
        double value6 = 104.104;    // 8 bytes
        boolean value7 = true;      // 1 bit
        char value8 = 'Q';          // 2 bytes

        Object[] values = new Object[] {
                value1, value2, value3, value4,
                value5, value6, value7, value8
        };

        // Show type of each value (not type of variable)
        System.out.printf("%-25s %-25s\n", "Value", "Type of value");
        for (Object value : values) {
            System.out.printf(
                    "%-25s %-25s\n",
                    value,
                    value.getClass().getSimpleName()
            );
        }

        // Output

        //     Value                     Type of value
        //     104                       Byte
        //     104                       Short
        //     104                       Integer
        //     104                       Long
        //     104.104                   Float
        //     104.104                   Double
        //     true                      Boolean
        //     Q                         Character
    }
}
