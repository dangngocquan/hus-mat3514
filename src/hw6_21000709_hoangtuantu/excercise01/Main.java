package hw6_21000709_hoangtuantu.excercise01;

import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void test01(boolean arrayTest, boolean sort, int size, int bound){
        PriorityQueue<Integer, Character> queue;
        if (arrayTest){
            if (sort){
                queue = new SortedArrayPriorityQueue<>();
            }else{
                queue = new UnsortedArrayPriorityQueue<>();
            }
        }else{
            if (sort){
                queue = new SortedLinkedPriorityQueue<>();
            }else{
                queue = new UnsortedLinkedPriorityQueue<>();
            }
        }
        for (int i = 0; i < size; i++){
            Entry<Integer, Character> entry;
            if (arrayTest){
                entry = new ArrEntry<>(random.nextInt(bound) + 100,(char) (random.nextInt(26) + 65));
                queue.insert(entry);
            }else{
                entry = new NodeEntry<>(random.nextInt(bound) + 100,(char) (random.nextInt(26) + 65));
                queue.insert(entry);
            }
        }

        System.out.println("Origin queue: ");
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.min());
        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Queue after remove: ");
        System.out.println(queue);
        System.out.println("Size after remove: " + queue.size());
        System.out.println("______________________\n");
    }

    public static void test02(boolean arrayTest, boolean sort, int size, int bound){
        PriorityQueue<Integer, Integer> queue;
        if (arrayTest){
            if (sort){
                queue = new SortedArrayPriorityQueue<>();
            }else{
                queue = new UnsortedArrayPriorityQueue<>();
            }
        }else{
            if (sort){
                queue = new SortedLinkedPriorityQueue<>();
            }else{
                queue = new UnsortedLinkedPriorityQueue<>();
            }
        }
        for (int i = 0; i < size; i++){
            Entry<Integer, Integer> entry;
            if (arrayTest){
                entry = new ArrEntry<>(random.nextInt(bound), random.nextInt(bound));
                queue.insert(entry);
            }else{
                entry = new NodeEntry<>(random.nextInt(bound), (random.nextInt(bound)));
                queue.insert(entry);
            }
        }

        System.out.println("Origin queue: ");
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.min());
        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Queue after remove: ");
        System.out.println(queue);
        System.out.println("Size after remove: " + queue.size());
        System.out.println("______________________\n");
    }

    public static String getID(int size){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++){
            if (i == 0){
                result.append(2);
            } else if(i == 1){
                result.append(1);
            }else{
                result.append((random.nextInt(10)));
            }
        }
        return result.toString();
    }



    public static void test03(boolean arrayTest, boolean sort, int size){
        final String[] NAMES = {"Tu", "Trang", "Phuong", "Trung", "Nam", "Vinh", "Hoang", "Tuan", "Quan", "Hanh", "Duc"};
        PriorityQueue<String, People> queue;
        if (arrayTest){
            if (sort){
                queue = new SortedArrayPriorityQueue<>();
            }else{
                queue = new UnsortedArrayPriorityQueue<>();
            }
        }else{
            if (sort){
                queue = new SortedLinkedPriorityQueue<>();
            }else{
                queue = new UnsortedLinkedPriorityQueue<>();
            }
        }
        for (int i = 0; i < size; i++){
            Entry<String, People> entry;
            String id = getID(7);
            int age = random.nextInt(4) + 18;
            String name = NAMES[random.nextInt(NAMES.length)];
            People people = new People(id, age, name);
            if (arrayTest){
                entry = new ArrEntry<>(id, people);
                queue.insert(entry);
            }else{
                entry = new NodeEntry<>(id, people);
                queue.insert(entry);
            }
        }

        System.out.println("Origin queue: ");
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println("Min: " + queue.min());
        System.out.println("Remove min: " + queue.removeMin());
        System.out.println("Queue after remove: ");
        System.out.println(queue);
        System.out.println("Size after remove: " + queue.size());
        System.out.println("______________________\n");
    }
    public static void main(String[] args) {
        final int BOUND = (int) Math.pow(10, 2);
        final int SIZE = 10;
        System.out.println("TEST 01");
        System.out.println("____________________\n");

        System.out.println("Test01 Sorted Array Priority Queue ");
        test01(true, true, SIZE, BOUND);

        System.out.println("Test01 UnSorted Array Priority Queue ");
        test01(true, false, SIZE, BOUND);

        System.out.println("Test01 UnSorted Linked Priority Queue ");
        test01(false, false, SIZE, BOUND);

        System.out.println("Test01 Sorted Linked Priority Queue ");
        test01(false, true, SIZE, BOUND);

        System.out.println("TEST 02");
        System.out.println("____________________\n");
        System.out.println("Test01 Sorted Array Priority Queue ");
        test02(true, true, SIZE, BOUND);

        System.out.println("Test01 UnSorted Array Priority Queue ");
        test02(true, false, SIZE, BOUND);

        System.out.println("Test01 UnSorted Linked Priority Queue ");
        test02(false, false, SIZE, BOUND);

        System.out.println("Test01 Sorted Linked Priority Queue ");
        test02(false, true, SIZE, BOUND);

        System.out.println("TEST 03");
        System.out.println("____________________\n");

        System.out.println("Test01 Sorted Array Priority Queue ");
        test03(true, true, SIZE);

        System.out.println("Test01 UnSorted Array Priority Queue ");
        test03(true, false, SIZE);

        System.out.println("Test01 UnSorted Linked Priority Queue ");
        test03(false, false, SIZE);

        System.out.println("Test01 Sorted Linked Priority Queue ");
        test03(false, true, SIZE);
    }
}
