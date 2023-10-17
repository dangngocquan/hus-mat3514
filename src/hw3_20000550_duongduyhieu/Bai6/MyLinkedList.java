package hw3_20000550_duongduyhieu.Bai6;

// phần bài code đã submit trên leetcode
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
class MyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        Node dummyhead = head;
        for(int i = 0; i < index; i++){
            dummyhead = dummyhead.next;
        }
        return dummyhead.val;
    }
    
    public void addAtHead(int val) {
        if(head == null){
            Node node = new Node(val);
            head = node;
            tail = node;
            size ++;
            return;
        }
        Node node = new Node (val);
        node.next = head;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        if(tail == null){
            Node node = new Node (val);
            head = node;
            tail = node;
            size++;
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size ++;
    }
    
    public void addAtIndex(int index, int val) {
        Node dummyhead = head;
        if (index == size){
            addAtTail(val);
            return;
        }
        if(index > size){
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        for (int i = 0; i < index-1; i++){
            dummyhead = dummyhead.next;
        }
        Node temp = dummyhead.next;
        Node node = new Node(val);
        dummyhead.next = node;
        node.next = temp;
        size ++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        if(index == 0){
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
            return;
        }
        Node dummyhead = head;
        for(int i = 0; i < index - 1; i++){
            dummyhead = dummyhead.next;
        }
        if(dummyhead.next == tail){
            tail = dummyhead;
        }
        dummyhead.next = dummyhead.next.next;
        size--;
    }
}

