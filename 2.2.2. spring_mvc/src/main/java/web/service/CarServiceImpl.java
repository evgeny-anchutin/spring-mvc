package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    public CarServiceImpl() {

        cars = new ArrayList<>();
        cars.add(new Car("Lada", 100, "white"));
        cars.add(new Car("Fiat", 90, "red"));
        cars.add(new Car("Ford", 105, "black"));
        cars.add(new Car("Mini", 120, "yellow"));
        cars.add(new Car("Kamaz", 250, "blue"));
    }

    @Override
    public Stream<Car> getCars() {
        return cars.stream();
    }

    @Override
    public int getCarsCount() {
        return cars.size();
    }

}
