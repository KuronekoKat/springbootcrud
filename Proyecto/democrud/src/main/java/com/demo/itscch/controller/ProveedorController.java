package com.demo.itscch.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

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
		System.out.println("Llamada a GetProveedores");
		return proveedorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Proveedor getProveedor(@PathVariable Integer id) {
		System.out.println("Llamada a GetProveedor por ID "+id);
	return proveedorRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity createProveedor(@RequestBody Proveedor proveedor) throws URISyntaxException{
		System.out.println("Llamada a crear proveedor");
		Proveedor savedProveedor = proveedorRepository.save(proveedor);
		return ResponseEntity.created(new URI("/proveedores/"+savedProveedor.getIdProveedor())).body(savedProveedor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
		System.out.println("Llamada a actualizar proveedor");
		proveedor.setIdProveedor(id);
		Proveedor currentProveedor = proveedorRepository.saveAndFlush(proveedor);
		return ResponseEntity.ok(currentProveedor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProveedor(@PathVariable Integer id) {
		System.out.println("Llamada a borrar proveedor");
		proveedorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}

