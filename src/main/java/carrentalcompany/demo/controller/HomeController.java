package carrentalcompany.demo.controller;


import carrentalcompany.demo.model.dtos.VehicleDtos;
import carrentalcompany.demo.service.CarTypesService;
import carrentalcompany.demo.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    private VehicleService vehicleService;
    private CarTypesService carTypesService;

    public HomeController(VehicleService vehicleService, CarTypesService carTypesService) {
        this.vehicleService = vehicleService;
        this.carTypesService = carTypesService;
    }

    @RequestMapping(value = "home")
    public String getHomePage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        return "index";
    }

    @RequestMapping(value = "vehicles", method = RequestMethod.GET)
    public String getVehiclesPage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", vehicleService.getAllVehiclesDtos());
        model.addAttribute("type", carTypesService.getCarTypes());
        return "vehicles";
    }

    @PostMapping("add")
    public String addVehicle(@Valid @ModelAttribute VehicleDtos car) {

        System.out.println(car.toString());

        vehicleService.addVehicle(car);

        return "redirect:/vehicles";
    }


}
