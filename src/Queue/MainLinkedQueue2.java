package Queue;

public class MainLinkedQueue2 {
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new LinkedQueue2<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        ((LinkedQueue2<Integer>) queue).display();

        System.out.println("Ön eleman (getFront): " + queue.getFront());
        System.out.println("Boş mu? " + queue.isEmpty());

        queue.dequeue(); // 10 çıkar
        ((LinkedQueue2<Integer>) queue).display();

        System.out.println("Contains(30): " + ((LinkedQueue2<Integer>) queue).contains(30));
        System.out.println("Contains(99): " + ((LinkedQueue2<Integer>) queue).contains(99));

        System.out.println("Size: " + ((LinkedQueue2<Integer>) queue).size());

        queue.clear();
        ((LinkedQueue2<Integer>) queue).display();
        System.out.println("Boş mu? " + queue.isEmpty());
    }
}
