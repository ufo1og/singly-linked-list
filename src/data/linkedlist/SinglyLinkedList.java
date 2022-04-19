package data.linkedlist;

/**
 * Singly linked list.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class SinglyLinkedList<T> {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("2-" + list.get(2));
        System.out.println("0-" + list.get(0));
        list.remove(1); // удалили B
        System.out.println(list);
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void remove(int index) {
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = head;
            }
            size--;
            return;
        }
        Node<T> nodePrev = this.head;
        for (int i = 1; i < index; i++) {
            nodePrev = nodePrev.next;
        }
        Node<T> node = nodePrev.next;
        Node<T> next = node.next;
        if (next == null) {
            tail = nodePrev;
            return;
        }
        nodePrev.next = next;
    }

    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        Node<T> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    // Добавление в конец
    public void add(T a) {
        size++;
        if (head == null) {
            head = new Node<>(a, null);
            tail = head;
            return;
        }

        final Node<T> newNode = new Node<>(a, null);
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node<T> node = this.head;
        while (node != null) {
            sb.append(node.value).append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
