package Queue;

import java.util.LinkedList;

public class LinkedQueue<T> implements QueueInterface<T> {
    private final LinkedList<T> list = new LinkedList<>();

    @Override
    public void enqueue(T newEntry) {
        list.addLast(newEntry);
    }

    @Override
    public T dequeue() {
        return list.isEmpty() ? null : list.removeFirst();
    }

    @Override
    public T getFront() {
        return list.isEmpty() ? null : list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }
}



