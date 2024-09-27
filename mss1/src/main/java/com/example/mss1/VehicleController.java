package com.example.mss1.controller;

import com.example.mss1.model.Veiculo;
import com.example.mss1.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VeiculoService veiculoService;

    public VehicleController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> getAll() {
        return veiculoService.getAll();
    }

    @PostMapping
    public Veiculo create(@RequestBody Veiculo vehicle) {
        return veiculoService.create(vehicle);
    }

    @PutMapping("/{id}")
    public Veiculo update(@PathVariable Long id, @RequestBody Veiculo vehicle) {
        return veiculoService.update(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        veiculoService.delete(id);
    }
}
