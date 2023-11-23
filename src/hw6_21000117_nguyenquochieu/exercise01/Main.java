package hw6_21000117_nguyenquochieu.exercise01;

public class Main {
    static class Student implements Comparable {
        private String name;
        private int grade;
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Object o) {
            Student object = (Student) o;
            if (this.grade > object.grade) return 1;
            else if (this.grade < object.grade) return  -1;
            else return 0;
        }

        @Override
        public String toString() {
            return name + " - " + grade;
        }
    }
    public static void main(String[] args) {
        System.out.println("Priority Queue implemented by array: ");
        testBasicArrayPriorityQueue();
        System.out.println("------------------------");
        System.out.println("Priority Queue implemented by linked structure: ");
        testBasicLinkedPriorityQueue();
        System.out.println("------------------------");
        System.out.println("Advanced Priority Queue using other class: ");
        testAdvancedLinkedPriorityQueue();
    }
    public static void testBasicArrayPriorityQueue() {
        System.out.println("Unsorted Priority Queue: ");
        PriorityQueueInterface<Integer, String> priorityQueue = new UnsortedArrayPriorityQueue();
        priorityQueue.insert(6, "Nguyen Quoc Hieu");
        priorityQueue.insert(5, "Tran Duy Hung");
        priorityQueue.insert(3, "Cao Tien Dat");
        priorityQueue.insert(4, "Nguyen Van Nam");
        priorityQueue.insert(2, "Ly Thi Binh");
        System.out.println("Min value: " + priorityQueue.min());
        priorityQueue.removeMin();
        System.out.println("Remove min");
        System.out.println("Min value: " + priorityQueue.min());

        System.out.println("Sorted Priority Queue: ");
        PriorityQueueInterface<Integer, String> priorityQueue1 = new SortedArrayPriorityQueue<>();
        priorityQueue1.insert(6, "Nguyen Quoc Hieu");
        priorityQueue1.insert(5, "Tran Duy Hung");
        priorityQueue1.insert(3, "Cao Tien Dat");
        priorityQueue1.insert(4, "Nguyen Van Nam");
        priorityQueue1.insert(2, "Ly Thi Binh");
        System.out.println("Min value: " + priorityQueue1.min());
        priorityQueue1.removeMin();
        System.out.println("Remove min");
        System.out.println("Min value: " + priorityQueue1.min());

    }
    public static void testBasicLinkedPriorityQueue() {
        System.out.println("Unsorted Priority Queue: ");
        PriorityQueueInterface<Integer, String> priorityQueue = new UnsortedLinkedPriorityQueue<>();
        priorityQueue.insert(6, "Nguyen Quoc Hieu");
        priorityQueue.insert(5, "Tran Duy Hung");
        priorityQueue.insert(3, "Cao Tien Dat");
        priorityQueue.insert(4, "Nguyen Van Nam");
        priorityQueue.insert(2, "Ly Thi Binh");
        System.out.println("Min value: " + priorityQueue.min());
        priorityQueue.removeMin();
        System.out.println("Remove min");
        System.out.println("Min value: " + priorityQueue.min());

        System.out.println("Sorted Priority Queue: ");
        PriorityQueueInterface<Integer, String> priorityQueue1 = new SortedLinkedPriorityQueue<>();
        priorityQueue1.insert(6, "Nguyen Quoc Hieu");
        priorityQueue1.insert(5, "Tran Duy Hung");
        priorityQueue1.insert(3, "Cao Tien Dat");
        priorityQueue1.insert(4, "Nguyen Van Nam");
        priorityQueue1.insert(2, "Ly Thi Binh");
        System.out.println("Min value: " + priorityQueue1.min());
        priorityQueue1.removeMin();
        System.out.println("Remove min");
        System.out.println("Min value: " + priorityQueue1.min());
    }

    public static void testAdvancedLinkedPriorityQueue() {
        System.out.println("Advanced Sorted Priority Queue: ");
        PriorityQueueInterface<Student, String> priorityQueue = new SortedLinkedPriorityQueue<>();
        Student s1 = new Student("Nguyen Van A", 10);
        Student s2 = new Student("Tran Van B", 6);
        Student s3 = new Student("Cao Nhu C", 9);
        Student s4 = new Student("Hoang Manh D", 7);
        Student s5 = new Student("Phung Thi E", 5);
        priorityQueue.insert(s1, "K66A2");
        priorityQueue.insert(s2, "K63A2");
        priorityQueue.insert(s3, "K64A2");
        priorityQueue.insert(s4, "K65A2");
        priorityQueue.insert(s5, "K67A2");
        System.out.println("Min value: " + priorityQueue.min());
        priorityQueue.removeMin();
        System.out.println("Remove min");
        System.out.println("Min value: " + priorityQueue.min());

    }
}
