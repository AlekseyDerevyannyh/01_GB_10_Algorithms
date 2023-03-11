public class Program {
    public static void main(String[] args) {
        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(new Employee("Vasya", 25));
        linkedList.addFirst(new Employee("Petya", 35));
        linkedList.addFirst(new Employee("Ivan", 45));
        linkedList.addFirst(new Employee("Masha", 38));
        linkedList.addFirst(new Employee("Fyodor", 25));
        linkedList.addFirst(new Employee("Katya", 24));
        printList(linkedList);
        System.out.println();
        linkedList.revert();
        printList(linkedList);
        System.out.println("\n");

        LinkedListV2<Employee> linkedListV2 = new LinkedListV2<>();
        linkedListV2.addFirst(new Employee("Ivan", 45));
        linkedListV2.addFirst(new Employee("Petya", 35));
        linkedListV2.addFirst(new Employee("Fyodor", 25));
        linkedListV2.addFirst(new Employee("Katya", 24));
        linkedListV2.addFirst(new Employee("Masha", 38));
        linkedListV2.addFirst(new Employee("Vasya", 25));
        printList(linkedListV2);
        System.out.println();
        linkedListV2.revert();
        printList(linkedListV2);

    }

    public static void printList(LinkedList<Employee> list) {
        LinkedList<Employee>.Node node = list.head;
        while (node != null) {
            System.out.printf("%s - %d. ", node.value.getName(), node.value.getAge());
            node = node.next;
        }
    }

    public static void printList(LinkedListV2<Employee> list) {
        LinkedListV2<Employee>.NodeV2 node = list.head;
        while (node != null) {
            System.out.printf("%s - %d. ", node.value.getName(), node.value.getAge());
            node = node.next;
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}