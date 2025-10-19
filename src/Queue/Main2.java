package Queue;

import java.sql.Date;

public class Main2{
    public static void main(String[] args) {
        AssignmentLog myHomework = new AssignmentLog();

        myHomework.addProject("CSC211", "Pg 50, Ex 2", Date.valueOf("2007-10-21"));
        Assignment pg75Ex8 = new Assignment("CSC215", "Pg 75, Ex 8", Date.valueOf("2007-10-14"));
        myHomework.addProject(pg75Ex8);
        myHomework.addProject("CSC210", "Lab Report", Date.valueOf("2007-10-25"));

        System.out.println("Bir sonraki teslim edilmesi gereken ödev:");
        System.out.println(myHomework.getNextProject()); // sadece gösterir

        System.out.println("\nTüm ödevler:");
        myHomework.printAllAssignments();

        System.out.println("\nTeslim edilen ödev: " + myHomework.removeNextProject());
        System.out.println("Kalan ödev sayısı: " + myHomework.getSize());
    }
}
