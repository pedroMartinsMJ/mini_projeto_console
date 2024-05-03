package entidades;

public class Funcionario extends Pessoa{
	private String cargo;
	private int nivelPermicoes;
	private int senhaLong;
	
	public Funcionario() {
	}

	public Funcionario(String nome, int rg, String endereco, int cpf, String cargo, int nivelPermicoes, int senhaLong) {
		super(nome, rg, endereco, cpf);
		this.cargo = cargo;
		this.nivelPermicoes = nivelPermicoes;
		this.senhaLong = senhaLong;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getNivelPermicoes() {
		return nivelPermicoes;
	}

	public void setNivelPermicoes(int nivelPermicoes) {
		this.nivelPermicoes = nivelPermicoes;
	}

	public int getSenhaLong() {
		return senhaLong;
	}

	public void setSenhaLong(int senhaLong) {
		this.senhaLong = senhaLong;
	}
	
}
