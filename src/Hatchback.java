 class Hatchback extends Car {
    private double basePrice;

    Hatchback(String carId, String brand, String model,double basePrice ) {
        super(carId, brand, model);
        this.basePrice=basePrice;
    }

    @Override
    public double calculatePrice(int rentalDays) {
        return rentalDays * basePrice ;
    }
}

