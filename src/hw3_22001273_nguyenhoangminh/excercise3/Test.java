package hw3_22001273_nguyenhoangminh.excercise3;

public class Test {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.addBot(2);
        list.addBot(3);
        list.addBot(4);
        list.addBot(5);
        System.out.println("Size: " + list.size());
        System.out.println(list.get(3));
        System.out.println(list);
        list.removeTop();
        System.out.println("Size: " + list.size());
        System.out.println(list);
        list.removeBot();
        System.out.println("Size: " + list.size());
        System.out.println(list);
        list.remove(3);
        System.out.println("Size: " + list.size());
        System.out.println(list);
        list.set(1, 10);
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.isContain(10));
    }
}
