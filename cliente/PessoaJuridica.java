package cliente;

public class PessoaJuridica extends Cliente{
	
	private String cnpj; 
	private String razaoSocial; 
	private String nomeFantasia; 
	
	public PessoaJuridica(String nome, String endereço, String numeroDeTelefone, String cnpj, String razaoSocial, String nomeFantasia) {
		super(nome, endereço, numeroDeTelefone);
		// Validação básica para CNPJ e razão social
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ não pode ser vazio.");
        }
        if (razaoSocial == null || razaoSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("Razão Social não pode ser vazia.");
        }

        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
	}
	
	public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ não pode ser vazio.");
        }
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        if (razaoSocial == null || razaoSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("Razão Social não pode ser vazia.");
        }
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
	
}
