package Teste;

import org.junit.Test;

import entities.Product;

import static org.junit.Assert.*;

public class TestProduct {
	
	@Test
	public void testDescricao() {
		Product p = new Product("Produto 1", 10.0, 1);
		assertEquals("Produto 1", p.getDescricao());
		p.setDescricao("Produto 2");
		assertEquals("Produto 2", p.getDescricao());
	}
	
	@Test
	public void testPrecoVenda() {
		Product p = new Product("Produto 1", 10.0, 1);
		p.setMargemLucro(0.5); // margem de lucro de 50%
		p.setPrecoVenda(0);
		assertEquals(14.0, p.getPrecoVenda(), 0.01); // preço de venda deve ser 14.0 com 18% de impostos
	}
	
	@Test
	public void testValorArrecadado() {
		Product p = new Product("Produto 1", 10.0, 1);
		p.setQuantidadeVendida(5);
		p.setMargemLucro(0.5); // margem de lucro de 50%
		p.setPrecoVenda(0);
		assertEquals(70.0, p.valorArrecadado(p.getDescricao(), p.getId()), 0.01); // valor arrecadado deve ser 70.0 com 18% de impostos
	}
	
	@Test
	public void testNivelEstoque() {
		Product p = new Product("Produto 1", 10.0, 1);
		p.setQuantidadeEstoque(5);
		assertEquals("Estoque crítico, contatar fornecedor", p.nivelEstoque(p.getDescricao(), p.getId())); // estoque crítico quando quantidade é menor que 10
		p.setQuantidadeEstoque(10);
		assertEquals("Estoque ok", p.nivelEstoque(p.getDescricao(), p.getId())); // estoque ok quando quantidade é maior ou igual a 10
		assertTrue(false);
	}
	
}