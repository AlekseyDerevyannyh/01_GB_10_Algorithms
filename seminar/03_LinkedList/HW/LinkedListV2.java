public class LinkedListV2<T> {
    public NodeV2 head;
    public NodeV2 tail;
    public int count;

    public class NodeV2 {
        public T value;
        public NodeV2 next;
        public NodeV2 prev;
    }

    public NodeV2 addFirst(T value) {
        NodeV2 node = new NodeV2();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        count++;
        return node;
    }

    public void revert() {
        NodeV2 node = head;
        while (node != null) {
            NodeV2 next = node.next;
            NodeV2 prev = node.prev;
            node.next = prev;
            node.prev = next;
            if (prev == null) {
                tail = node;
            }
            if (next == null) {
                head = node;
            }
            node = next;
        }
    }
}
