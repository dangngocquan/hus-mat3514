package hw4_21000689_nguyenxuanloi.practice.ex1;

public class EncodeString {
    public static void main(String[] args) {
        String testString = "aaabbaaac";
        System.out.println(encodedString(testString));
    }

    static String encodedString(String s) {
        if (s.isEmpty()) {
            return "";
        } else {
            StackInterface<Character> chars = new ArrayStack<>(1);
            chars.push(s.charAt(0));
            StringBuilder result = new StringBuilder();
            int frequency = 1;
            for (int i = 1; i < s.length(); i++) {
                if (!chars.isEmpty() && s.charAt(i) != chars.top()) {
                    result.append(chars.pop()).append(frequency);
                    chars.push(s.charAt(i));
                    frequency = 1;
                } else {
                    frequency++;
                }
            }
            result.append(chars.pop()).append(frequency);
            return result.toString();
        }
    }
}
