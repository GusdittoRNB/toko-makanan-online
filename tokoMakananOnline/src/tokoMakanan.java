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
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine(); //menggunakan satu baris baru

            switch(pilihan) {
                case 1:
                    customerLogin(input);
                    break;
                case 2:
                    System.out.print("Masukkan Password: ");
                    String password = input.nextLine();

                    if (password.equals("admin123")) {
                        cek = true;
                        adminLogin(input);
                    } else {
                        System.out.println("\nPassword Salah");
                    }
                    break;
                case 3:
                    System.out.println("\nTerima Kasih Telah Menggunakan Program Ini");
                    break;
                default:
                    System.out.println("\nMasukkan Tidak Valid, Silahkan Ulangi");
                    break;
            }
        }
    }

    //method untuk menampilkan login admin
    static void adminLogin(Scanner input){
        int pilihan = 0;

        while(pilihan != 4) {
            //tampilkan menu dari login admin
            System.out.println("\n=== Admin Login ===");
            System.out.println("1. Lihat Restaurant");
            System.out.println("2. Tambah Restaurant");
            System.out.println("3. Hapus Restaurant");
            System.out.println("4. Kembali");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.println("\n=== Daftar Restaurant ===");
                    for (String restaurantName : restaurants.keySet()) {
                        System.out.println("\n" + restaurantName + " - " + restaurants.get(restaurantName).getAddress());
                        System.out.println("Menu: ");
                        for (Menu menu : restaurants.get(restaurantName).getMenus()) {
                            System.out.println(menu.getName() + " - " + menu.getPrice());
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nMasukkan Nama Restaurant: ");
                    String name = input.nextLine();
                    System.out.print("Masukkan Alamat Restaurant: ");
                    String address = input.nextLine();

                    Restaurant newRestaurant = new Restaurant(name, address);

                    String inputMenu = "";
                    int inputHarga = 0;
                    String inputPilihan = "";

                    while (!inputPilihan.equals("n")) {
                        System.out.print("Masukkan Nama Menu: ");
                        inputMenu = input.nextLine();
                        System.out.print("Masukkan Harga Menu: ");
                        inputHarga = input.nextInt();
                        input.nextLine();

                        newRestaurant.addMenu(new Menu(inputMenu, inputHarga));

                        System.out.print("Apakah Ingin Menambah Menu Lagi? (y/n): ");
                        inputPilihan = input.nextLine();
                    }
                    restaurants.put(name, newRestaurant);
                    System.out.println("\nRestaurant Berhasil Ditambahkan");
                    break;
                case 3:
                    String inputTanya = "";
                    System.out.print("\nMasukkan Nama Restaurant: ");
                    String restaurantName = input.nextLine();
                    if(restaurants.containsKey(restaurantName)) {
                        System.out.print("Apakah Yakin Untuk Menghapusnya? (y/n): ");
                        inputTanya = input.nextLine();
                        if(inputTanya.equals("y")) {
                            restaurants.remove(restaurantName);
                            System.out.println("\nRestaurant Berhasil Dihapus");
                        }else {
                            System.out.println("\nRestaurant Tidak Berhasil Dihapus");
                        }
                    }else {
                            System.out.println("\nRestaurant Tidak Ditemukan");
                        }
                    break;
                case 4:
                    boolean cek = false;
                    break;
                default:
                    System.out.println("\nMasukkan Tidak Valid, Silahkan Ulangi");
                    break;
            }
        }
    }

    static void customerLogin(Scanner input) {
        int pilihan = 0;

        while(pilihan != 3) {
            //tampilkan menu dari login customer
            System.out.println("\n=== Customer Login ===");
            System.out.println("1. Pesan Makanan Atau Minuman");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Kembali");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch(pilihan) {
                case 1:
            }
        }
    }
}