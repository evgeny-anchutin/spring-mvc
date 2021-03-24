package web.service;

import web.model.Car;

import java.util.stream.Stream;

public interface CarService {
    Stream<Car> getCars();
    int getCarsCount();
}
