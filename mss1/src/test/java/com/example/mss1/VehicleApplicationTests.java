package com.example.mss1;


import com.example.mss1.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private VeiculoService veiculoService;

	@InjectMocks
	private com.example.mss1.controller.VehicleController vehicleController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllVehicles() throws Exception {
		List<Veiculo> vehicles = Arrays.asList(new Veiculo(1L, "Fusca", "Volkswagen"));
		when(veiculoService.getAll()).thenReturn(vehicles);

		mockMvc.perform(get("/vehicles"))
				.andExpect(status().isOk());
	}

	@Test
	void testCreateVehicle() throws Exception {
		Veiculo vehicle = new Veiculo(null, "Fusca", "Volkswagen");

		when(veiculoService.create(any(Veiculo.class))).thenReturn(new Veiculo(1L, "Fusca", "Volkswagen"));

		mockMvc.perform(post("/vehicles")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(vehicle)))
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateVehicle() throws Exception {
		Veiculo vehicle = new Veiculo(1L, "Fusca", "Volkswagen");

		when(veiculoService.update(any(Long.class), any(Veiculo.class))).thenReturn(vehicle);

		mockMvc.perform(put("/vehicles/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(vehicle)))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteVehicle() throws Exception {
		mockMvc.perform(delete("/vehicles/1"))
				.andExpect(status().isOk());
	}
}
