import java.util.HashMap;
import java.util.Scanner;

public class tokoMakanan {

    static HashMap<String, Restaurant> restaurants = new HashMap<>();

    public static void main(String[] args) {
        //inisialisasi data restaurant
        Restaurant restaurant1 = new Restaurant("Robert", "Jl. Raya Kampus Unud");
        restaurant1.addMenu(new Menu("Ayam Geprek", 10000));
        restaurant1.addMenu(new Menu("Nasi Campur", 12000));
        restaurant1.addMenu(new Menu("Lalapan", 17000));
        restaurant1.addMenu(new Menu("Es Teh", 5000));
        restaurant1.addMenu(new Menu("Es Jeruk", 5000));
        restaurant1.addMenu(new Menu("Aqua", 5000));

        Restaurant restaurant2 = new Restaurant("Puspa", "Jl. Raya Goa Gong");
        restaurant2.addMenu(new Menu("Nasi Campur Ayam", 15000));
        restaurant2.addMenu(new Menu("Nasi Campur Babi", 15000));
        restaurant2.addMenu(new Menu("Siobak", 20000));
        restaurant2.addMenu(new Menu("Es Teh", 5000));
        restaurant2.addMenu(new Menu("Es Jeruk", 5000));
        restaurant2.addMenu(new Menu("Aqua", 5000));

        Restaurant restaurant3 = new Restaurant("Cemeng", "Jl. Raya Uluwatu");
        restaurant3.addMenu(new Menu("Nasi Campur", 15000));
        restaurant3.addMenu(new Menu("Nasi Campur Tanpa Sayur", 15000));
        restaurant3.addMenu(new Menu("Sate", 15000));
        restaurant3.addMenu(new Menu("Es Teh", 5000));
        restaurant3.addMenu(new Menu("Es Jeruk", 5000));
        restaurant3.addMenu(new Menu("Aqua", 5000));

        //menambahkan restaurant ke dalam hashmap
        restaurants.put("Robert", restaurant1);
        restaurants.put("Puspa", restaurant2);
        restaurants.put("Cemeng", restaurant3);

        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        boolean cek = false;

        while(pilihan != 3) {
            //tampilan menu utama
            System.out.println("\n=== Toko Makanan Online ===");
            System.out.println("1. Customer Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine(); //pindah baris atau enter

            switch(pilihan) {
                case 1:
                    //customerLogin(input);
                    break;
                case 2:
                    System.out.print("Masukkan password: ");
                    String password = input.nextLine();

                    if (password.equals("admin123")) {
                        cek = true;
                        //adminLogin(input);
                    } else {
                        System.out.println("Password Salah");
                    }
                    break;
                case 3:
                    System.out.println("Terima Kasih Telah Menggunakan Program Ini");
                    break;
                default:
                    System.out.println("Masukkan Tidak Valid, Silahkan Ulangi");
                    break;
            }
        }
    }
}