import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        boolean isOpen = false;
        if (this.getCurrentTime().isAfter(this.openingTime) && this.getCurrentTime().isBefore(this.closingTime)){
            System.out.print("Between opening time and closing time.");
            isOpen = true;
        }
        else if(this.getCurrentTime().isBefore(this.openingTime)){
            System.out.print("Before opening time.");
            isOpen = false;
        }
        else if(this.getCurrentTime().isAfter(this.closingTime)){
            System.out.print("After closing time.");
            isOpen = false;
        }

        return isOpen;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return this.menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        this.menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        this.menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ this.name + "\n"
                +"Location:"+ this.location + "\n"
                +"Opening time:"+ this.openingTime +"\n"
                +"Closing time:"+ this.closingTime +"\n"
                +"Menu:"+"\n"+this.getMenu());

    }

    public String getName() {
        return name;
    }

}
