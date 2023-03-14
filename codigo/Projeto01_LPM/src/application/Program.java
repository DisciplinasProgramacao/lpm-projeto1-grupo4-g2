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
import java.util.Scanner;

import entities.Product;
import entities.RepositoryOfProducts;

public class Program {


	public static void main(String[] args) throws ParseException{	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
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
				
				rep1.adicionarProduto(descricao, 0, 3);	
				
				}
				
				produto = br.readLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}		
		
		//adicionando atributos nos produtos
		rep1.buscarProdutoPorId(1).setCustoAquisicao(1000.0);
		rep1.buscarProdutoPorId(1).setQuantidadeEstoque(15);
		rep1.buscarProdutoPorId(1).setMargemLucro(25);
		rep1.buscarProdutoPorId(1).setPrecoCusto(40.0);
		rep1.buscarProdutoPorId(1).setPrecoVenda(60.0);
		
		
		rep1.buscarProdutoPorId(2).setCustoAquisicao(500.0);
		rep1.buscarProdutoPorId(2).setQuantidadeEstoque(25);
		rep1.buscarProdutoPorId(2).setMargemLucro(20);
		rep1.buscarProdutoPorId(2).setPrecoCusto(10.0);
		rep1.buscarProdutoPorId(2).setPrecoVenda(20.0);

		rep1.buscarProdutoPorId(3).setCustoAquisicao(600.0);
		rep1.buscarProdutoPorId(3).setQuantidadeEstoque(5);
		rep1.buscarProdutoPorId(3).setMargemLucro(25);
		rep1.buscarProdutoPorId(3).setPrecoCusto(45.0);
		rep1.buscarProdutoPorId(3).setPrecoVenda(90.0);

		rep1.buscarProdutoPorId(4).setCustoAquisicao(50.0);
		rep1.buscarProdutoPorId(4).setQuantidadeEstoque(50);
		rep1.buscarProdutoPorId(4).setMargemLucro(30);
		rep1.buscarProdutoPorId(4).setPrecoCusto(20.0);
		rep1.buscarProdutoPorId(4).setPrecoVenda(30.0);

		rep1.buscarProdutoPorId(5).setCustoAquisicao(100.0);
		rep1.buscarProdutoPorId(5).setQuantidadeEstoque(25);
		rep1.buscarProdutoPorId(5).setMargemLucro(20);
		rep1.buscarProdutoPorId(5).setPrecoCusto(50.0);
		rep1.buscarProdutoPorId(5).setPrecoVenda(150.0);

		rep1.buscarProdutoPorId(6).setCustoAquisicao(10.0);
		rep1.buscarProdutoPorId(6).setQuantidadeEstoque(100);
		rep1.buscarProdutoPorId(6).setMargemLucro(22);
		rep1.buscarProdutoPorId(6).setPrecoCusto(5.0);
		rep1.buscarProdutoPorId(6).setPrecoVenda(20.0);

		rep1.buscarProdutoPorId(7).setCustoAquisicao(500.0);
		rep1.buscarProdutoPorId(7).setQuantidadeEstoque(25);
		rep1.buscarProdutoPorId(7).setMargemLucro(20);
		rep1.buscarProdutoPorId(7).setPrecoCusto(10.0);
		rep1.buscarProdutoPorId(7).setPrecoVenda(20.0);

		
		System.out.println("================ MERCEARIA =======================");
		
		System.out.println();
		
		
		
		System.out.println("MENU - Escolha uma opção");
		System.out.println("1 - Buscar produto");
		System.out.println("2 - Adicionar produto");
		System.out.println("3 - Atualizar produto");
		System.out.println("4 - Ver estoque");
		System.out.println("5 - Valor total do estoque");
		System.out.println("6 - Vender produto");
		System.out.println("0 - Sair do programa");
		int n;

		do {
		    n = sc.nextInt();
		    switch (n) {
		        case 1: 
		            System.out.print("Informe o id do produto: ");
		            int id = sc.nextInt();
		            System.out.println(rep1.buscarProdutoPorId(id));
		            break;
		        case 2: 
		            System.out.print("Informe a descrição do produto: ");
		            sc.nextLine(); // Consumir a quebra de linha após a leitura do inteiro
		            String descricao = sc.nextLine();
		            System.out.print("Informe o pre�o de custo do produto: ");
		            id = sc.nextInt();
		            System.out.println("Informe a quantidade dispon�vel no estoque: ");
		            int estoque = sc.nextInt();
		            rep1.adicionarProduto(descricao, id, estoque);
		            System.out.println("Produto adicionado");
		            break;
		        case 3:
		            System.out.println("Informe o produto a ser atualizado"); // Corrigir esse metodo de atualizar
		            rep1.atualizarProduto(null);
		            break;
		        case 4:
		            System.out.println("ESTOQUE");
		            for (Product p : rep1.buscarTodosOsProdutos()) {
		                System.out.println(p.toString());
		            }
		            break;
		        case 5:
		        	double valorTotal = rep1.valorTotaldoEstoque();
		        	System.out.printf("Valor total do estoque: R$ " + "%.2f" , valorTotal);
		        	System.out.println();
		        	break;
		        case 6:
		        	  System.out.print("Informe o id do produto: ");
			          int id1 = sc.nextInt();
		        	System.out.println("Deseja vender quantos produtos: ");
		        	int venda = sc.nextInt();
		        	rep1.venderProduto(id1, venda);
		        	break;
		        case 0:
		            System.out.println("Encerrando programa...");
		            break;
		        default:
		            System.out.println("Opção inválida. Tente novamente.");
		    }
		} while (n != 0);

		
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
		
	
		
		System.out.println(rep1.totalDeProdutosNoEstoque());
		System.out.println(rep1.valorTotaldoEstoque());
		System.out.println(rep1.estoqueCritico());
		
		System.out.println(rep1.buscarProdutoPorId(2));
		

	}

}
