package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import entities.RepositoryOfProducts;

public class Program {


	public static void main(String[] args) throws ParseException{	
		
		Locale.setDefault(Locale.US);
		
		RepositoryOfProducts rep1 = new RepositoryOfProducts();
		
		List<Product> list = new ArrayList<>();
		
		// LER DADOS DO ESTOQUE
		File Relatorio = new File("estoque.csv");		
		try (BufferedReader br = new BufferedReader(new FileReader(Relatorio))) {			
			String produto = br.readLine();
			while(produto != null) {				
				
				String fields[] = produto.split(",");
				if (fields.length >= 2) {
				String descricao = fields[0];
				double price = Double.parseDouble(fields[1]);
				int id = Integer.parseInt(fields[2]);
				
				rep1.adicionarProduto(descricao, 0);	
				
				}
				
				produto = br.readLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}		

		
		System.out.println("================ MERCEARIA =======================");
		
		System.out.println();
		
		// ATUALIZAR O RELATORIO
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("relatorio.txt"))) {
			for (Product item : rep1.buscarTodosOsProdutos()) {
				bw.append( item.toString());
				bw.newLine();
				
			}

			System.out.println("RELATORIO ATUALIZADO!");
			
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}

	
	
		
		System.out.println("==================================================");
		
		rep1.buscarProdutoPorId(2).setCustoAquisicao(500.0);
		rep1.buscarProdutoPorId(2).setQuantidadeEstoque(25);
		rep1.buscarProdutoPorId(2).setMargemLucro(20);
		rep1.buscarProdutoPorId(2).setPrecoCusto(10.0);
		rep1.buscarProdutoPorId(2).setPrecoVenda(20.0);
		
		System.out.println(rep1.totalDeProdutosNoEstoque());
		System.out.println(rep1.valorTotaldoEstoque());
		System.out.println(rep1.estoqueCritico());
		
		System.out.println(rep1.buscarProdutoPorId(2));
		

	}

}
