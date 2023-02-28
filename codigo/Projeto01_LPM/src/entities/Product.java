package entities;

public class Product {
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private double margemLucro;
    private int quantidadeEstoque;
    private int quantidadeVendida;
    private double custoAquisicao;
    private int id;

    public Product(String descricao, double precoCusto, int id) {
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.margemLucro = precoCusto * ((Math.random() * 50) + 30) / 100;
        this.precoVenda = Math.round(this.precoCusto + this.margemLucro + (this.precoCusto + this.margemLucro) * 0.18);
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
		this.precoVenda = precoVenda;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
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

	public String toString() {
        return "ID: " + this.id + " | " + "Descrição: " + this.descricao + " | " + "Preço de custo: " + this.precoCusto + " | " + "Preço de venda: " + this.precoVenda + " | " + "Quantidade em estoque: " + this.quantidadeEstoque + " | " + "Quantidade vendida: " + this.quantidadeVendida + " | " + "Custo de aquisição: " + this.custoAquisicao;
    }
}

