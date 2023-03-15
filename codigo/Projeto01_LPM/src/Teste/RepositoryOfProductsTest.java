package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Product;
import entities.RepositoryOfProducts;

public class RepositoryOfProductsTest {

    private RepositoryOfProducts repository;

    @Before
    public void setUp() {
        repository = new RepositoryOfProducts();
        repository.adicionarProduto("Produto 1", 10.0, 20);
        repository.adicionarProduto("Produto 2", 20.0, 30);
    }

    @Test
    public void testAdicionarProduto() {
        Product produto = repository.adicionarProduto("Produto 3", 30.0, 40);
        assertNotNull(produto);
        assertEquals("Produto 3", produto.getDescricao());
        assertEquals(30.0, produto.getPrecoCusto(), 0.001);
        assertEquals(1, produto.getId());
    }

    @Test
    public void testBuscarProdutoPorId() {
        Product produto = repository.buscarProdutoPorId(1);
        assertNotNull(produto);
        assertEquals("Produto 1", produto.getDescricao());
        assertEquals(10.0, produto.getPrecoCusto(), 0.001);
    }

    @Test
    public void testBuscarTodosOsProdutos() {
        assertEquals(2, repository.buscarTodosOsProdutos().size());
    }

    @Test
    public void testAtualizarProduto() {
        Product produtoAtualizado = new Product("Produto 2 Atualizado", 25.0, 2);
        repository.atualizarProduto(produtoAtualizado);
        Product produto = repository.buscarProdutoPorId(2);
        assertNotNull(produto);
        assertEquals("Produto 2 Atualizado", produto.getDescricao());
        assertEquals(25.0, produto.getPrecoCusto(), 0.001);
    }

    @Test
    public void testRetirarDoEstoque() {
        repository.retirarDoEstoque(1);
        assertNull(repository.buscarProdutoPorId(1));
    }

    @Test
    public void testTotalDeProdutosNoEstoque() {
        assertEquals(50, repository.totalDeProdutosNoEstoque());
    }

    @Test
    public void testValorTotaldoEstoque() {
        assertEquals(1100.0, repository.valorTotaldoEstoque(), 0.001);
    }

    @Test
    public void testQuantidadeDProdutosEmEstoque() {
        assertEquals(50, repository.quantidadeDProdutosEmEstoque());
    }

    @Test
    public void testEstoqueCritico() {
        assertEquals("Produto Produto 1 com poucas unidades em estoque", repository.estoqueCritico());
        repository.adicionarProduto("Produto 4", 15.0, 5);
        assertEquals("Produto Produto 4 com poucas unidades em estoque", repository.estoqueCritico());
        repository.adicionarProduto("Produto 5", 15.0, 15);
        assertEquals("Estoque checado", repository.estoqueCritico());
    }
 }
