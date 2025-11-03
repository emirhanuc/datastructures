package Queue;

public class LinkedQueue2 <T> implements QueueInterface<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    public LinkedQueue2(){
        front = null;
        rear = null;
        size = 0;
    }
    @Override
    public void enqueue(T newEntry){
        Node<T> newNode = new Node<>(newEntry);
        if(rear==null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(newEntry + " kuyruğa eklendi.");
    }
    @Override
    public T dequeue(){
        if (isEmpty()){
            System.out.println("Kuyruk boş, dequeue işlemi başarısız.");
            return null;
        }
        T removedData = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        System.out.println(removedData + " kuyruktan çıkarıldı.");
        return removedData;
    }
    public T getFront(){
        if (isEmpty()){
            System.out.println("Kuyruk boş, ön eleman yok.");
            return null;
        }
        return front.data;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void clear(){
        Node<T> current = front;
        while (current != null){
            Node<T> next = current.next;
            current.next =null;
            current = next;
        }
        front =rear = null;
        size =0;
        System.out.println("Kuyruk temizlendi.");
    }
    public int size(){
        return size;
    }
    public boolean contains(T key){
        Node<T> cur = front;;
        while (cur != null){
            if((key == null && cur.data == null )||(key != null && key.equals(cur.data))){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void display(){
        if (isEmpty()){
            System.out.println("Kuyruk boş!");
            return;
        }
        Node<T> cur = front;
        System.out.print("Front → ");
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println("← Rear");
    }
}
