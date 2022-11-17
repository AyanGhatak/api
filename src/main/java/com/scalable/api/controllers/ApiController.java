package com.scalable.api.controllers;

import com.scalable.api.models.Medicines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApiController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello from Api Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/{id}")
    public Medicines getMedicines(@PathVariable final int id) {
        Medicines medicines = new Medicines();
        medicines.setId(id);
        List<Object> medicineList = restTemplate.getForObject("http://medicine-service/medicines/", List.class);
        medicines.setMedicines(medicineList);
        return medicines;
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Api service running at port: " + env.getProperty("local.server.port");
    }
}
