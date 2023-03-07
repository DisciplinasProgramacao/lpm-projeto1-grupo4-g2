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

    public void retirarDoEstoque(int id) {
        Product produto = this.buscarProdutoPorId(id);
        if (produto != null) {
            this.produtos.remove(produto);
        }
    }
    
    public int totalDeProdutosNoEstoque() {
    	int total = 0;
    	for(Product p : produtos) {
    		total += p.getQuantidadeEstoque();
    	}
    	return total;
    }
    
    public int valorTotaldoEstoque() {
    	int valorTotal = 0;
    	for(Product p : produtos) {
    		valorTotal += (p.getQuantidadeEstoque() * p.getPrecoVenda()) ;
    	}
    	return valorTotal;
    }
    
    public String estoqueCritico() {
    	for (Product p : produtos) {
    		if(p.getQuantidadeEstoque() < 10) {
    			return "Produto " + p.getDescricao() + " com poucas unidades em estoque";
    		}
    		else {
    			return "Produto " + p.getDescricao() + " com muitas unidades em estoque";
    		}
    	}
		return "Estoque checado";
    }

	@Override
	public String toString() {
		return "RepositoryOfProducts [produtos=" + produtos + ", proximoId=" + proximoId + "]";
	}
    
    
}
