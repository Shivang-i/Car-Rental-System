import java.util.*;
public class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) { 
        cars.add(car);
     }
    public void addCustomer(Customer customer) { 
        customers.add(customer);
     }

     public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        rentals.removeIf(r -> r.getCar() == car);
        System.out.println("Car returned successfully!");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Available Cars:");
                for (Car car : cars) {
                    if (car.isAvailable())
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                }
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter car ID: ");
                String carId = scanner.nextLine();
                System.out.print("Enter rental days: ");
                int days = scanner.nextInt();
                scanner.nextLine();

                Car selectedCar = null;
                for (Car car : cars)
                    if (car.getCarId().equalsIgnoreCase(carId) && car.isAvailable()) selectedCar = car;

                if (selectedCar != null) {
                    Customer customer = new Customer("C" + (customers.size() + 1), name);
                    addCustomer(customer);
                    rentCar(selectedCar, customer, days);
                    System.out.printf("Total price: $%.2f%n", selectedCar.calculatePrice(days));
                } 
                else 
                System.out.println("Invalid or unavailable car.");
            }
             else if (choice == 3) {
                System.out.print("Enter car ID to return: ");
                String carId = scanner.nextLine();
                Car carToReturn = null;
                for (Car car : cars) if (car.getCarId().equalsIgnoreCase(carId) && !car.isAvailable()) carToReturn = car;

                if (carToReturn != null)
                 returnCar(carToReturn);
                else 
                System.out.println("Invalid car ID or car is not rented.");
            } 
            else if (choice == 4)
             break;
            else System.out.println("Invalid choice.");
        }
        System.out.println("Thanks for using Car Rental System!");
        scanner.close();
    }
}
