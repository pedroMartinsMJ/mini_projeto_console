package entidades;

public class Pessoa {
	 private String nome;
	 private int rg;
	 private String endereco;
	 private int cpf;

	 public Pessoa() {
		 
	 }
	 
	 public Pessoa(String nome, int rg, String endereco, int cpf) {
		setNome(nome);
		setRg(rg);
		setEndereco(endereco);
		setCpf(cpf);
	}

	 public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
