package Queue;

import java.sql.Date;

public class Assignment implements Comparable<Assignment> {
    private final String course;   // ders kodu
    private final String task;     // görev açıklaması
    private final Date date;       // teslim tarihi

    public Assignment(String course, String task, Date date) {
        this.course = course;
        this.task = task;
        this.date = date;
    }

    public String getCourseCode() { return course; }
    public String getTask() { return task; }
    public Date getDueDate() { return date; }

    @Override
    public int compareTo(Assignment other) {
        // En erken tarih (küçük date) en yüksek öncelik olsun
        return -date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return course + " - " + task + " (Due: " + date + ")";
    }
}
