package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Product;
import entities.RepositoryOfProducts;

public class RepositoryOfProductsTest {

    private RepositoryOfProducts repository;
    private RepositoryOfProducts repo;

    @Before
    public void setup() {
        repository = new RepositoryOfProducts();
    }

    @Test
    public void testAdicionarProduto() {
        Product produto = repository.adicionarProduto("Produto 1", 10.0);
        assertNotNull(produto);
        assertEquals(1, produto.getId());
        assertEquals("Produto 1", produto.getDescricao());
        assertEquals(10.0, produto.getPrecoCusto(), 0.0);
    }

    @Test
    public void testBuscarProdutoPorId() {
        Product produto1 = repository.adicionarProduto("Produto 1", 10.0);
        Product produto2 = repository.adicionarProduto("Produto 2", 20.0);
        Product produto3 = repository.adicionarProduto("Produto 3", 30.0);
        Product produtoEncontrado = repository.buscarProdutoPorId(produto2.getId());
        assertNotNull(produtoEncontrado);
        assertEquals(produto2.getId(), produtoEncontrado.getId());
        assertEquals(produto2.getDescricao(), produtoEncontrado.getDescricao());
        assertEquals(produto2.getPrecoCusto(), produtoEncontrado.getPrecoCusto(), 0.0);
    }

    @Test
    public void testBuscarTodosOsProdutos() {
        repository.adicionarProduto("Produto 1", 10.0);
        repository.adicionarProduto("Produto 2", 20.0);
        repository.adicionarProduto("Produto 3", 30.0);
        List<Product> produtos = repository.buscarTodosOsProdutos();
        assertNotNull(produtos);
        assertEquals(3, produtos.size());
    }

    @Test
    public void testAtualizarProduto() {
        Product produto = repository.adicionarProduto("Produto 1", 10.0);
        produto.setDescricao("Produto atualizado");
        produto.setPrecoCusto(20.0);
        repository.atualizarProduto(produto);
        Product produtoAtualizado = repository.buscarProdutoPorId(produto.getId());
        assertNotNull(produtoAtualizado);
        assertEquals(produto.getDescricao(), produtoAtualizado.getDescricao());
        assertEquals(produto.getPrecoCusto(), produtoAtualizado.getPrecoCusto(), 0.0);
    }

    @Test
    public void testRetirarDoEstoque() {
        Product produto = repository.adicionarProduto("Produto 1", 10.0);
        assertNotNull(repository.buscarProdutoPorId(produto.getId()));
        repository.retirarDoEstoque(produto.getId());
        assertNull(repository.buscarProdutoPorId(produto.getId()));
    }
    
    @Test
    public void testTotalDeProdutosNoEstoque() {
    	repository.adicionarProduto("Produto 1", 10.0).setQuantidadeEstoque(2);
    	repository.adicionarProduto("Produto 2", 20.0).setQuantidadeEstoque(3);
    	repository.adicionarProduto("Produto 3", 30.0).setQuantidadeEstoque(4);
    	assertEquals(9, repository.totalDeProdutosNoEstoque());
    }
    
    @Test
    public void testValorTotaldoEstoque() {
        // Cria um novo repositório de produtos
        RepositoryOfProducts repo = new RepositoryOfProducts();
        
        // Adiciona dois produtos ao repositório
        Product p1 = repo.adicionarProduto("Produto 1", 10.0);
        p1.setQuantidadeEstoque(2);
        p1.setPrecoVenda(15.0);
        
        Product p2 = repo.adicionarProduto("Produto 2", 20.0);
        p2.setQuantidadeEstoque(3);
        p2.setPrecoVenda(25.0);
        
        // Calcula o valor total do estoque
        int valorTotal = repo.valorTotaldoEstoque();
        
        // Verifica se o valor total está correto
        assertEquals(96, valorTotal);
    }
    
    @Test
    public void testEstoqueCritico() {
   
    	repo = new RepositoryOfProducts();
        repo.adicionarProduto("Produto 1", 10);
        repo.adicionarProduto("Produto 2", 20);
        repo.adicionarProduto("Produto 3", 30);
    	
        // Testa o caso em que todos os produtos têm estoque acima do crítico
        assertEquals("Estoque checado", repo.estoqueCritico());
        
        // Reduz a quantidade de estoque do Produto 1 para abaixo do crítico
        Product produto1 = repo.buscarProdutoPorId(1);
        produto1.setQuantidadeEstoque(5);
        
        // Testa o caso em que um produto tem estoque abaixo do crítico
        assertEquals("Produto Produto 1 com poucas unidades em estoque", repo.estoqueCritico());
    }

}    