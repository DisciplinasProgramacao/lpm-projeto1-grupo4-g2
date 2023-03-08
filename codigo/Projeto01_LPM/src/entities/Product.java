package entities;

public class Product {
	
	private final double taxes = 0.18;
	
    private String descricao;
    private double precoCusto;
    private int id;
    private double precoVenda;
    private double margemLucro;
    private int quantidadeEstoque;
    private int quantidadeVendida;
    private double custoAquisicao;
    

    public Product(String descricao, double precoCusto, int id ) {
    	if(descricao.length() >= 3) {    		
        this.descricao = descricao;
    	} else {
    		this.descricao = null;
    	}
        this.precoCusto = precoCusto;
        this.id = id;
        
    }   

    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = Math.round(this.precoCusto + this.margemLucro + (this.precoCusto + this.margemLucro) * taxes);

	}

	public double getMargemLucro(double margemLucro) {
		return margemLucro;
	}
	//public void setMargemLucro(double margemLucro) {
	//	this.margemLucro = precoCusto * ((Math.random() * 50) + 30) / 100;
	//}
	
	public void setMargemLucro(double margemLucro) {

		this.margemLucro = precoCusto * ((Math.random() * 50) + 30) / 100;
		setPrecoVenda(precoVenda);
	    double valorMargemLucro = margemLucro / 100.0;
	    double precoVenda = precoCusto * (1 + valorMargemLucro + taxes);
	    
	    if (valorMargemLucro >= 0.3 && valorMargemLucro <= 0.8) {
	        this.margemLucro = valorMargemLucro;
	        this.precoVenda = Math.round(precoVenda * 100) / 100.0;
	    } else {
	        throw new IllegalArgumentException("A margem de lucro deve estar entre 30 e 80% do valor do preço de custo.");
	    }

	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public double getCustoAquisicao() {
		return custoAquisicao;
	}

	public void setCustoAquisicao(double custoAquisicao) {
		this.custoAquisicao = custoAquisicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double valorArrecadado(String descricao, int id) {
		return getQuantidadeVendida() * getPrecoVenda();		
	}
	
	public double valorGasto(String descricao, int id) {
		return getQuantidadeEstoque() * getPrecoCusto();
	}
	
	public String nivelEstoque(String descricao, int id) {
		 if (getQuantidadeEstoque() < 10 ) {
			 return "Estoque crítico, contatar fornecedor";
		 } else {
			 return "Estoque ok";
		 }
	}

	public String toString() {
        return "ID: " + this.id + " | " + "Descrição: " + this.descricao + " | " + "Preço de custo: " + this.precoCusto + " | " + "Preço de venda: " + this.precoVenda + " | " + "Quantidade em estoque: " + this.quantidadeEstoque + " | " + "Quantidade vendida: " + this.quantidadeVendida + " | " + "Custo de aquisição: " + this.custoAquisicao;
    }
}

