package com.example.mss1;

import com.example.mss1.model.Veiculo;
import com.example.mss1.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VehicleRepository repository;

    public VeiculoService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> getAll() {
        return repository.findAll();
    }

    public Veiculo create(Veiculo vehicle) {
        return repository.save(vehicle);
    }

    public Veiculo update(Long id, Veiculo vehicle) {
        vehicle.setId(id);
        return repository.save(vehicle);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Veiculo> getById(Long id) {
        return repository.findById(id);
    }
}
