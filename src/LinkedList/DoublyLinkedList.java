package LinkedList;

public class DoublyLinkedList {
    private DNode head;
    private DNode tail;
    private int size;

    // O(1)
    public int size() { return size; }

    // O(1)
    public void clear() {
        // GC için referansları kopar
        DNode cur = head;
        while (cur != null) {
            DNode nxt = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = nxt;
        }
        head = tail = null;
        size = 0;
    }

    // Sona ekleme: O(1)
    public void append(int data) {
        DNode node = new DNode(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // Başa ekleme: O(1)
    public void insertAtBeginning(int data) {
        DNode node = new DNode(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // Belirli değerden SONRA ekle: O(n)
    public void insertAfter(int key, int newData) {
        DNode cur = head;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("Uyarı: " + key + " bulunamadı.");
            return;
        }
        DNode node = new DNode(newData);
        node.next = cur.next;
        node.prev = cur;
        if (cur.next != null) cur.next.prev = node;
        cur.next = node;
        if (cur == tail) tail = node; // sona eklendiyse tail güncelle
        size++;
    }

    // Belirli değerden ÖNCE ekle: O(n)
    public void insertBefore(int key, int newData) {
        if (head == null) {
            System.out.println("Uyarı: Liste boş.");
            return;
        }
        // hedef head ise başa ekleme ile aynı
        if (head.data == key) {
            insertAtBeginning(newData);
            return;
        }
        DNode cur = head.next;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("Uyarı: " + key + " bulunamadı.");
            return;
        }
        DNode node = new DNode(newData);
        node.prev = cur.prev;
        node.next = cur;
        cur.prev.next = node;
        cur.prev = node;
        size++;
    }

    // Değere göre sil: O(n)
    public void delete(int key) {
        if (head == null) return;

        // baş
        if (head.data == key) {
            if (head == tail) { // tek eleman
                head = tail = null;
            } else {
                head = head.next;
                head.prev.next = null; // eski head'in next'ini kopar
                head.prev = null;
            }
            size--;
            return;
        }

        // orta/son
        DNode cur = head.next;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }
        if (cur == null) return;

        if (cur == tail) { // son düğüm
            tail = tail.prev;
            tail.next.prev = null; // eski tail’in prev’ini kopar
            tail.next = null;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // cur'un bağlarını koparmak iyi bir pratik
            cur.prev = null;
            cur.next = null;
        }
        size--;
    }

    // İleri yönde yazdır: O(n)
    public void displayForward() {
        DNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ⇀ ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    // Geri yönde yazdır: O(n)
    public void displayBackward() {
        DNode cur = tail;
        while (cur != null) {
            System.out.print(cur.data + " ⇁ ");
            cur = cur.prev;
        }
        System.out.println("null");
    }
}
