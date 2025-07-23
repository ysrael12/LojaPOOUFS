package produto;

import java.math.BigDecimal;

public interface IProduto {
	public String getCodigo();
	public void setCodigo(String codigo);
	public String getNome();
	public void setNome(String nome);
	public BigDecimal getPrecoBase();
	public void setPrecoBase(double precoBase);
	public int getEstoque(); 
	public void setEstoque(int estoque);
	public BigDecimal comprar(int quantidade);
	public void exibirProduto();
}
