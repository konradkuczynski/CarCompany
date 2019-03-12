package carrentalcompany.demo.controller;


import carrentalcompany.demo.model.dtos.CarTypesDtos;
import carrentalcompany.demo.model.dtos.VehicleDtos;
import carrentalcompany.demo.service.CarTypesService;
import carrentalcompany.demo.service.VehicleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    public String getHomePage(Model model, HttpServletRequest request, HttpServletResponse response) {
        getHeadersInfo(request,response);

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String getAdminVehiclesPage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", vehicleService.getAllVehiclesDtos());
        model.addAttribute("type", carTypesService.getCarTypes());
        return "admin";
    }

    @RequestMapping(value = "vehicles", method = RequestMethod.GET)
    public String getVehiclesPage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", vehicleService.getAllVehiclesDtos());
//        model.addAttribute("type", carTypesService.getCarTypes());
        return "vehicles";
    }

    @PostMapping("add")
    public String addVehicle(@Valid @ModelAttribute VehicleDtos car) {

        System.out.println(car.toString());

        vehicleService.addVehicle(car);

        return "redirect:/admin";
    }

    @PostMapping("update")
    public String updateVehicle(@Valid @ModelAttribute VehicleDtos car, Model model) {

        System.out.println(car.toString());

        model.addAttribute("car", car);

        return "update";
    }

    @PostMapping("upd")
    public String updVehicle(@Valid @ModelAttribute VehicleDtos car, String plate, Model model) {

        System.out.println("upd!!!");
        System.out.println(car.toString());
        model.addAttribute("car", car);
        model.addAttribute("plate", plate);
        vehicleService.updateVehicle(car, plate);

        return "redirect:/admin";
    }

    @PostMapping("delete")
    @Transactional
    public String deleteVehicle(@Valid @ModelAttribute VehicleDtos car) {

        System.out.println("delete!!!");
        System.out.println(car.toString());

        vehicleService.deleteVehicle(car);

        return "redirect:/admin";
    }

    private void getHeadersInfo(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement().toString();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        System.out.println(" * * REQUEST * * * *");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(" * * *RESPONSE * * * *");
        Collection<String> headers = response.getHeaders("");
        headers.forEach(System.out::println);
        System.out.println(" * * END * * * *");
    }

    @RequestMapping(value = "admin/type", method = RequestMethod.GET)
    public String getTypePage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
//        model.addAttribute("cars", vehicleService.getAllVehiclesDtos());
        model.addAttribute("type", carTypesService.getCarTypes());
        return "type";
    }

    @PostMapping("admin/type/add")
    public String addType(@Valid @ModelAttribute CarTypesDtos typesDtos) {

        System.out.println("add type");
        System.out.println(typesDtos.toString());

        carTypesService.addCarTypes(typesDtos);

        return "redirect:/admin/type";
    }

    @PostMapping("admin/type/update")
    public String updateType(@Valid @ModelAttribute CarTypesDtos typesDtos,  String newtype, Model model) {

        System.out.println("update type");
        System.out.println(typesDtos.toString());
        System.out.println(newtype);

        model.addAttribute("t", typesDtos);
        model.addAttribute("newtype", newtype);
        carTypesService.updateCarTypes(typesDtos, newtype);

        return "redirect:/admin/type";
    }
}



//updtype