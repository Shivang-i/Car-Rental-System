//inheritance
class Suv extends Car {
    private double basePrice;

    Suv(String carId, String brand, String model,double basePrice ) {
        super(carId, brand, model);
        this.basePrice=basePrice;
    }

    @Override
    public double calculatePrice(int rentalDays) {
        return rentalDays * basePrice + 100;//suv extra charge
    }
}
