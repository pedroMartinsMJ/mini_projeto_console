package aplicacao;
import entidades.Produto;
import entidades.Pessoa;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Crediario extends Pessoa {
	private int numeroCrediario;
	public ArrayList<Produto> listaProdutoCrediario = new ArrayList<>();
	
	public Crediario(String nome, int rg, String endereco, int cpf, int numeroCrediario) {
		super(nome, rg, endereco, cpf);
		this.numeroCrediario = numeroCrediario;
	}

	public int getNumeroCrediario() {
		return numeroCrediario;
	}
	public void setNumeroCrediario(int numeroCrediario) {
		this.numeroCrediario = numeroCrediario;
	}
	
	public void listarDividas(){
		
	}
	
	public void venderCrediario(ArrayList<Produto> notaFiscal){
		
		listaProdutoCrediario.addAll(notaFiscal);
		
	}
	
	public double PagarCrediario(){
		Scanner sc = new Scanner(System.in);
		double totalDivida = 0;
		System.out.println("lista de dividas");
		for(int i = 1; i <= listaProdutoCrediario.size();i++) {
			System.out.print("produto #"+i);
			listaProdutoCrediario.get(i).toStrring();
			totalDivida += listaProdutoCrediario.get(i).getPreco();
		}
		System.out.println("total"+totalDivida);
		
		System.out.println("vc deseija pagar a divida [s] ou [n]");
		
		char sn = sc.next().charAt(0);
		if(sn == 's') {
			for(int i = 1; i <= listaProdutoCrediario.size();i++) {
				System.out.print("produto #"+i);
				listaProdutoCrediario.get(i).toStrring();
				listaProdutoCrediario.remove(i);
			}
			System.out.println("conta abatida!!!");
			return totalDivida;
		}
		return 0;
	}
}
