package Lists;

public class LList<T> implements ListInterface<T> {

    // ----- İç düğüm sınıfı -----
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) { this.data = data; }
    }

    // ----- Alanlar -----
    private Node<T> head;             // listenin ilk düğümü
    private Node<T> tail;             // son düğümü hızlı ekleme için tutuyoruz (opsiyonel)
    private int numberOfEntries = 0;  // eleman sayısı

    // ----- Yardımcılar -----
    /** 1-based pozisyondaki düğümü döndürür. (1..n) */
    private Node<T> getNodeAt(int givenPosition) {
        Node<T> current = head;
        for (int i = 1; i < givenPosition; i++) {
            current = current.next;
        }
        return current;
    }

    // ----- ListInterface implementasyonu -----

    /** Listenin sonuna ekleme: O(1) (tail tuttuğumuz için) */
    @Override
    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode; // kaydırma yok, sadece pointer güncelliyoruz
            tail = newNode;
        }
        numberOfEntries++;
    }

    /** Verilen pozisyona ekleme: O(n) (o pozisyona kadar yürürüz) */
    @Override
    public void add(int newPosition, T newEntry) {
        if (newPosition < 1 || newPosition > numberOfEntries + 1)
            throw new IndexOutOfBoundsException("Invalid position: " + newPosition);

        Node<T> newNode = new Node<>(newEntry);

        if (newPosition == 1) {            // başa ekle
            newNode.next = head;           // kaydırma yok; bağlantı güncelle
            head = newNode;
            if (numberOfEntries == 0) tail = newNode; // ilk elemandıysa tail de bu
        } else if (newPosition == numberOfEntries + 1) { // sona ekle (O(1))
            tail.next = newNode;
            tail = newNode;
        } else {                           // araya ekle
            Node<T> nodeBefore = getNodeAt(newPosition - 1);
            newNode.next = nodeBefore.next;
            nodeBefore.next = newNode;     // yine kaydırma yok
        }
        numberOfEntries++;
    }

    /** Verilen pozisyondan silme: O(n) (bağlantıyı atlatırız) */
    @Override
    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > numberOfEntries)
            throw new IndexOutOfBoundsException("Invalid position: " + givenPosition);

        T result;

        if (givenPosition == 1) {          // baştan sil
            result = head.data;
            head = head.next;              // bağlantıyı öne al
            if (numberOfEntries == 1) tail = null; // tek eleman silindiyse tail de boşalır
        } else {
            Node<T> nodeBefore = getNodeAt(givenPosition - 1);
            Node<T> nodeToRemove = nodeBefore.next;
            result = nodeToRemove.data;
            nodeBefore.next = nodeToRemove.next; // aradaki düğümü atlatarak çıkar
            if (nodeToRemove == tail) tail = nodeBefore; // sondan sildiysek tail güncelle
        }

        numberOfEntries--;
        return result;
    }

    /** Verilen pozisyona yeni değeri yaz: O(n) */
    @Override
    public void replace(int givenPosition, T newEntry) {
        if (givenPosition < 1 || givenPosition > numberOfEntries)
            throw new IndexOutOfBoundsException("Invalid position: " + givenPosition);

        Node<T> target = getNodeAt(givenPosition);
        target.data = newEntry;
    }

    /** Verilen pozisyondaki değeri getir: O(n) */
    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > numberOfEntries)
            throw new IndexOutOfBoundsException("Invalid position: " + givenPosition);

        return getNodeAt(givenPosition).data;
    }

    /** Lineer arama: O(n) */
    @Override
    public boolean contains(T anEntry) {
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            if ((anEntry == null && cur.data == null) ||
                    (anEntry != null && anEntry.equals(cur.data))) {
                return true;
            }
        }
        return false;
    }

    /** Boyuta uygun bir Object[] üretip generic cast yapıyoruz. */
    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        Object[] arr = new Object[numberOfEntries];
        int i = 0;
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            arr[i++] = cur.data;
        }
        return (T[]) arr; // eğitim amaçlı basit dönüşüm
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
        head = tail = null;   // tüm bağlantılar GC’ye bırakılır
        numberOfEntries = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}