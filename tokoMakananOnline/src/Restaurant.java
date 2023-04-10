import java.util.ArrayList;

class Restaurant {
    private String name;
    private String address;
    private ArrayList<Menu> menus;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.menus = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Menu> getMenus() {
        return this.menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }
}
