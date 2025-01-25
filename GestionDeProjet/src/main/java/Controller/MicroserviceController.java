package Controller;
import Entities.Microservice;
import services.MicroserviceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/microservices")
public class MicroserviceController {
	private final MicroserviceService service;

    public MicroserviceController(MicroserviceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Microservice> getAllMicroservices() {
        return service.getAllMicroservices();
    }

    @GetMapping("/{id}")
    public Optional<Microservice> getMicroserviceById(@PathVariable Long id) {
        return service.getMicroserviceById(id);
    }

    @PostMapping
    public Microservice createMicroservice(@RequestBody Microservice microservice) {
        return service.saveMicroservice(microservice);
    }

    @DeleteMapping("/{id}")
    public void deleteMicroservice(@PathVariable Long id) {
        service.deleteMicroservice(id);
    }

}
