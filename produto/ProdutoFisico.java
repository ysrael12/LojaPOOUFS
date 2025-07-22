package produto;

public class ProdutoFisico extends Produto{
	protected double pesoKg; 
	protected String dimensoes; 
	
	public ProdutoFisico(String nome, double precoBase, int estoque, double pesoKg, String dimensoes) {
        super(nome, precoBase, estoque); // Chama o construtor da superclasse Produto
        this.pesoKg = pesoKg;
        this.dimensoes = dimensoes;
    }
	
	public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            System.out.println("Peso não pode ser nulo ou não positivo.");
            return;
        }
        this.pesoKg = pesoKg;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        if (dimensoes == null || dimensoes.trim().isEmpty()) {
            System.out.println("Dimensões não podem ser vazias.");
            return;
        }
        this.dimensoes = dimensoes;
    }
    
    @Override  // Recomendação Java
    public void exibirProduto() {
    	super.exibirProduto(); // Chama o método da superclasse para exibir os dados comuns
        System.out.println("  Tipo: Físico | Peso: " + pesoKg + " kg | Dimensões: " + dimensoes);
    }
	
}
