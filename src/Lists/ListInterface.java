package Lists;
    public interface ListInterface<T> {
        /** Adds a new entry to the end of this list. */
        public void add(T newEntry);

        /** Adds a new entry at a specified position in this list. */
        public void add(int newPosition, T newEntry);

        /** Removes the entry at a given position. */
        public T remove(int givenPosition);

        /** Replaces the entry at a given position with a new entry. */
        public void replace(int givenPosition, T newEntry);

        /** Retrieves the entry at a given position. */
        public T getEntry(int givenPosition);

        /** Checks whether a given entry is in the list. */
        public boolean contains(T anEntry);

        /** Returns all entries in array form. */
        public T[] toArray();

        /** Gets the number of entries. */
        public int getLength();

        /** Checks if the list is empty. */
        public boolean isEmpty();

        /** Removes all entries. */
        public void clear();
    }

