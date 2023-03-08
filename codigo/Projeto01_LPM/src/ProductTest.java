import static org.junit.Assert.assertEquals;
import entities.Product;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Produto de Teste", 10.0, 1);
    }

    @Test
    public void testSetDescricao() {
        product.setDescricao("Novo Produto de Teste");
        assertEquals("Novo Produto de Teste", product.getDescricao());
    }

    @Test
    public void testSetPrecoCusto() {
        product.setPrecoCusto(20.0);
        assertEquals(20.0, product.getPrecoCusto(), 0.0);
    }

    @Test
    public void testSetPrecoVenda() {
        product.setMargemLucro(0.3);
        product.setPrecoVenda(20.0);
        assertEquals(26.0, product.getPrecoVenda(), 0.0);
    }

    @Test
    public void testSetMargemLucro() {
        product.setMargemLucro(0.3);
        assertEquals(13.0, product.getPrecoVenda(), 0.0);
    }

    @Test
    public void testSetQuantidadeEstoque() {
        product.setQuantidadeEstoque(100);
        assertEquals(100, product.getQuantidadeEstoque());
    }

    @Test
    public void testSetQuantidadeVendida() {
        product.setQuantidadeVendida(10);
        assertEquals(10, product.getQuantidadeVendida());
    }

    @Test
    public void testSetCustoAquisicao() {
        product.setCustoAquisicao(8.0);
        assertEquals(8.0, product.getCustoAquisicao(), 0.0);
    }

    @Test
    public void testValorArrecadado() {
        product.setQuantidadeVendida(5);
        product.setMargemLucro(0.3);
        product.setPrecoVenda(20.0);
        assertEquals(130.0, product.valorArrecadado(product.getDescricao(), product.getId()), 0.0);
    }

    @Test
    public void testValorGasto() {
        product.setQuantidadeEstoque(50);
        product.setPrecoCusto(10.0);
        assertEquals(500.0, product.valorGasto(product.getDescricao(), product.getId()), 0.0);
    }

    @Test
    public void testNivelEstoqueCritico() {
        product.setQuantidadeEstoque(5);
        assertEquals("Estoque crítico, contatar fornecedor", product.nivelEstoque(product.getDescricao(), product.getId()));
    }

    @Test
    public void testNivelEstoqueOk() {
        product.setQuantidadeEstoque(20);
        assertEquals("Estoque ok", product.nivelEstoque(product.getDescricao(), product.getId()));
    }

}
