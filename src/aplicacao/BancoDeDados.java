package aplicacao;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.Produto;
public class BancoDeDados extends Produto{
	
	public double fundoDeCaixa = 0;
	//todos os Arrays estão fazendo o trabalho dobanco de dados MySQL, quando este codigo resember o suporte para o MY,eles seram apagados 
	public List<Produto> listProduto = new ArrayList<>(); 
	public List<Funcionario> listFuncionario = new ArrayList<>();
	public List<Crediario> listCrediario = new ArrayList<>(); 
	//------------------------------------------------------------------------------------------------------------
	
	public BancoDeDados() {
		
	}
	
	public BancoDeDados(List<Produto> listProduto, List<Funcionario> listFuncionario, List<Crediario> listCrediario) {
		this.listProduto = listProduto;
		this.listFuncionario = listFuncionario;
		this.listCrediario = listCrediario;
	}
	
	public List<Produto> getListProduto() {
		return listProduto;
	}
	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}
	public List<Funcionario> getListFuncionario() {
		return listFuncionario;
	}
	public void setListFuncionario(List<Funcionario> listFuncionario) {
		this.listFuncionario = listFuncionario;
	}
	public List<Crediario> getListCrediario() {
		return listCrediario;
	}
	public void setListCrediario(List<Crediario> listCrediario) {
		this.listCrediario = listCrediario;
	}
	public double getFundoDeCaixa() {
		return fundoDeCaixa;
	}
	public void setFundoDeCaixa(double fundoDeCaixa) {
		this.fundoDeCaixa += fundoDeCaixa;
	}
	
	public void AddFuncionario(Funcionario add) {
		
		listFuncionario.add(add);
	}
	public void removerEstoque(int remo, int p) {
		listProduto.get(p).setEstoque(listProduto.get(p).getEstoque() - remo);
	}
	public void cadastrarCrediario(Crediario clinte) {
		listCrediario.add(clinte);
	}
}
