package hw4_22001273_nguyenhoangminh.excercise2;


public class TestStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> link = new LinkedListStack<>();

        for (int i = 0; i < 10; ++i) {
            link.push(i);
        }
        System.out.println(link);
        link.pop();
        System.out.println(link);
        link.push(12);
        System.out.println(link);

    }
}
