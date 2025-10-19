package Queue;

public interface QueueInterface <T>{
    void enqueue(T newEntry);
    T dequeue();           // boşsa null döndürebilir ya da exception atabilirsiniz
    T getFront();
    boolean isEmpty();
    void clear();

}
