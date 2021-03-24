package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarService {

    private static CarService instance = null;
    private List<Car> cars;

    private CarService() {

        cars = new ArrayList<>();
        cars.add(new Car("Lada", 100, "white"));
        cars.add(new Car("Fiat", 90, "red"));
        cars.add(new Car("Ford", 105, "black"));
        cars.add(new Car("Mini", 120, "yellow"));
        cars.add(new Car("Kamaz", 250, "blue"));
    }

    public Stream<Car> getCars() {
        return cars.stream();
    }

    public int getCarsCount() {
        return cars.size();
    }

    public static CarService getService() {
        if (instance == null) {
            instance = new CarService();
        }
        return instance;
    }
}
