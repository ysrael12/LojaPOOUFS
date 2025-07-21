package cliente;

import java.time.LocalDate;
import java.util.UUID;
public class PessoaFisica extends Cliente{
	private String cpf; 
	private LocalDate dataDeNascimento;
	
	public PessoaFisica(UUID UUID, String nome, String endereço, String numeroDeTelefone, String cpf, LocalDate dataDeNascimento) {
		super(nome, endereço, numeroDeTelefone);
		
		// Validação básica para CPF e data de nascimento
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        if (dataDeNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }
        
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataNascimento(LocalDate dataDeNascimento) {
        if (dataDeNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }
        this.dataDeNascimento = dataDeNascimento;
    }
	
	
}
