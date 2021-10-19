package com.demo.itscch.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.itscch.model.Proveedor;
import com.demo.itscch.repository.ProveedorRepository;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	private final ProveedorRepository proveedorRepository;
	
	public ProveedorController(ProveedorRepository proveedorRepository) {
		this.proveedorRepository = proveedorRepository;
	}
	
	@GetMapping
	public List<Proveedor> getProveedores(){
		return proveedorRepository.findAll();
	}

}
