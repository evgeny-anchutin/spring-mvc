package web.model;

public class Car {
    private String model;
    private int power;
    private String color;

    public Car(String model, int power, String color) {
        this.model = model;
        this.power = power;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", power=" + power +
                ", color='" + color + '\'' +
                '}';
    }
}
