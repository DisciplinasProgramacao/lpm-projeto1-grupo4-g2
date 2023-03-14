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
    private Product produto;

    @Before
    public void setup() {
        repository = new RepositoryOfProducts();
    }

    @Test
    public void testAdicionarProduto() {
        Product produto = repository.adicionarProduto("Produto 1", 10.0, 10);
        assertNotNull(produto);
        assertEquals(1, produto.getId());
        assertEquals("Produto 1", produto.getDescricao());
        assertEquals(10.0, produto.getPrecoCusto(), 0.0);
    }

    @Test
    public void testBuscarProdutoPorId() {
        Product produto1 = repository.adicionarProduto("Produto 1", 10.0, 3);
        Product produto2 = repository.adicionarProduto("Produto 2", 20.0, 4);
        Product produto3 = repository.adicionarProduto("Produto 3", 30.0, 25);
        Product produtoEncontrado = repository.buscarProdutoPorId(produto2.getId());
        assertNotNull(produtoEncontrado);
        assertEquals(produto2.getId(), produtoEncontrado.getId());
        assertEquals(produto2.getDescricao(), produtoEncontrado.getDescricao());
        assertEquals(produto2.getPrecoCusto(), produtoEncontrado.getPrecoCusto(), 0.0);
    }

    @Test
    public void testBuscarTodosOsProdutos() {
        repository.adicionarProduto("Produto 1", 10.0, 35);
        repository.adicionarProduto("Produto 2", 20.0, 59);
        repository.adicionarProduto("Produto 3", 30.0, 50);
        List<Product> produtos = repository.buscarTodosOsProdutos();
        assertNotNull(produtos);
        assertEquals(3, produtos.size());
    }

    @Test
    public void testAtualizarProduto() {
        Product produto = repository.adicionarProduto("Produto 1", 10.0, 49);
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
        Product produto = repository.adicionarProduto("Produto 1", 10.0, 40);
        assertNotNull(repository.buscarProdutoPorId(produto.getId()));
        repository.retirarDoEstoque(produto.getId());
        assertNull(repository.buscarProdutoPorId(produto.getId()));
    }
    
    @Test
    public void testTotalDeProdutosNoEstoque() {
    	repository.adicionarProduto("Produto 1", 10.0, 20).setQuantidadeEstoque(2);
    	repository.adicionarProduto("Produto 2", 20.0, 35).setQuantidadeEstoque(3);
    	repository.adicionarProduto("Produto 3", 30.0, 70).setQuantidadeEstoque(4);
    	assertEquals(9, repository.totalDeProdutosNoEstoque());
    }
    
    @Test
    public void testValorTotaldoEstoque() {
        // Cria um novo repositório de produtos
        RepositoryOfProducts repo = new RepositoryOfProducts();
        
        // Adiciona dois produtos ao repositório
        Product p1 = repo.adicionarProduto("Produto 1", 10.0, 67);
        p1.setQuantidadeEstoque(2);
        p1.setPrecoVenda(15.0);
        
        Product p2 = repo.adicionarProduto("Produto 2", 20.0, 22);
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
        repo.adicionarProduto("Produto 1", 10, 86);
        repo.adicionarProduto("Produto 2", 20, 56);
        repo.adicionarProduto("Produto 3", 30, 44);
    	
        // Testa o caso em que todos os produtos têm estoque acima do crítico
        assertEquals("Estoque checado", repo.estoqueCritico());
        
        // Reduz a quantidade de estoque do Produto 1 para abaixo do crítico
        Product produto1 = repo.buscarProdutoPorId(1);
        produto1.setQuantidadeEstoque(5);
        
        // Testa o caso em que um produto tem estoque abaixo do crítico
        assertEquals("Produto Produto 1 com poucas unidades em estoque", repo.estoqueCritico());
    }
    
    @Test
    public void testVenderProduto() {
    	repo = new RepositoryOfProducts();
    	repo.adicionarProduto("ProdutoTest", 10.0, 0);
    	Product produto = repository.adicionarProduto("ProdutoTest", 10.0, 10);
        repo.venderProduto(1, 3);
        assertEquals(10, produto.getQuantidadeEstoque());
        assertEquals(0, produto.getQuantidadeVendida());
    }
    
    @Test
    public void testComprarProduto() {
    	repo = new RepositoryOfProducts();
    	repo.adicionarProduto("ProdutoTest", 10.0, 0);
    	Product produto = repository.adicionarProduto("Produto 1", 10.0, 10);
        repo.comprarProduto(1, 5);
        assertEquals(10, produto.getQuantidadeEstoque());
    }

}    