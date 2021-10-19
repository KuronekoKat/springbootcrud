package com.demo.itscch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class proveedores {

	private Integer idProveedor;
	private String nombreProveedor;
	private String telefonoProveedor;
	private String descripcion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
