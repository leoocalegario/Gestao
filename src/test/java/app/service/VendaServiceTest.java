package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;
import jakarta.validation.ValidationException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VendaServiceTest {

	@Test
	@DisplayName("[Teste] Salvar")
	void testSave() {
		Venda venda = new Venda();
		venda.setEndereco("Rua Araguaia");
		venda.setVt(100);
		
		when(repository.save(any(Venda.class))).thenReturn(venda);
		
		String resultado = vendaService.save(venda);
		verify(repository, times(1)).save(venda);
		assertNotNull("Vendas salva com sucesso", resultado);
	}
	
	@Test
	@DisplayName("[Exception] Salvar - Endereco Nulo")
	void testSaveException() {
		assertThrows(NullPointerException.class, ()->{
			vendaService.save(null);
		});
	}
	
	
	//-------------------------------------------------------------------------
	//FindById ----------------------------------------------------------------
	//-------------------------------------------------------------------------
	
	@Test
	@DisplayName("[Teste] Find by Id")
	void findById() {
		Venda value = new Venda();
		value.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(value));
		
		Venda byId = vendaService.findById(1L);
		
		assertEquals(1L, byId.getId());
		assertEquals(value,byId);
		assertNotNull(byId);
	}
	
	@Test
	@DisplayName("[Exception] Find by Id")
	void findByIDException() {
		when(repository.findById(1L)).thenReturn(Optional.empty());
		
		assertThrows(RuntimeException.class, () ->{
			vendaService.findById(1L);
		});
	}
	
	//-------------------------------------------------------------------------
	//Delete ------------------------------------------------------------------
	//-------------------------------------------------------------------------
	
	@Test
	@DisplayName("[Teste] Delete")
	void TestDelete() {
		vendaService.delete(1L);
		verify(repository, times(1)).deleteById(1L);
	}
	
	@Test
	@DisplayName("[Exception] Delete - ID nulo")
	void TestDeleteIdNulo() {
		doThrow(IllegalArgumentException.class).when(repository).deleteById(null);
		assertThrows(Exception.class, () ->{
			vendaService.delete(null);
		});

		verify(repository, times(1)).deleteById(any());
	}

	
	@Test
	@DisplayName("[Teste] Calcular Valor Total")
	void calcularValorTotal() {
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(1L,"JBL",25,"Eletronico"));
		produtos.add(new Produto(1L,"IPHONE",25,"Eletronico"));
		produtos.add(new Produto(1L,"SAPATO",25,"Roupa"));
		produtos.add(new Produto(1L,"CAMISA",25,"Roupa"));
		
		double result = vendaService.calcularValorTotal(produtos);
		assertEquals(100,result);
	}
	
	@Test
	@DisplayName("[Exception] Calcular valor Total")
	void calcularValorTotalNomeEmBranco() {
		List<Produto> produtos = new ArrayList<>();

		double totalValue = vendaService.calcularValorTotal(produtos);
		assertEquals(0.0, totalValue);
	}
	//-------------------------------------------------------------------------
	//VerificarStatus---------------------------------------------------------
	//-------------------------------------------------------------------------
	
	@Test
	@DisplayName("[Teste]Verificar o Status da Venda")
	void testverificarStatus() {
		Venda venda = new Venda();
		venda.setStatus("CANCELADO");
		Venda result = vendaService.verificarStatus(venda);
		
		assertEquals("CANCELADO", venda.getStatus());
		assertNull(result.getProduto());
		assertEquals(0.0,result.getVt());
	}
	
	@Test
	@DisplayName("[Exception]Verificar o Status da Venda")
	void testverificarStatusException() {
		Venda venda = new Venda();
		venda.setStatus("");
		doThrow(ValidationException.class).when(repository).save(any(Venda.class));	
		assertThrows(ValidationException.class, ()->{
			vendaService.update(venda,1L);
		});
		
	}
	
	
	
	@Mock
	private VendaRepository repository;
	
	@InjectMocks
	private VendaService vendaService;
}
