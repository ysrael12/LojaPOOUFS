package ui;
import java.util.Scanner;
import nota.Nota;
import produto.Produto;
import cliente.Cliente;

public class ConsoleMenu {
	
private Scanner in;

	public ConsoleMenu(Scanner in) {
		this.in = in;
	}
	
	public boolean cadastrarProduto () {
		System.out.println("Coloque o nome: ");
		String nome = this.in.nextLine();
		
		System.out.println("Coloque o preco: ");
		int preco =  Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		
		System.out.println("Coloque o estoque: ");
		int estoque = Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		
		 if(preco < 0 || estoque < 0 || nome.replaceAll(" ","").equals("")) {
         System.out.println("Produto invalido.");
			return false;
			}
			Produto p = new Produto (nome, preco, estoque);
			return true;
	}
	
	public boolean alterarProduto (Produto produto){
		System.out.println("Que alteracao deseja?");
		System.out.println("1- Nome\n2- Preco\n3- Estoque");
		int escolha = Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		
		if (escolha == 1){
		System.out.println("Coloque o novo nome: ");
		String nome = this.in.nextLine();
		produto.setNome(nome);
		return true;
		} 

		else if(escolha == 2){
		System.out.println("Coloque o novo preco: ");
		int preco =  Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		produto.setPrecoBase(preco);
		return true;
		}

		else if(escolha == 3){
		System.out.println("Coloque o novo estoque: ");
		int estoque =  Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		produto.setEstoque(estoque);
		return true;
		}	

		else {
			System.out.println("Erro de alteracao");
			return false;
		}
	}
	
	
	public boolean cadastrarCliente(){
	
		System.out.println("Coloque o nome: ");
		String nome = this.in.nextLine();
		
		System.out.println("Coloque o endereco: ");
		String endereco = this.in.nextLine();
		
		System.out.println("Coloque o numero de telefone: ");
		String numeroDeTelefone = this.in.nextLine();
		
		
		if ((nome.replaceAll(" ", "").equals("")) || (endereco.replaceAll(" ", "").equals("")) || (numeroDeTelefone.replaceAll(" ", "").equals(""))){
			System.out.println ("Cliente Invalido");
			return false;
		}

		Cliente c = new Cliente (nome, endereco, numeroDeTelefone);
		return true;
	}
	
	public boolean alterarProduto (Cliente cliente){
		
		System.out.println("Que alteracao deseja?");
		System.out.println("1- Nome\n2- Endereco\n3- Numero de telefone");
		int escolha = Integer.parseInt((this.in.nextLine()).replaceAll(" ",""));
		
		if (escolha == 1){
		System.out.println("Coloque o novo nome: ");
		String nome = this.in.nextLine();
		cliente.setNome(nome);
		return true;
		}

		else if (escolha == 2){
		System.out.println("Coloque o novo endereco: ");
		String endereco = this.in.nextLine();
		cliente.setEndereco(endereco);
		return true;
		}

		else if(escolha == 3){
		System.out.println("Coloque o novo numero de telefone: ");
		String numeroDeTelefone = this.in.nextLine();
		cliente.setNumeroDeTelefone(numeroDeTelefone);
		return true;
		}

		else {
			System.out.println("Erro de alteracao");
			return false;	
		}
	}
	
	public void listarNotasEmitidas (Nota[] listaNota) {
		
		for (int i=0; i < listaNota.length; i++){
			listaNota[i].exibirNota();
			System.out.print ("\n");
		}
	}
		
	
	public void listarProdutos (Produto[] listaProduto){
		
		for (int i=0; i < listaProduto.length; i++){
			listaProduto[i].exibirProduto();
			System.out.print ("\n");
		}
	}
	
	public void listarClientes (Cliente[] listaCliente){
		for (int i = 0; i < listaCliente.length; i++){
			listaCliente[i].exibirCliente();
			System.out.print ("\n");
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		new ConsoleMenu(sc);
	}
}

