class Car {

    String brand;
    String model;
    int year;

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

public class CarDemo {

    public static void main(String[] args) {

        Car car1 = new Car();

        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2024;

        car1.displayDetails();
    }
}