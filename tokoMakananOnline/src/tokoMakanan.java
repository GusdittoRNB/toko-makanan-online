import java.util.ArrayList;
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
            System.out.print("\n\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|--      PROGRAM TOKO MAKANAN ONLINE      --|\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|============[    MENU LOGIN    ]===========|\n");
            System.out.print("\t\t|             1. Customer Login             |\n");
            System.out.print("\t\t|             2. Admin Login                |\n");
            System.out.print("\t\t|             3. Exit                       |\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\tMasukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine(); //menggunakan satu baris baru

            switch(pilihan) {
                case 1:
                    customerLogin(input);
                    break;
                case 2:
                    System.out.print("\t\tMasukkan Password: ");
                    String password = input.nextLine();
                    System.out.print("\t\t+-------------------------------------------+\n");

                    if (password.equals("Admin123")) {
                        cek = true;
                        adminLogin(input);
                    } else {
                        System.out.println("\t\tPassword Salah");
                        System.out.print("\t\t+-------------------------------------------+\n");
                    }
                    break;
                case 3:
                    System.out.print("\t\t+-------------------------------------------+\n");
                    System.out.println("\t\tTerima Kasih Telah Menggunakan Program Ini");
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
                default:
                    System.out.print("\t\t+-------------------------------------------+\n");
                    System.out.println("\t\tMasukkan Tidak Valid, Silahkan Ulangi");
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
            }
        }
    }

    //method untuk menampilkan login admin
    static void adminLogin(Scanner input){
        int pilihan = 0;

        while(pilihan != 4) {
            //tampilkan menu dari login admin
            System.out.print("\n\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|--              ADMIN LOGIN              --|\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|===============[    MENU    ]==============|\n");
            System.out.print("\t\t|             1. Lihat Restaurant           |\n");
            System.out.print("\t\t|             2. Tambah Restaurant          |\n");
            System.out.print("\t\t|             3. Hapus Restaurant           |\n");
            System.out.print("\t\t|             4. Kembali                    |\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\tMasukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            System.out.print("\t\t+-------------------------------------------+\n");
            input.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.println("\n\t\t===== Daftar Restaurants =====");
                    for (String restaurantName : restaurants.keySet()) {
                        System.out.println("\n\t\t" + restaurantName + " - " + restaurants.get(restaurantName).getAddress());
                        System.out.println("\t\tMenu: ");
                        for (Menu menu : restaurants.get(restaurantName).getMenus()) {
                            System.out.println("\t\t" + menu.getName() + " - " + menu.getPrice());
                        }
                    }
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
                case 2:
                    System.out.print("\t\tMasukkan Nama Restaurant: ");
                    String name = input.nextLine();
                    if(restaurants.containsKey(name)) {
                        System.out.print("\t\t+-------------------------------------------+\n");
                        System.out.print("\t\tNama Restaurant Tersebut Sudah Digunakan");
                        System.out.print("\n\t\t+-------------------------------------------+\n");
                    } else {
                        System.out.print("\t\tMasukkan Alamat Restaurant: ");
                        String address = input.nextLine();

                        Restaurant newRestaurant = new Restaurant(name, address);

                        String inputMenu = "";
                        int inputHarga = 0;
                        String inputPilihan = "";

                        while (!inputPilihan.equals("n")) {
                            System.out.print("\t\t+-------------------------------------------+\n");
                            System.out.print("\t\tMasukkan Nama Menu: ");
                            inputMenu = input.nextLine();
                            System.out.print("\t\tMasukkan Harga Menu: ");
                            inputHarga = input.nextInt();
                            input.nextLine();

                            newRestaurant.addMenu(new Menu(inputMenu, inputHarga));

                            System.out.print("\t\tApakah Ingin Menambah Menu Lagi? (y/n): ");
                            inputPilihan = input.nextLine();
                        }
                        restaurants.put(name, newRestaurant);
                        System.out.print("\t\t+-------------------------------------------+\n");
                        System.out.println("\t\tRestaurant Berhasil Ditambahkan");
                        System.out.print("\t\t+-------------------------------------------+\n");
                    }
                    break;
                case 3:
                    String inputTanya = "";
                    System.out.print("\t\tMasukkan Nama Restaurant: ");
                    String restaurantName = input.nextLine();
                    if(restaurants.containsKey(restaurantName)) {
                        System.out.print("\t\tApakah Yakin Untuk Menghapusnya? (y/n): ");
                        inputTanya = input.nextLine();
                        System.out.print("\t\t+-------------------------------------------+\n");
                        if(inputTanya.equals("y")) {
                            restaurants.remove(restaurantName);
                            System.out.println("\t\tRestaurant Berhasil Dihapus");
                        }else {
                            System.out.println("\t\tRestaurant Tidak Berhasil Dihapus");
                        }
                    }else {
                        System.out.print("\t\t+-------------------------------------------+\n");
                        System.out.println("\t\tRestaurant Tidak Ditemukan");
                        }
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
                case 4:
                    boolean cek = false;
                    break;
                default:
                    System.out.println("\t\tMasukkan Tidak Valid, Silahkan Ulangi");
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
            }
        }
    }

    static void customerLogin(Scanner input) {
        int pilihan = 0;
        ArrayList<Order> orders = new ArrayList<>();

        System.out.print("\t\tMasukkan Nama Anda: ");
        String namaPelanggan = input.nextLine();
        System.out.print("\t\t+-------------------------------------------+\n");
        System.out.print("\n\t\t|=======[   SELAMAT DATANG " + namaPelanggan + "   ]=======|\n");

        while(pilihan != 3) {
            //tampilkan menu dari login customer
            System.out.print("\n\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|--             CUSTOMER LOGIN            --|\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\t|===============[    MENU    ]==============|\n");
            System.out.print("\t\t|       1. Pesan Makanan Atau Minuman       |\n");
            System.out.print("\t\t|       2. Lihat Pesanan                    |\n");
            System.out.print("\t\t|       3. Kembali                          |\n");
            System.out.print("\t\t+-------------------------------------------+\n");
            System.out.print("\t\tMasukkan Pilihan Anda: ");
            pilihan = input.nextInt();
            System.out.print("\t\t+-------------------------------------------+\n");
            input.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.print("\n\t\t|============[   RESTAURANTS   ]============|\n");
                    for (String restaurantName : restaurants.keySet()) {
                        System.out.println("\t\t" + restaurantName + " - " + restaurants.get(restaurantName).getAddress());
                    }
                    System.out.print("\t\t+-------------------------------------------+\n");
                    System.out.print("\t\tMasukkan Nama Restaurant: ");
                    String restaurantName = input.nextLine();
                    System.out.print("\t\t+-------------------------------------------+\n");
                    if (!restaurants.containsKey(restaurantName)) {
                        System.out.println("\t\tRestaurant Tersebut Tidak Terdaftar");
                        System.out.print("\t\t+-------------------------------------------+\n");
                        break;
                    }

                    Restaurant restaurant = restaurants.get(restaurantName);
                    Order newOrder = new Order(restaurant);

                    String inputTambah = "";
                    while (!inputTambah.equals("n")) {
                        System.out.println("\n\t\t===== " + restaurant.getName() + " =====");
                        System.out.println("\t\tMenu:");
                        int nomorMenu = 1;
                        for (Menu menu : restaurant.getMenus()) {
                            System.out.println("\t\t" + nomorMenu + ". " + menu.getName() + " - " + menu.getPrice());
                            nomorMenu++;
                        }
                        System.out.print("\t\t+-------------------------------------------+\n");
                        System.out.print("\t\tMasukkan Nomor Menu Yang Akan Dipesan: ");
                        int indexMenu = input.nextInt();
                        System.out.print("\t\tMasukkan Jumlahnya: ");
                        int jumlah = input.nextInt();
                        input.nextLine();

                        newOrder.addMenu(restaurant.getMenus().get(indexMenu - 1), jumlah);

                        System.out.print("\t\tApakah Ingin Menambah Pesanan Lagi? (y/n): ");
                        inputTambah = input.nextLine();
                    }

                    System.out.print("\t\tMasukkan Jarak Dengan Restaurant (dalam km): ");
                    int jarak = input.nextInt();

                    newOrder.setDistance(jarak);
                    orders.add(newOrder);
                    System.out.print("\t\t+-------------------------------------------+\n");
                    System.out.println("\t\tPesanan " + namaPelanggan + " Berhasil Diorder");
                    System.out.print("\t\t+-------------------------------------------+\n");
                    break;
                case 2:
                    System.out.println("\n\t\t======= Orderan " + namaPelanggan + " =======");
                    for (int i = 0; i < orders.size(); i++) {
                        Order order = orders.get(i);
                        System.out.println("\n\t\t" + (i + 1) + ". " + order.getRestaurant().getName());
                        System.out.println("\t\tMenu:");
                        for (Menu menu : order.getMenus().keySet()) {
                            System.out.println("\t\t" + menu.getName() + " x " + order.getMenus().get(menu));
                        }
                        System.out.println("\t\tJarak (ongkir: 5000/km): " + order.getDistance() + " km");
                        System.out.println("\t\tTotal Harga: " + order.getTotalPrice());
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\t\tMasukkan Tidak Valid, Silahkan Ulangi");
                    System.out.print("\t\t+-------------------------------------------+\n");
            }
        }
    }

}