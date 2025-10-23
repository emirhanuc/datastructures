package Lists;

import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public AList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

    @Override
    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries++] = newEntry;
    }

    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            ensureCapacity();
            makeRoom(newPosition);
            list[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    }

    @Override
    public T remove(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            T result = list[givenPosition - 1];
            removeGap(givenPosition);
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    }

    @Override
    public void replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
            list[givenPosition - 1] = newEntry;
        else
            throw new IndexOutOfBoundsException("Invalid position");
    }

    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
            return list[givenPosition - 1];
        else
            throw new IndexOutOfBoundsException("Invalid position");
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int i = 0; !found && (i < numberOfEntries); i++) {
            if (list[i].equals(anEntry))
                found = true;
        }
        return found;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(list, numberOfEntries);
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfEntries; i++)
            list[i] = null;
        numberOfEntries = 0;
    }

    // ----- PRIVATE HELPERS -----
    private void ensureCapacity() {
        if (numberOfEntries == list.length)
            list = Arrays.copyOf(list, 2 * list.length);
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;
        for (int i = lastIndex; i >= newIndex; i--)
            list[i + 1] = list[i];
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;
        for (int i = removedIndex; i < lastIndex; i++)
            list[i] = list[i + 1];
        list[lastIndex] = null;
    }
}