package entidades;

public class Produto {
	private String nome;
	private int codigoDeBarra;
	private String descricao;
	private Double preco ;
	private Double precoPromocao;
	private Double precoCrediario;
	private int estoque; 
	private int cfop;
	private int cst; 
	private String lote;
	private String fabricacao; 
	private String validade;
	private int classificacaoMonofasica;
	private int codTributacao;
	public double cache;
	public Produto() {
		
	}
	
	public Produto(String nome, int codigoDeBarra, Double preco, int estoque) {
		super();
		this.nome = nome;
		this.codigoDeBarra = codigoDeBarra;
		this.preco = preco;
		this.estoque = estoque;
	}

	public Produto(String nome, int codigoDeBarra, String descricao, Double preco, Double precoPromocao,
			Double precoCrediario, int estoque, int cfop, int cst, String lote, String fabricacao, String validade,
			int classificacaoMonofasica, int codTributacao) {
		super();
		this.nome = nome;
		this.codigoDeBarra = codigoDeBarra;
		this.descricao = descricao;
		this.preco = preco;
		this.precoPromocao = precoPromocao;
		this.precoCrediario = precoCrediario;
		this.estoque = estoque;
		this.cfop = cfop;
		this.cst = cst;
		this.lote = lote;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.classificacaoMonofasica = classificacaoMonofasica;
		this.codTributacao = codTributacao;
	}

	//---------------------------------------------------------------------------------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(int codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public Double getPrecoCrediario() {
		return precoCrediario;
	}

	public void setPrecoCrediario(Double precoCrediario) {
		this.precoCrediario = precoCrediario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getCfop() {
		return cfop;
	}

	public void setCfop(int cfop) {
		this.cfop = cfop;
	}

	public int getCst() {
		return cst;
	}

	public void setCst(int cst) {
		this.cst = cst;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(String fabricacao) {
		this.fabricacao = fabricacao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getClassificacaoMonofasica() {
		return classificacaoMonofasica;
	}

	public void setClassificacaoMonofasica(int classificacaoMonofasica) {
		this.classificacaoMonofasica = classificacaoMonofasica;
	}

	public int getCodTributacao() {
		return codTributacao;
	}

	public void setCodTributacao(int codTributacao) {
		this.codTributacao = codTributacao;
	}
	

	//----------------------------------------------------------------------------------------
	public void addEstoque(int remo) {
		this.estoque += remo ;
	}
	
	public void toStrring() {
		System.out.println("");
		System.out.println("produto: " + nome);
		System.out.println("preco: " + preco);
		System.out.println("estoque: " + estoque);
		System.out.println("codigo: " + codigoDeBarra);
		System.out.println("");
	}
}
