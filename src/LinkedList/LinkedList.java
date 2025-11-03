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
    public void insertBefore(int key, int newData) {
        // 1) Boş liste
        if (head == null) {
            System.out.println("Uyarı: Liste boş, ekleme yapılmadı.");
            return;
        }

        // 2) head hedefse: başa ekleme
        if (head.data == key) {
            insertAtBeginning(newData);
            return;
        }

        // 3) prev-curr ile ara tara
        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        // 4) bulunamadı
        if (curr == null) {
            System.out.println("Uyarı: " + key + " değerine sahip düğüm bulunamadı.");
            return;
        }

        // 5) bulundu: prev ile curr arasına newNode ekle
        Node newNode = new Node(newData);
        newNode.next = curr;   // yeni düğüm, hedefi işaret etsin
        prev.next = newNode;   // prev artık yeni düğümü işaret etsin
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
