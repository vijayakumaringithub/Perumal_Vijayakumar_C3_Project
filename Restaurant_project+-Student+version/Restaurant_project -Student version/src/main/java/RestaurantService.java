import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class RestaurantService {
    private  List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException
    {
        Restaurant restaurantFound = null;
        for (Restaurant restaurant: this.restaurants) {
            if (restaurant.getName().equals(restaurantName)){
                restaurantFound = restaurant;
            }
        }
        if (restaurantFound == null)
        {
            throw new restaurantNotFoundException(restaurantName);
        }

        return restaurantFound;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        this.restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        this.restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return this.restaurants;
    }
}
