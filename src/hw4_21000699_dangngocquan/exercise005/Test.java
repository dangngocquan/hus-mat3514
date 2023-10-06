package hw4_21000699_dangngocquan.exercise005;

public class Test {
    public void run() {
        testPalindromes();
    }

    public void testPalindromes() {
        System.out.println("CHECK PALINDROME");
        System.out.printf(
                "\t%-20s %-50s\n",
                "Result",
                "Document"
        );
        System.out.println("\t------------------------------------------------------");

        testPalindrome("12321");
        testPalindrome("123321");
        testPalindrome("1234312");
        testPalindrome("Java sos sos avaj");
    }

    public void testPalindrome(String document) {
        System.out.printf(
                "\t%-20s %-50s\n",
                Palindrome.isPalindrome(document)? "Is palindrome" : "Is not palindrome",
                document
        );
    }
}
