package Queue;

import java.sql.Date;
import java.util.PriorityQueue;

public class AssignmentLog {
    private final PriorityQueue<Assignment> log;

    public AssignmentLog() {
        log = new PriorityQueue<>(); // FIFO değil, Priority Queue (öncelikli)
    }

    public void addProject(Assignment newAssignment) {
        log.add(newAssignment);
    }

    public void addProject(String courseCode, String task, Date dueDate) {
        Assignment newAssignment = new Assignment(courseCode, task, dueDate);
        addProject(newAssignment);
    }

    public Assignment getNextProject() {
        return log.peek(); // en erken tarihli (en öncelikli) görevi gösterir, silmez
    }

    public Assignment removeNextProject() {
        return log.poll(); // en erken tarihli görevi getirir ve listeden siler
    }

    public boolean isEmpty() { return log.isEmpty(); }

    public int getSize() { return log.size(); }

    public void printAllAssignments() {
        System.out.println("\n== Tüm Görevler (öncelik sırasına göre) ==");
        for (Assignment a : log) System.out.println(a);
    }
}