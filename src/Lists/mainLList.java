package Lists;

public class mainLList {
    public static void main(String[] args) {
        ListInterface<String> names = new LList<>();

        // Sona ekleme (tail ile O(1))
        names.add("Ali");
        names.add("Burak");
        names.add("Deniz");

        System.out.println("Başlangıç (LinkedList): " + names);

        // Başa ekleme (pointer güncelleme)
        names.add(1, "Ayşe");
        System.out.println("Başa 'Ayşe' ekle:      " + names);

        // Araya ekleme (pointer güncelleme)
        names.add(3, "Cem");
        System.out.println("3. pozisyona 'Cem':     " + names);

        // Değiştirme
        names.replace(2, "Buse");
        System.out.println("2. pozisyonu 'Buse':    " + names);

        // Silme: baştan
        String removed1 = names.remove(1);
        System.out.println("Baştan sil (" + removed1 + "):      " + names);

        // Silme: sondan
        String removed2 = names.remove(names.getLength());
        System.out.println("Sondan sil (" + removed2 + "):      " + names);

        // Aradan silme
        String removed3 = names.remove(2);
        System.out.println("2. pozisyondan sil (" + removed3 + "): " + names);

        // Sorgular
        System.out.println("Contains 'Deniz'? " + names.contains("Deniz"));
        System.out.println("Uzunluk: " + names.getLength());
        System.out.println("Boş mu? " + names.isEmpty());
    }
}