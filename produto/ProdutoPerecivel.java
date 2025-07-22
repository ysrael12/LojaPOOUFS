package produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // For formatting date

public class ProdutoPerecivel extends ProdutoFisico {
    protected LocalDate dataValidade;
    protected String condicoesArmazenamento;

    public ProdutoPerecivel(String nome, double precoBase, int estoque, 
                            double pesoKg, String dimensoes, 
                            LocalDate dataValidade, String condicoesArmazenamento) {
        super(nome, precoBase, estoque, pesoKg, dimensoes);
        
        if (dataValidade == null) {
            System.out.println("Data de validade não pode ser nula no cadastro.");
            throw new IllegalArgumentException("Data de validade inválida.");
        }
        if (dataValidade.isBefore(LocalDate.now())) {
            System.out.println("Produto já vencido na data de cadastro.");
            throw new IllegalArgumentException("Produto já vencido.");
        }
        if (condicoesArmazenamento == null || condicoesArmazenamento.trim().isEmpty()) {
            System.out.println("Condições de armazenamento não podem ser vazias.");
            throw new IllegalArgumentException("Condições de armazenamento inválidas.");
        }

        this.dataValidade = dataValidade;
        this.condicoesArmazenamento = condicoesArmazenamento;
    }

    // --- Getters e Setters específicos ---
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        if (dataValidade == null) { // Ensure null cannot be set
            throw new IllegalArgumentException("Data de validade não pode ser nula.");
        }
        if (dataValidade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Nova data de validade já vencida.");
        }
        this.dataValidade = dataValidade;
    }

    public String getCondicoesArmazenamento() {
        return condicoesArmazenamento;
    }

    public void setCondicoesArmazenamento(String condicoesArmazenamento) {
        if (condicoesArmazenamento == null || condicoesArmazenamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Condições de armazenamento não podem ser vazias.");
        }
        this.condicoesArmazenamento = condicoesArmazenamento;
    }
    

    public boolean estaValido() {
        // If dataValidade is null for some reason, it's not valid
        if (this.dataValidade == null) {
            return false;
        }
        return !LocalDate.now().isAfter(this.dataValidade); 
    }

    @Override
    public void exibirProduto() {
        String dataFormatada = "N/A"; // Default value if null
        if (dataValidade != null) {
            dataFormatada = dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        super.exibirProduto();
        System.out.println("  Tipo: Perecível | Validade: " + dataFormatada + " | Armazenamento: " + condicoesArmazenamento + " | Válido: " + (estaValido() ? "Sim" : "Não"));
    }
}