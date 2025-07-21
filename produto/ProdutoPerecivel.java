package produto;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter; 

public class ProdutoPerecivel extends Produto {
	
	protected LocalDate dataDeValidade;
	protected String condicoesArmazenamento;
	
	public ProdutoPerecivel(String nome, double precoBase, int estoque, double pesoKg, String dimensoes, 
            LocalDate dataValidade, String condicoesArmazenamento) {
		super(nome, precoBase, estoque);
		
		if (dataValidade == null) {
            System.out.println("Data de validade não pode ser nula.");
            throw new IllegalArgumentException("Data de validade inválida.");
        }
        if (dataValidade.isBefore(LocalDate.now())) { // Não permitir produtos já vencidos no cadastro
            System.out.println("Produto já vencido na data de cadastro.");
            throw new IllegalArgumentException("Produto já vencido.");
        }
        if (condicoesArmazenamento == null || condicoesArmazenamento.trim().isEmpty()) {
            System.out.println("Condições de armazenamento não podem ser vazias.");
            throw new IllegalArgumentException("Condições de armazenamento inválidas.");
        }

        this.dataDeValidade = dataValidade;
        this.condicoesArmazenamento = condicoesArmazenamento;
	}
	
	public LocalDate getDataValidade() {
        return dataDeValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        if (dataValidade == null) {
            System.out.println("Data de validade não pode ser nula.");
            return;
        }
        if (dataValidade.isBefore(LocalDate.now())) { // Não permite alterar para uma data vencida
            System.out.println("Nova data de validade já vencida.");
            return;
        }
        this.dataDeValidade = dataValidade;
    }

    public String getCondicoesArmazenamento() {
        return this.condicoesArmazenamento;
    }

    public void setCondicoesArmazenamento(String condicoesArmazenamento) {
        if (condicoesArmazenamento == null || condicoesArmazenamento.trim().isEmpty()) {
            System.out.println("Condições de armazenamento não podem ser vazias.");
            return;
        }
        this.condicoesArmazenamento = condicoesArmazenamento;
    }
    
    // Método para verificar se o produto está válido
    public boolean estaValido() {
        // Considera válido se a data de hoje for anterior ou igual à data de validade
        return !LocalDate.now().isAfter(this.dataDeValidade); 
    }
    
    @Override
    public void exibirProduto() {
        String dataFormatada = "";
        if (dataDeValidade != null) {
            dataFormatada = dataDeValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        super.exibirProduto(); // Chama o método da superclasse (ProdutoFisico)
        System.out.println("  Tipo: Perecível | Validade: " + dataFormatada + " | Armazenamento: " + this.condicoesArmazenamento + " | Válido: " + (this.estaValido() ? "Sim" : "Não"));
    }

}
