package hw3_22001273_nguyenhoangminh.excercise3;

public class SimpleLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> top = null;
    private Node<T> bot = null;
    private int size = 0;

    public SimpleLinkedList() {
    }

    public void add(T data) {
        top = new Node<>(data, top);
        if (size == 0) {
            bot = top;      // if previously empty list, new node is also the bot
        }
        size++;
    }

    public void insert(T data, int idx) {
        if (idx == 0) {
            add(data);
        } else {
            Node current = top;
            for (int i = 1; i < idx; ++i) {
                current = current.getNext();
            }
            Node temp = current.getNext();
            current.setNext(new Node(data, temp));
            size++;
        }
    }

    public void addBot(T data) {
        Node<T> newest = new Node<>(data, null);
        if (isEmpty()) {
            top = newest;
        } else {
            bot.setNext(newest);
        }
        bot = newest;
        size++;
    }

    public T removeTop() {
        if (isEmpty()) return null;
        T rtn = top.getData();
        top = top.getNext();
        size--;
        if (size == 0) {
            bot = null;
        }
        return rtn;
    }

    public T removeBot() {
        if (isEmpty()) return null;
        T rtn = bot.getData();
        bot = top;      // assign bot with top
        size--;
        if (size == 0) {
            bot = null;
            top = null;
        } else {
            for (int idx = 1; idx < size; ++idx) {  // to access index i, we need i - 1 assignments
                bot = bot.getNext();        // at last, node will become bot
            }
            bot.setNext(null);
        }
        return rtn;
    }

    public T remove(int idx) {
        if (idx == 0) {
            return removeTop();
        } else if (idx == size - 1) {
            return removeBot();
        } else {
            Node current = top;
            for (int i = 1; i < idx; ++i) {
                current = current.getNext();
            }
            Node answer = current.getNext();
            current.setNext(answer.getNext());
            answer.setNext(null);
            size--;
            return (T) answer.getData();
        }
    }

    public T get(int i) {
        if (isEmpty()) return null;
        else if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index must be greater than zero and smaller than size.");
        } else {
            Node<T> current = top;
            for (int idx = 0; idx < i; ++idx) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public void set(int i, T data) {
        if (i >= size || i < 0)
            throw new IndexOutOfBoundsException("Index must be greater than zero and smaller than size.");
        Node<T> current = top;
        for (int idx = 0; idx < i; ++idx) {
            current = current.getNext();
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        return indexOf(data) != -1;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; ++i) {
            if (data.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void remove(T data) {
        if (isContain(data)) {
            if (data.equals(top.getData())) {    // top node must be treated differently
                top = top.getNext();
                size--;
                if (size == 0) {
                    bot = null;
                }
            } else {
                Node<T> current = top;

                for (int idx = 0; idx < size - 1; ++idx) {
                    if (data.equals(current.getNext().getData())) {
                        current.setNext(current.getNext().getNext());
                        size--;
                    }
                    current = current.getNext();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (i < size - 1) {
                str.append(get(i));
                str.append(" -> ");
            } else {
                str.append(get(i));
            }
        }
        return str.toString();
    }

}
