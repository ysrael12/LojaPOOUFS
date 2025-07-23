package cliente;

import java.util.UUID;

public interface ICliente {
	public void setNome(String nome); 
	public void setEndereco(String endereco); 
	public void setNumeroDeTelefone(String numeroDeTelefone); 
	public UUID getId(); 
	public String getNome();
	public String getEndereco();
	public String getNumeroDeTelefone();
	public void exibirCliente();
}
