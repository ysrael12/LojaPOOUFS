package cliente;
import java.util.UUID;


public class Cliente {
	protected final UUID UUID;
	protected String nome; 
	protected String endereço; 
	protected String numeroDeTelefone; 
	
	// Chamar construtor para cadastrar clientes
	public Cliente(String nome, String endereço, String numeroDeTelefone){
		this.UUID = java.util.UUID.randomUUID(); 
		this.nome = nome; 
		this.endereço = endereço; 
		this.numeroDeTelefone = numeroDeTelefone;
	}
	
	// Alteração de Cliente com Setters
	
	public void setNome(String nome) {
		this.nome = nome; 
	}
	
	public void setEndereço(String endereço) {
		this.endereço = endereço; 
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
	
	public String getEndereço() {
		return this.endereço;
	}
	
	public String getNumeroDeTelefone() {
		return this.numeroDeTelefone;
	}
	
	
}
