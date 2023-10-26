package hw4_20001970_duongtuanson.Bai5;
import hw4_20001970_duongtuanson.Bai2.ArrayStack;
import hw4_20001970_duongtuanson.Bai2.StackInterface;
import hw4_20001970_duongtuanson.Bai4.ArrayQueue;
import hw4_20001970_duongtuanson.Bai4.QueueInterface;

public class PalindromeCheck {
    public boolean check(String s) {
        StackInterface<Character> stack = new ArrayStack<>();
        QueueInterface<Character> queue = new ArrayQueue<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.enqueue(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        System.out.println(palindromeCheck.check("abba"));
        System.out.println(palindromeCheck.check("abbc"));
    }
}
