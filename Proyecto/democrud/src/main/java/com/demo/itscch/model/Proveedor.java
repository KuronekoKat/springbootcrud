package com.demo.itscch.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	private String nombreProveedor;
	private String telefonoProveedor;
	private String descripcion;
	
	public Proveedor() {
	}
	
	public Proveedor(String nombreProveedor, String telefonoProveedor, String descripcion) {
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.descripcion = descripcion;
	}
	
	
	public Proveedor(Integer idProveedor, String nombreProveedor, String telefonoProveedor, String descripcion) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.descripcion = descripcion;
	}


	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}
	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
