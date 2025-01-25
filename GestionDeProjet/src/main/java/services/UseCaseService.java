package services;

import Entities.UseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Repository.UseCaseRepository;

@Service
public class UseCaseService {
	private final UseCaseRepository useCaseRepository;

    public UseCaseService(UseCaseRepository useCaseRepository) {
        this.useCaseRepository = useCaseRepository;
    }

    public List<UseCase> getAllUseCases() {
        return useCaseRepository.findAll();
    }

    public Optional<UseCase> getUseCaseById(Long id) {
        return useCaseRepository.findById(id);
    }

    public UseCase saveUseCase(UseCase useCase) {
        return useCaseRepository.save(useCase);
    }

    public void deleteUseCase(Long id) {
        useCaseRepository.deleteById(id);
    }
}
