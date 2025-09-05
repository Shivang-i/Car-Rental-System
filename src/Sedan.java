 class Sedan extends Car {
    private double basePrice;

    Sedan(String carId, String brand, String model,double basePrice ) {
        super(carId, brand, model);
        this.basePrice=basePrice;
    }

    @Override
    public double calculatePrice(int rentalDays) {
        return rentalDays * basePrice + 150;//suv extra charge
    }
}
