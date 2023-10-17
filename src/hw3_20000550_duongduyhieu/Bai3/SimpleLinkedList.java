package hw3_20000550_duongduyhieu.Bai3;

public class SimpleLinkedList<T> {
    // Lớp Node bên trong danh sách liên kết đơn
    class Node {
        T data;      // Dữ liệu của mỗi nút
        Node next;   // Tham chiếu đến nút tiếp theo

        // Hàm khởi tạo cho Node
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null; // Tham chiếu đến đầu danh sách
    private Node bot = null; // Tham chiếu đến cuối danh sách
    private int n = 0;      // Số lượng phần tử trong danh sách

    // Phương thức thêm một phần tử vào cuối danh sách
    public void add(T data) {
        Node newNode = new Node(data);
        newNode.next = null;

        // Nếu danh sách rỗng, đặt cả đầu và cuối đều là nút mới
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            // Nếu danh sách không rỗng, thêm nút mới vào cuối danh sách
            bot.next = newNode;
            bot = newNode;
        }

        n++; // Tăng số lượng phần tử trong danh sách
    }

    // Phương thức thêm một phần tử vào đầu danh sách
    public void addBot(T data) {
        Node newNode = new Node(data);

        // Đặt nút mới làm đầu danh sách
        newNode.next = top;
        top = newNode;

        // Nếu danh sách trống, đặt cả cuối là nút mới
        if (bot == null) {
            bot = newNode;
        }

        n++; // Tăng số lượng phần tử trong danh sách
    }

    // Phương thức lấy phần tử tại vị trí i
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    // Phương thức đặt giá trị của phần tử tại vị trí i
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        currentNode.data = data;
    }

    // Phương thức kiểm tra xem một phần tử có tồn tại trong danh sách không
    public boolean isContain(T data) {
        Node currentNode = top;

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    // Phương thức trả về kích thước của danh sách
    public int size() {
        return n;
    }

    // Phương thức kiểm tra danh sách có rỗng không
    public boolean isEmpty() {
        return n == 0;
    }

    // Phương thức loại bỏ phần tử từ đầu danh sách và trả về giá trị của nó
    public T removeTop() {
        if (isEmpty()) {
            return null;
        }
        T removedData = top.data;
        top = top.next;
        n--;

        // Nếu danh sách trở thành rỗng sau khi loại bỏ, đặt cả cuối là null
        if (isEmpty()) {
            bot = null;
        }

        return removedData;
    }

    // Phương thức loại bỏ phần tử từ cuối danh sách và trả về giá trị của nó
    public T removeBot() {
        if (isEmpty()) {
            return null;
        }

        // Trường hợp đặc biệt khi danh sách chỉ chứa một phần tử
        if (top == bot) {
            T removedData = bot.data;
            top = null;
            bot = null;
            n--;
            return removedData;
        }

        Node currentNode = top;
        while (currentNode.next != bot) {
            currentNode = currentNode.next;
        }
        T removedData = bot.data;
        currentNode.next = null;
        bot = currentNode;
        n--;

        return removedData;
    }

    // Phương thức loại bỏ một phần tử cụ thể từ danh sách
    public void remove(T data) {
        Node currentNode = top;
        Node prevNode = null;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                if (prevNode != null) {
                    prevNode.next = currentNode.next;
                    // Cập nhật bot nếu nút bị loại bỏ là cuối danh sách
                    if (currentNode == bot) {
                        bot = prevNode;
                    }
                } else {
                    top = currentNode.next;
                    // Cập nhật bot nếu nút bị loại bỏ là cuối danh sách
                    if (currentNode == bot) {
                        bot = null;
                    }
                }
                n--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}
