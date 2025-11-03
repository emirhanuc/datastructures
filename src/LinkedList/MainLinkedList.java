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
    }
}
