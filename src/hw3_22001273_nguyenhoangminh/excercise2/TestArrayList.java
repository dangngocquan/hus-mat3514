package hw3_22001273_nguyenhoangminh.excercise2;

public class TestArrayList {
    public static void main(String[] args) {
        SimpleArrayList<Integer> list = new SimpleArrayList<>(1000);
        for (int i = 1; i <= 5; ++i) {
            list.add(i);
        }
        list.iterator();
        for (Integer a : list) {
            System.out.print(a + " ");
        }
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println(list.get(4));
        list.set(4, 10);
        System.out.println(list);
        System.out.println(list.isContain(5));
        System.out.println(list.isContain(10));
        list.set(4, 4);
        list.add(5);
        list.add(4);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);
    }
}
