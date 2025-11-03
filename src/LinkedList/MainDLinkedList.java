package LinkedList;

public class MainDLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.displayForward();   // 10 ⇀ 20 ⇀ 30 ⇀ null
        dll.displayBackward();  // 30 ⇁ 20 ⇁ 10 ⇁ null

        dll.insertAtBeginning(5);
        dll.displayForward();   // 5 ⇀ 10 ⇀ 20 ⇀ 30 ⇀ null

        dll.insertAfter(20, 25);
        dll.displayForward();   // 5 ⇀ 10 ⇀ 20 ⇀ 25 ⇀ 30 ⇀ null

        dll.insertBefore(10, 7);
        dll.displayForward();   // 5 ⇀ 7 ⇀ 10 ⇀ 20 ⇀ 25 ⇀ 30 ⇀ null

        dll.delete(30);
        dll.displayForward();   // 5 ⇀ 7 ⇀ 10 ⇀ 20 ⇀ 25 ⇀ null
        dll.displayBackward();  // 25 ⇁ 20 ⇁ 10 ⇁ 7 ⇁ 5 ⇁ null

        System.out.println("size = " + dll.size()); // 5
    }
}
