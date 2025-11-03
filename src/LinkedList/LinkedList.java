package LinkedList;

import java.net.StandardSocketOptions;

public class LinkedList {
    Node head;

    public void append(int data){
        Node newNode = new Node(data);
        if (head ==null){
           head = newNode;
           return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void delete(int key){
        Node temp = head,prev = null;

        if (temp != null && temp.data ==key){
            head = temp.next;
            return;
        }
        while ( temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        if (temp ==null) return;
        prev.next =temp.next;
    }
    public void insertAfter(int prevData, int newData) {
      Node current = head;
      while (current!= null && current.data != prevData){
          current = current.next;
      }
      if (current == null){
          System.out.println("Hata: " + prevData + " değerine sahip düğüm bulunamadı!");
          return;
      }
      Node newNode= new Node(newData);
      newNode.next =current.next;
      current.next = newNode;
    }
    public void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null\n");

    }
}
