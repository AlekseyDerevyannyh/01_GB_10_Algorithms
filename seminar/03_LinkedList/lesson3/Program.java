public class Program {
    public static void main(String[] args) {
        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(new Employee("Vasya", 25));
        linkedList.addFirst(new Employee("Petya", 35));
        linkedList.addFirst(new Employee("Ivan", 45));
//        linkedList.removeFirst();
        linkedList.directSort(new EmployeeNameComparator(SortType.Ascending));
        printList(linkedList);
        System.out.println();
        linkedList.directSort(new EmployeeNameComparator(SortType.Descending));
        printList(linkedList);
    }

    public static void printList(LinkedList<Employee> list) {
        LinkedList<Employee>.Node node = list.head;
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