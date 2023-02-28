package application;

import entities.Product;
import entities.RepositoryOfProducts;

public class Program {

	public static void main(String[] args) {
		
		
		RepositoryOfProducts rep1 = new RepositoryOfProducts();
		
		Product p1 = new Product("produto1", 300.00, 4324);
		
		System.out.println(rep1.buscarTodosOsProdutos());
		
		rep1.adicionarProduto(p1.getDescricao(), p1.getPrecoCusto());
		
		System.out.println(rep1.buscarTodosOsProdutos());

	}

}
