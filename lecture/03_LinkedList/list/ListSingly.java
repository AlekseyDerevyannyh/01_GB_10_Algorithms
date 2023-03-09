public class ListSingly {
    Node head;

    public void revert() {
        if (head != null && head.next != null) {
            Node tmp = head;
            revert(head.next, head);
            tmp.next = null;
        }
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
//        previousNode.next = null;
    }
    public class Node {
        int value;
        Node next;
    }
}
