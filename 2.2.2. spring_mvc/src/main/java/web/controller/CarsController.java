package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    private List<Car> cars;

    public CarsController() {
        cars = new ArrayList<>();
        cars.add(new Car("Lada", 100, "white"));
        cars.add(new Car("Fiat", 90, "red"));
        cars.add(new Car("Ford", 105, "black"));
        cars.add(new Car("Mini", 120, "yellow"));
        cars.add(new Car("Kamaz", 250, "blue"));
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(name = "count", required = false) Optional<Integer> count) {
        int carsCount = count.orElse(cars.size());
        List<Car> carList = cars.stream().limit(carsCount).collect(Collectors.toList());
        model.addAttribute("cars", carList);
        return "cars";
    }

    @GetMapping(value = "/cars/count")
    @ResponseBody
    public String printCars(ModelMap model) {
        return "" + cars.size();
    }

}