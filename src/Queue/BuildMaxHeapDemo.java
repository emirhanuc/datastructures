package Queue;

public class BuildMaxHeapDemo {
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // kök olarak başla
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Sol çocuk ebeveynden büyükse
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Sağ çocuk daha büyükse
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Eğer kök en büyük değilse değiştir ve alt ağacı düzenle
        if (largest != i) {
            System.out.printf("Swap %d ↔ %d%n", arr[i], arr[largest]);
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Tekrar alt ağacı düzenle
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            System.out.println("Heapify on index " + i + " value " + arr[i]);
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Başlangıç dizisi:");
        print(arr);

        buildHeap(arr);

        System.out.println("Max-Heap:");
        print(arr);
    }

    static void print(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\n");
    }
}