package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entities.UseCase;
import services.UseCaseService;

@RestController
@RequestMapping("/api/usecases")
public class UseCaseController {
	 private final UseCaseService service;

	    public UseCaseController(UseCaseService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<UseCase> getAllUseCases() {
	        return service.getAllUseCases();
	    }

	    @GetMapping("/{id}")
	    public Optional<UseCase> getUseCaseById(@PathVariable Long id) {
	        return service.getUseCaseById(id);
	    }

	    @PostMapping
	    public UseCase createUseCase(@RequestBody UseCase useCase) {
	        return service.saveUseCase(useCase);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUseCase(@PathVariable Long id) {
	        service.deleteUseCase(id);
	    }
}
