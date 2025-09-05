//abstract class(Data Abstraction)
abstract class Car {
   //Encapsulation
   private String carId;
    private String brand;
    private String model;
    private boolean isAvailable;
    
    Car(String carId,String brand,String model){
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.isAvailable=true;
    }

    public abstract double calculatePrice(int rentalDays);//abstraction+polymorphism

    //getter methord

    public String getCarId() 
    {
         return carId; 
    }
    public String getBrand() 
    {
         return brand; 
    }
    public String getModel() 
    { 
        return model; 
    }
    public boolean isAvailable() 
    {
         return isAvailable;
    }
    //rent the car
    public void rent() { 
        isAvailable = false; 
    }
    //return car 
    public void returnCar() {
         isAvailable = true; 
        }

}
