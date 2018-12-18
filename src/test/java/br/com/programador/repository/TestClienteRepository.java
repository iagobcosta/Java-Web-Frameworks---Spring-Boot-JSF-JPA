package br.com.programador.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.programador.modulo.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestClienteRepository {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar() {
		Cliente cliente = new Cliente("iago", "iago@iago.com");
		Cliente cliSalvo = clienteRepository.save(cliente);
		Assert.assertNotNull(cliSalvo.getId());
	}
	
	@Test
	public void testBuscarTodos() {
		
		Cliente cliente1 = new Cliente("iago", "iago@iago.com");
		entityManager.persist(cliente1);
		
		Cliente cliente2 = new Cliente("eliane", "eliane@iago.com");
		entityManager.persist(cliente2);
		
		List<Cliente> lista = clienteRepository.buscarTodos();
		
		assertThat(lista.get(0).getNome()).isEqualTo(cliente1.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cliente2.getNome());
		
		
	}

}
