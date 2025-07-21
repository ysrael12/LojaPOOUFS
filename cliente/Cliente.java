package cliente;
import java.util.UUID;


public class Cliente {
	protected final UUID UUID;
	protected String nome; 
	protected String endereco; 
	protected String numeroDeTelefone; 
	
	// Chamar construtor para cadastrar clientes
	public Cliente(String nome, String endereco, String numeroDeTelefone) {
		this.UUID = java.util.UUID.randomUUID(); 
		this.nome = nome; 
		this.endereco = endereco; 
		this.numeroDeTelefone = numeroDeTelefone;
	}
	
	// Alteração de Cliente com Setters
	
	public void setNome(String nome) {
		this.nome = nome; 
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco; 
	}
	
	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}
	
	// Getters, Para encaminhar para nota
	
	public UUID getUUID(){
		return this.UUID;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public String getNumeroDeTelefone() {
		return this.numeroDeTelefone;
	}
	
    public void exibirCliente() {
        System.out.println("Codigo: "+this.UUID);
        System.out.println("Nome: "+this.nome);
        System.out.println("Endereco: "+this.endereco);
        System.out.println("Telefone: "+this.numeroDeTelefone);
    }
}
