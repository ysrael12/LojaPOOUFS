package cliente;

public class PessoaJuridica extends Cliente implements ICliente{
	
	private String cnpj; 
	private String razaoSocial; 
	private String nomeFantasia; 
	
	public PessoaJuridica(String nome, String endereço, String numeroDeTelefone, String cnpj, String razaoSocial, String nomeFantasia) {
		super(nome, endereço, numeroDeTelefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
	}
	
	public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
	
    @Override
    public void exibirCliente() {
        System.out.println("Cliente ID: " + this.id + " | Nome: " + this.nome + " | Endereço: " + this.endereco + " | Telefone: " + this.numeroDeTelefone + " Cliente PJ");
    }
}
