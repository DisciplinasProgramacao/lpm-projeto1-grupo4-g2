package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import entities.Product;
import entities.RepositoryOfProducts;

public class Program {

	public static void main(String[] args) {
		
		
		RepositoryOfProducts rep1 = new RepositoryOfProducts();
		
		Product p1 = new Product("produto1", 300.00, 4324);
		
		System.out.println(rep1.buscarTodosOsProdutos());
		
		rep1.adicionarProduto(p1.getDescricao(), p1.getPrecoCusto());
		
		System.out.println(rep1.buscarTodosOsProdutos());
		
		
		
		
		// LER DADOS DO RELATORIO
		File Relatorio = new File("relatorio.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(Relatorio))) {
			
			String produto = br.readLine();
			while(produto != null) {
				System.out.println(produto);
				produto = br.readLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}		
		
		System.out.println("==================================================");
		
		
		

	}

}
