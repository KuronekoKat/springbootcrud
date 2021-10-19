package com.demo.itscch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.itscch.model.Proveedor;
import com.demo.itscch.repository.ProveedorRepository;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProveedorRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Test
	public void whenSavedFoundThenReturnProveedor() {
		Proveedor prueba = new Proveedor("ProveedorPrueba", "5455555555", "Descripcion proveedor de prueba");
		em.persistAndFlush(prueba);
		
		Proveedor found = proveedorRepository.findByNombreProveedor(prueba.getNombreProveedor());
		assertThat(found.getNombreProveedor()).isEqualTo(prueba.getNombreProveedor());
	}
	
}
