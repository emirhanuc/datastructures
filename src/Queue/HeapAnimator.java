package Queue;

import java.util.Arrays;

public class HeapAnimator {

    // === Animasyon ayarları ===
    private static final long SLEEP_MS = 400;      // kareler arası bekleme (ms)
    private static final boolean CLEAR_BETWEEN_FRAMES = true; // her karede ekranı boşalt

    // === Demo ===
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4, 10, 3, 5, 1, 12, 6, 14, 2};
        title("BAŞLANGIÇ DİZİSİ");
        printFrame(arr, -1, -1, "Başlangıç");
        sleep();

        title("BUILD-MAX-HEAP (AŞAĞIDAN YUKARI)");
        buildMaxHeapAnimated(arr);

        title("INSERT (ekleme) animasyonu: +15, +7");
        arr = insertAnimated(arr, 15);
        arr = insertAnimated(arr, 7);

        title("EXTRACT-MAX (kökü alma) animasyonu: 2 kez");
        arr = extractMaxAnimated(arr);
        arr = extractMaxAnimated(arr);

        title("BİTİŞ");
        printFrame(arr, -1, -1, "Son durum");
    }

    // =======================
    //    BUILD-HEAP (O(n))
    // =======================
    public static void buildMaxHeapAnimated(int[] a) throws InterruptedException {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            printFrame(a, i, -1, "Heapify-down başlıyor @ index " + i + " (değer " + a[i] + ")");
            heapifyDownAnimated(a, n, i);
        }
        printFrame(a, -1, -1, "Max-Heap tamamlandı");
    }

    // =====================================
    //    HEAPIFY-DOWN (percolate-down)
    // =====================================
    private static void heapifyDownAnimated(int[] a, int heapSize, int i) throws InterruptedException {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heapSize && a[left] > a[largest]) largest = left;
            if (right < heapSize && a[right] > a[largest]) largest = right;

            if (largest != i) {
                printFrame(a, i, largest, "Swap " + a[i] + " ↔ " + a[largest]);
                swap(a, i, largest);
                i = largest;
            } else {
                printFrame(a, i, -1, "Heapify-down bitti @ index " + i);
                break;
            }
        }
    }

    // =====================================
    //    HEAPIFY-UP (percolate-up)
    // =====================================
    private static void heapifyUpAnimated(int[] a, int i) throws InterruptedException {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (a[i] > a[parent]) {
                printFrame(a, i, parent, "Swap " + a[i] + " ↔ " + a[parent]);
                swap(a, i, parent);
                i = parent;
            } else {
                printFrame(a, i, parent, "Yerinde (ebeveynden küçük değil)");
                break;
            }
        }
    }

    // =====================
    //      INSERT (max)
    // =====================
    public static int[] insertAnimated(int[] a, int val) throws InterruptedException {
        int[] b = Arrays.copyOf(a, a.length + 1);
        b[b.length - 1] = val;
        printFrame(b, b.length - 1, -1, "Ekle: " + val + " (sona eklendi)");
        heapifyUpAnimated(b, b.length - 1);
        printFrame(b, -1, -1, "Insert tamam");
        return b;
    }

    // ===========================
    //    EXTRACT-MAX (remove root)
    // ===========================
    public static int[] extractMaxAnimated(int[] a) throws InterruptedException {
        if (a.length == 0) return a;
        int max = a[0];
        printFrame(a, 0, a.length - 1, "Extract-Max: kök " + max + " çıkarılacak; son eleman köke taşınır");
        a[0] = a[a.length - 1];
        int[] b = Arrays.copyOf(a, a.length - 1);
        if (b.length > 0) {
            printFrame(b, 0, -1, "Kök güncellendi, heapify-down başlayacak");
            heapifyDownAnimated(b, b.length, 0);
        }
        printFrame(b, -1, -1, "Extract-Max tamam (çıkan: " + max + ")");
        return b;
    }

    // ======================
    //     Yardımcılar
    // ======================
    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(SLEEP_MS);
    }

    private static void title(String s) throws InterruptedException {
        if (CLEAR_BETWEEN_FRAMES) clear();
        System.out.println("==================================================");
        System.out.println(" " + s);
        System.out.println("==================================================");
        sleep();
    }

    private static void printFrame(int[] a, int hi1, int hi2, String msg) throws InterruptedException {
        if (CLEAR_BETWEEN_FRAMES) clear();
        System.out.println("[AÇIKLAMA] " + msg);
        System.out.println();
        printArray(a, hi1, hi2);
        System.out.println();
        printTreePretty(a, hi1, hi2);
        sleep();
    }

    // Diziyi (seçili indeksleri vurgulayarak) göster
    private static void printArray(int[] a, int hi1, int hi2) {
        System.out.println("Dizi (level-order):");
        for (int i = 0; i < a.length; i++) {
            boolean h = (i == hi1 || i == hi2);
            String cell = h ? "[" + a[i] + "]" : " " + a[i] + " ";
            System.out.print(cell);
            if (i < a.length - 1) System.out.print("  ");
        }
        System.out.println();
    }

    // Ağacı seviyeler halinde, basit boşluklandırmayla yazdır
    private static void printTreePretty(int[] a, int hi1, int hi2) {
        System.out.println("Ağaç görünümü (root üstte):");
        int n = a.length;
        if (n == 0) { System.out.println("(boş)"); return; }

        int h = (int) Math.floor(Math.log(n) / Math.log(2)) + 1; // yaklaşık yükseklik
        int idx = 0;

        for (int level = 0; level < h; level++) {
            int nodesAtLevel = Math.min((1 << level), n - idx);
            // basit boşluklandırma
            int leading = (1 << (h - level)) - 1;
            printSpaces(leading / 2);

            for (int k = 0; k < nodesAtLevel; k++) {
                boolean hi = (idx == hi1 || idx == hi2);
                String s = hi ? "[" + a[idx] + "]" : String.valueOf(a[idx]);
                System.out.printf("%s", padCenter(s, 3));
                idx++;
                int between = (1 << (h - level + 0)) - 1;
                if (k != nodesAtLevel - 1) printSpaces(between);
            }
            System.out.println();
            if (idx >= n) break;
        }
    }

    private static void printSpaces(int c) {
        for (int i = 0; i < c; i++) System.out.print(" ");
    }

    private static String padCenter(String s, int width) {
        if (s.length() >= width) return s;
        int left = (width - s.length()) / 2;
        int right = width - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    // Platform bağımsız "temizleme": çok satır boş yaz (ANSI ile uğraşmadan)
    private static void clear() {
        System.out.print("\n".repeat(20));
    }
}
