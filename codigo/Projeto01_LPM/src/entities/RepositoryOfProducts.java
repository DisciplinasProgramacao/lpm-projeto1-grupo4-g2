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

    public Product adicionarProduto(String descricao, double precoCusto, int estoque) {
        Product produto = new Product(descricao, precoCusto, this.proximoId);
        this.produtos.add(produto);
        this.proximoId++;
        produto.precoVenda();
        produto.setQuantidadeEstoque(estoque);
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

    //Confirmar se esta na especificção
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
    
    public int quantidadeDProdutosEmEstoque() {
    	int quant = 0;
    	for(Product p : produtos) {
    		quant += p.getQuantidadeEstoque();
    	}
    	return quant;
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
    
    public void venderProduto(int id, int quant) {
    	Product produto1 = buscarProdutoPorId(id);
    	produto1.setQuantidadeEstoque(produto1.getQuantidadeEstoque() - quant);
    	produto1.setQuantidadeVendida(quant);
    	System.out.println("Precisamos repor o estoque do produto " + produto1.getDescricao() +" ap�s essa venda");
    }
    
    public void comprarProduto(int id, int quant) {
    	Product produto1 = buscarProdutoPorId(id);
    	produto1.setQuantidadeEstoque(produto1.getQuantidadeEstoque() + quant);
    	
    	System.out.println("Estoque renovado do  " + produto1.getDescricao() +" Quantidade atualizada: " + produto1.getQuantidadeEstoque());
    }
    
    public double valorVendido() {
    	double valorTotalVendido = 0;
    	for(Product p : produtos) {
    		valorTotalVendido += (p.getQuantidadeVendida() * p.getPrecoVenda()) ;
    	}
    	return valorTotalVendido;
    }
    
    public double valorGastoComReposicao() {
    	double valorGastoComReposicao = 0;
    	for(Product p : produtos) {
    		valorGastoComReposicao += (p.getQuantidadeEstoque() * p.getPrecoCusto()) ;
    	}
    	return valorGastoComReposicao;
    }
    
    public void estoqueAbaixoDoMinimo () {
    	int quantidadeMinima = 1000;
    	for(Product p : produtos) {
    		if(p.getQuantidadeEstoque() < quantidadeMinima) {
    			System.out.println(p.getDescricao() + " com apenas " + p.getQuantidadeEstoque() + " unidades em estoque(quantidade critica)");
    		}
    	}
    	
    }

	@Override
	public String toString() {
		return "RepositoryOfProducts [produtos=" + produtos + ", proximoId=" + proximoId + "]";
	}
    
    
}
