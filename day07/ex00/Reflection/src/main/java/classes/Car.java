package classes;


public class Car {
    private String Model;
    private int year;
    private String color;
    private boolean transmission_auto;

    public Car(String model, int year, String color, boolean transmission_auto) {
        this.Model = model;
        this.year = year;
        this.color = color;
        this.transmission_auto = transmission_auto;
    }

    public Car() {
        this.Model = "Default";
        this.year = 2000;
        this.color = "Default";
        this.transmission_auto = false;
    }

    public int repair(String color, int year)
    {
        this.year = this.year + year;
        this.color = color;
        return this.year;
    }

    @Override
    public String toString() {
        return  " Model: " + Model +
                ", year: " + year +
                ", color: " + color +
                ", transmission_auto: " + transmission_auto;
    }
}
