package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Car;
import web.service.CarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    private CarService service;

    public CarsController() {
        service = CarService.getService();
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(name = "count", required = false) Optional<Integer> count) {
        int carsCount = count.orElse(service.getCarsCount());
        List<Car> carList = service.getCars().limit(carsCount).collect(Collectors.toList());
        model.addAttribute("cars", carList);
        return "cars";
    }

    @GetMapping(value = "/cars/count")
    @ResponseBody
    public String printCars(ModelMap model) {
        return "" + service.getCarsCount();
    }

}