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
        this.dataValidade = dataValidade;
        this.condicoesArmazenamento = condicoesArmazenamento;
    }

    // --- Getters e Setters específicos ---
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCondicoesArmazenamento() {
        return condicoesArmazenamento;
    }

    public void setCondicoesArmazenamento(String condicoesArmazenamento) {
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