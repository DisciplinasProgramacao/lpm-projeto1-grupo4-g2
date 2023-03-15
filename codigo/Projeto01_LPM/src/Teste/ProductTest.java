package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import entities.Product;

public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product("Camisa", 50.0, 1);
	}

	@Test
	public void testGetDescricao() {
		assertEquals("Camisa", product.getDescricao());
	}

	@Test
	public void testSetDescricao() {
		product.setDescricao("Calça");
		assertEquals("Calça", product.getDescricao());
	}

	@Test
	public void testSetDescricaoInvalida() {
		product.setDescricao("aa");
		assertNull(product.getDescricao());
	}

	@Test
	public void testGetPrecoCusto() {
		assertEquals(50.0, product.getPrecoCusto(), 0.0);
	}

	@Test
	public void testSetPrecoCusto() {
		product.setPrecoCusto(60.0);
		assertEquals(60.0, product.getPrecoCusto(), 0.0);
	}

	@Test
	public void testGetPrecoVenda() {
		assertEquals(84.0, product.getPrecoVenda(), 0.0);
	}

	@Test
	public void testSetMargemLucro() {
		product.setMargemLucro(50.0);
		assertEquals(75.0, product.getMargemLucro(0), 0.0);
		assertEquals(112.5, product.getPrecoVenda(), 0.0);
	}

	@Test
	public void testGetQuantidadeEstoque() {
		assertEquals(0, product.getQuantidadeEstoque());
	}

	@Test
	public void testSetQuantidadeEstoque() {
		product.setQuantidadeEstoque(10);
		assertEquals(10, product.getQuantidadeEstoque());
	}

	@Test
	public void testGetQuantidadeVendida() {
		assertEquals(0, product.getQuantidadeVendida());
	}

	@Test
	public void testSetQuantidadeVendida() {
		product.setQuantidadeVendida(5);
		assertEquals(5, product.getQuantidadeVendida());
	}

	@Test
	public void testGetCustoAquisicao() {
		assertEquals(0.0, product.getCustoAquisicao(), 0.0);
	}

	@Test
	public void testSetCustoAquisicao() {
		product.setCustoAquisicao(500.0);
		assertEquals(500.0, product.getCustoAquisicao(), 0.0);
	}

	@Test
	public void testValorArrecadado() {
		product.setPrecoVenda(100.0);
		product.setQuantidadeVendida(2);
		assertEquals(200.0, product.valorArrecadado("Camisa", 1), 0.0);
	}

	@Test
	public void testValorGasto() {
		product.setQuantidadeEstoque(10);
		assertEquals(500.0, product.valorGasto("Camisa", 1), 0.0);
	}

	@Test
	public void testNivelEstoqueCritico() {
		product.setQuantidadeEstoque(5);
		assertEquals("Estoque crítico, contatar fornecedor", product.nivelEstoque("Camisa", 1));
	}

	@Test
	public void testNivelEstoqueOk() {
		product.setQuantidadeEstoque(15);
		assertEquals("Estoque ok", product.nivelEstoque("Camisa", 1));
	}

}
