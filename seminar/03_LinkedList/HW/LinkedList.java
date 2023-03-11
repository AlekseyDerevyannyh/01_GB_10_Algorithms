import java.util.Comparator;

public class LinkedList<T> {
    public Node head;

    public class Node {
        public T value;
        public Node next;
    }

    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void revert() {
        if (head != null && head.next != null) {
            Node tmp = head;
            revert(head.next, head);
            tmp.next = null;
        }
    }

    private void revert(Node node, Node prevNode) {
        if (node.next == null) {
            head = node;
        } else {
            revert(node.next, node);
        }
        node.next = prevNode;
    }
}
