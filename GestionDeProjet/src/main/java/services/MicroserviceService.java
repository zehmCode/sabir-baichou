package services;
import Entities.Microservice;
import Repository.MicroserviceRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicroserviceService {
	private final MicroserviceRepository repository;

    public MicroserviceService(MicroserviceRepository repository) {
        this.repository = repository;
    }

    public List<Microservice> getAllMicroservices() {
        return repository.findAll();
    }

    public Optional<Microservice> getMicroserviceById(Long id) {
        return repository.findById(id);
    }

    public Microservice saveMicroservice(Microservice microservice) {
        return repository.save(microservice);
    }

    public void deleteMicroservice(Long id) {
        repository.deleteById(id);
    }
}
