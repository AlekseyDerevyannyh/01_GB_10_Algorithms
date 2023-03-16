public class Program {
    public static void main(String[] args) {
        HashMap<String, Employee> hashMap = new HashMap<>();
        Employee e1 = hashMap.put("abc", new Employee("Employee1", 34));
        Employee e2 = hashMap.put("abcd", new Employee("Employee2", 31));
        Employee e3 = hashMap.put("abc", new Employee("Employee3", 44));
        Employee e4 = hashMap.put("abcde", new Employee("Employee4", 35));

        Employee e5 = hashMap.remove("abc");
        Employee e6 = hashMap.remove("abc");

        Employee e7 = hashMap.get("abc");
        Employee e8 = hashMap.get("abcde");
    }
}

class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
