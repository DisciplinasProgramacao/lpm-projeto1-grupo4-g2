package entities;

import java.util.ArrayList;
import java.util.List;

public class RepositoryOfProducts {
    private List<Product> produtos;
    private int proximoId;

    public RepositoryOfProducts() {
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
    }

    public Product adicionarProduto(String descricao, double precoCusto) {
        Product produto = new Product(descricao, precoCusto, this.proximoId);
        this.produtos.add(produto);
        this.proximoId++;
        return produto;
    }

    public Product buscarProdutoPorId(int id) {
        for (Product produto : this.produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public List<Product> buscarTodosOsProdutos() {
        return this.produtos;
    }

    public void atualizarProduto(Product produtoAtualizado) {
        Product produtoAntigo = this.buscarProdutoPorId(produtoAtualizado.getId());
        if (produtoAntigo != null) {
            produtoAntigo.setDescricao(produtoAtualizado.getDescricao());
            produtoAntigo.setPrecoCusto(produtoAtualizado.getPrecoCusto());
        }
    }

    public void removerProduto(int id) {
        Product produto = this.buscarProdutoPorId(id);
        if (produto != null) {
            this.produtos.remove(produto);
        }
    }
}
