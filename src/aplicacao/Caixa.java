package aplicacao;
//testte
import java.util.Scanner;
import entidades.Funcionario;
import entidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class Caixa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Produto cas;
		BancoDeDados banco = new BancoDeDados();
		Funcionario chefe = new Funcionario("pedro", 1234, "casa", 12345, "chefe", 3, 2109);
		banco.AddFuncionario(chefe);
		System.out.println("bem vindo ao caixa redeSoma");
		int programaLigado = 10;

		while (programaLigado != 0) {

			System.out.println("desligar progama [ 0 ] cadastro produto[ 1 ] venda [ 2 ] pagar crediario [ 3 ]");
			System.out.println("cadastro funcionario[ 5 ] cadastra pessoa crediario [ 4 ] fundo de caixa R$"
					+ banco.getFundoDeCaixa() + "");

			programaLigado = sc.nextInt();
			switch (programaLigado) {
			case 0:
				System.out.println("programa sera desligado");
				break;
			case 1:
				// cadastro produto
				validacao(banco.getListFuncionario(), 2);

				System.out.print("nome do produto: ");
				String produtoName = sc.next();
				System.out.println();
				System.out.println("codigo de barra: ");
				int produtoCodigo = sc.nextInt();
				System.out.println();
				System.out.print("preco padrao: ");
				double precoPadrao = sc.nextDouble();
				System.out.println();
				System.out.print("produto estoque: ");
				int produtoEstoque = sc.nextInt();

				cas = new Produto(produtoName, produtoCodigo, precoPadrao, produtoEstoque);
				banco.listProduto.add(cas);
				break;
			case 2:
				// venda avista
				validacao(banco.getListFuncionario(), 1);
				banco =(vendaVista(banco));

				break;
			case 3:
				// pagar crediario
				validacao(banco.getListFuncionario(), 1);
				System.out.println("qual o numero de crediario");
				int dc = 1;
				//while (dc != 0) {
					System.out.println("pas = while");
					int numeroCrediario = sc.nextInt();
					for (int j = 0; j < banco.listCrediario.size(); j++) {
						System.out.println("pas = j");
						if (banco.listCrediario.get(j).getNumeroCrediario() == numeroCrediario) {
						System.out.println("pas = 3");
							numeroCrediario = banco.listCrediario.get(j).getNumeroCrediario();
							banco.setFundoDeCaixa(banco.listCrediario.get(numeroCrediario).PagarCrediario());
							dc = 0;
						}
					}
				//}
				break;
			case 4:
				// cadastro pessoa crediario
				
				validacao(banco.getListFuncionario(), 3);
				Crediario cliente;
				System.out.print("nome");
				String nome = sc.next();
				System.out.print("Rg:");
				int rg = sc.nextInt();
				System.out.print("endereco: ");
				String endereco = sc.next();
				System.out.print("cpf");
				int cpf = sc.nextInt();
				System.out.print("numero de crediario: ");
				int numeroCrediarioo = sc.nextInt();
				cliente = new Crediario(nome, rg, endereco, cpf, numeroCrediarioo);

				banco.cadastrarCrediario(cliente);
				break;
			case 5:
				// cadastro funcionario
				validacao(banco.getListFuncionario(), 3);
				banco.AddFuncionario(cadastroFunci());
				break;
			default:
				System.out.println("[ERRO]");
				break;
			}
		}
		sc.close();
	}

	public static BancoDeDados vendaVista(BancoDeDados banco) {
		Scanner sc = new Scanner(System.in);
		int baixap = 0;
		ArrayList<Produto> notaFiscal = new ArrayList<>();
		char fimCaixa = 's';
		while (fimCaixa == 's') {

			System.out.println("qual o codigo de barra do produto?");
			Integer codigob = sc.nextInt();
			codigob = position(banco.getListProduto(), codigob);

			if (codigob == null) {
				System.out.println("[ERRO] codigo de produto não existe");
			} else {
				banco.listProduto.get(codigob).toStrring();

				System.out.println("");
				System.out.println("quantas unidades desse produto vc quer vender");
				baixap = sc.nextInt();

				banco.removerEstoque(baixap, codigob);
				notaFiscal.add(banco.getListProduto().get(codigob));
				notaFiscal.get(codigob).setEstoque(0);
				notaFiscal.get(codigob).addEstoque(baixap);

				System.out.println("deseija incluir mais um produto ao carrinho?[s] ou [n]");
				fimCaixa = sc.next().charAt(0);

			}
			System.out.println("venda crediario[c] ou avista[a]? ");
			char couv = sc.next().charAt(0);
			int i = 1;
			while (i != 0) {
				if (couv == 'c') {
					System.out.println("qual o numeoro de Crediario");
					int numeroc = sc.nextInt();
					for (int j = 0; j < banco.listCrediario.size(); j++) {
						if (banco.listCrediario.get(i).getNumeroCrediario() == numeroc) {
							numeroc = banco.listCrediario.get(i).getNumeroCrediario();
							List<Produto> notaTeste = new ArrayList<>(notaFiscal);
							banco.listCrediario.get(numeroc).venderCrediario(notaTeste);
							System.out.println("anotação feita!!!");
							i = 0;
						}
					}

				} else if (couv == 'a') {
					banco.setFundoDeCaixa(notaMostraAvista(notaFiscal));
					i = 0;
					
				} else {
					System.out.println("[ERRO] não entendi sua resposta.");
				}
			}
		}
		return banco;
	}

	// verificar id codigo
	// + position():Integer
	public static Integer position(List<Produto> emp, int cod) {
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).getCodigoDeBarra() == cod) {
				return i;
			}
		}
		return null;
	}

	// + notaMostra():Double ele faz o papel de listar os "Produros" que foram retirados do estoque e fundo de caixa
	public static Double notaMostraAvista(List<Produto> sz) {
		double precoT = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("relatorio da venda");
		for (int i = 0; i < sz.size(); i++) {
			// System.out.println("");

			System.out.println("produto " + (i + 1));
			sz.get(i).toStrring();
			precoT += sz.get(i).getEstoque() * sz.get(i).getPreco();

		}
		System.out.print("preco total: " + precoT);
		System.out.println();
		char dt;
		System.out.println("precisa de troco? [y] ou [n]");
		dt = sc.next().charAt(0);

		if (dt == 'y') {
			troco(precoT);
		}
		// sc.close();
		return precoT;
	}
	//mesma coisa do avista, ele não retorna fundo de caixa 
	public static Double notaMostraCrediario(List<Produto> sz) {
		double precoT = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("relatorio da venda");
		for (int i = 0; i < sz.size(); i++) {
			// System.out.println("");

			System.out.println("produto " + (i + 1));
			sz.get(i).toStrring();
			precoT += sz.get(i).getEstoque() * sz.get(i).getPreco();

		}
		System.out.print("preco total: " + precoT);
		System.out.println();
		char dt;
		System.out.println("precisa de troco? [y] ou [n]");
		dt = sc.next().charAt(0);

		if (dt == 'y') {
			troco(precoT);
		}
		// sc.close();
		return precoT;
	}

	// + troco():void
	public static void troco(double total) {
		Scanner sc = new Scanner(System.in);
		double valor = 0;
		System.out.println("valor recebido: R$");
		valor = sc.nextDouble();
		System.out.println("troco : R$" + (valor - total));
		// sc.close();
	}
	// validação de senha de funcionario 
	public static int validacao(List<Funcionario> emp, int nivel) {
		Scanner scs = new Scanner(System.in);
		System.out.println("digite a senha:...");
		int x = 1;
		int senha = 0;
		while (x == 1) {
			senha = scs.nextInt();
			for (int i = 0; i < emp.size(); i++) {
				if (emp.get(i).getSenhaLong() == senha) {
					if (emp.get(i).getNivelPermicoes() >= nivel) {
						x = 0;
					}
				}
			}
		}
		System.out.println("CONFIRMADO");
		// scs.close();
		return senha;
	}

	public static Funcionario cadastroFunci() {
		Scanner sc = new Scanner(System.in);
		Funcionario f;
		System.out.println();
		System.out.print("nome do novo Funcionario");
		String nome = sc.next();
		System.out.print("RG: ");
		int rg = sc.nextInt();
		System.out.print("endereco: ");
		String endereco = sc.next();
		System.out.print("cpf: ");
		int cpf = sc.nextInt();
		System.out.print("cargo: ");
		String cargo = sc.next();
		System.out.println("nevel de permicoes: ");
		System.out.println("[1] vendas avista e crediario [2] cadastrar produtos [3]cadastrar funcionarios e clientes");
		int nivelPermicoes = sc.nextInt();
		System.out.print("senha de long: ");
		int senhaLong = sc.nextInt();

		f = new Funcionario(nome, rg, endereco, cpf, cargo, nivelPermicoes, senhaLong);
		return f;
	}
}
