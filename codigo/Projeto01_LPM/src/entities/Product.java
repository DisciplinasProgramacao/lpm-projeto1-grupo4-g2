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
	
	public double margemLucro() {
		double preco;
		preco = getPrecoCusto() * 50/100;
		return preco;
	}
	
	public double valorImposto() {
		double imposto;
		double soma;
		soma = getPrecoCusto() + margemLucro();
		imposto = soma * 18/100;
		return imposto;
	}
	
	public double precoVenda() {
		double venda;
		venda = getPrecoCusto() + margemLucro() + valorImposto();
		return venda;
	}

	public double getMargemLucro(double margemLucro) {
		return margemLucro;
	}
	//public void setMargemLucro(double margemLucro) {
	//	this.margemLucro = precoCusto * ((Math.random() * 50) + 30) / 100;
	//}
	
	public void setMargemLucro(double margemLucro) {
		
		this.margemLucro = precoCusto *  50  / 100;
		setPrecoVenda(precoVenda);
	    double valorMargemLucro = margemLucro / 100.0;
	    double precoVenda = precoCusto * (1 + valorMargemLucro + taxes);


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
        return "ID: " + this.id + " | " + "Descrição: " + this.descricao + " | " + "Preço de custo: " + this.precoCusto + " | " + "Preço de venda: " + precoVenda() + " | " + "Quantidade em estoque: " + this.quantidadeEstoque + " | " + "Quantidade vendida: " + this.quantidadeVendida + " | " + "Custo de aquisição: " + this.custoAquisicao;
    }
}

