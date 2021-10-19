package com.demo.itscch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.itscch.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
	
	public Proveedor findByNombreProveedor (String nombreProveedor);

}
