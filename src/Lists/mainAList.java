package Lists;

public class mainAList {
    public static void main(String[] args) {
        ListInterface<String> students = new AList<>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        System.out.println("Initial List:");
        for (Object name : students.toArray())
            System.out.println("- " + name);

        students.add(2, "Diana");
        System.out.println("\nAfter inserting Diana at position 2:");
        for (Object name : students.toArray())
            System.out.println("- " + name);

        students.replace(3, "Eve");
        System.out.println("\nAfter replacing position 3 with Eve:");
        for (Object name : students.toArray())
            System.out.println("- " + name);

        students.remove(1);
        System.out.println("\nAfter removing first element:");
        for (Object name : students.toArray())
            System.out.println("- " + name);

        System.out.println("\nContains 'Bob'? " + students.contains("Bob"));
        System.out.println("List length: " + students.getLength());
    }
}