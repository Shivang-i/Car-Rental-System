public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        rentalSystem.addCar(new Suv("C001", "Mahindra", "Thar", 150));
        rentalSystem.addCar(new Sedan("C002", "Honda", "Accord", 70));
        rentalSystem.addCar(new Hatchback("C003", "Toyota", "Yaris", 60));

        rentalSystem.menu();
    }
}
