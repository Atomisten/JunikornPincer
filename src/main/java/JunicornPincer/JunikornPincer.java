package JunicornPincer;

import JunicornPincer.Repositories.*;

import java.sql.SQLException;
import java.util.List;

public class JunikornPincer {
    private List<Restaurant> restaurantList;
    private List<Customer> customerList;
    private int deliveryPrice;
    private List<Orders> ordersList;

    public static void main(String[] args) {

        try (AddressRepository addressRepository = new AddressRepository();
             CustomerRepository customerRepository = new CustomerRepository();
             RestaurantRepository restaurantRepository = new RestaurantRepository();
             FoodRepository foodRepository = new FoodRepository();
             OrdersRepository ordersRepository = new OrdersRepository()) {
            Address address1 = new Address("Szeged", "Kecske utca", "19");
            Customer customer1 = new Customer("A", "email", "password", "222-2222"
                    , address1);
            addressRepository.createAddressTable();
            customerRepository.createCustomerTable();
            restaurantRepository.createRestaurantTable();
            foodRepository.createFoodCategoriesTable();
            foodRepository.createFoodTable();
            ordersRepository.createOrdersTable();
            ordersRepository.createOrdersConnectorTable();
            addressRepository.insertAddress(address1);
            System.out.println(address1.getId());
            customerRepository.insertCustomer(customer1);
            System.out.println("Adress id: " + address1.getId());
            System.out.println("Customer id:" + customer1.getId());
            // System.out.println(FoodCategories.DESSZERT.ordinal() + 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
