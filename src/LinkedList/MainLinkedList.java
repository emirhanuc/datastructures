package LinkedList;

public class MainLinkedList {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.display();

        list.insertAtBeginning(5);
        list.display();

        list.delete(20);
        list.display();

        list.insertAfter(10,15);
        list.display();

        list.delete(5);
        list.delete(15);
        list.insertBefore(30,20);
        list.display();

        // head öncesine ekleme (key=head.data)
        list.insertBefore(10, 5);
        list.display(); // 5 → 10 → 20 → 30 → null

        // ortasına ekleme
        list.insertBefore(20, 15);
        list.display(); // 5 → 10 → 15 → 20 → 30 → null

        // sona yakın ekleme
        list.insertBefore(30, 25);
        list.display(); // 5 → 10 → 15 → 20 → 25 → 30 → null

        // bulunamayan anahtar
        list.insertBefore(99, 1); // Uyarı basar
        list.display(); // değişmez
    }
}
