package cliente;

import java.time.LocalDate;

public class PessoaFisica extends Cliente implements ICliente{
	private String cpf; 
	private LocalDate dataDeNascimento;
	
	public PessoaFisica(String nome, String endereço, String numeroDeTelefone, String cpf, LocalDate dataDeNascimento) {
		super(nome, endereço, numeroDeTelefone);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
	
    @Override
    public void exibirCliente() {
        System.out.println("Cliente ID: " + this.id + " | Nome: " + this.nome + " | Endereço: " + this.endereco + " | Telefone: " + this.numeroDeTelefone+ " Cliente PF");
    }
}
