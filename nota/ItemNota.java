package nota;
import java.math.BigDecimal;
import produto.Produto;

public class ItemNota {
    private Produto produto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemNota (Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPrecoBase().multiply(BigDecimal.valueOf(quantidade));
    }
    
    public BigDecimal getPrecoTotal() {
        return subtotal;
    }

    public void exibirItemNota(){
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Codigo: " + produto.getCodigo());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preco unitario: " + produto.getPrecoBase());
        System.out.println("Total: " + this.subtotal);
        System.out.print ("\n");
    }
    
    @Override // 
    public String toString(){
        return "  " + produto.getNome() + 
               " (Cód: " + produto.getCodigo() + 
               ") | Qtd: " + quantidade;
    }
}