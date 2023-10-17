package hw3_20001970_duongtuanson.Bai6;
import java.util.LinkedList;
public class linkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("C++");
        System.out.println("Các phần tử của danh sách là: " + linkedList);
        linkedList.remove("Python");
        System.out.println("Các phần tử của danh sách là: " + linkedList);
        linkedList.add(1, "PHP");
        System.out.println("Các phần tử của danh sách là: " + linkedList);
    }
}
