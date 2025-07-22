package produto;
import java.math.BigDecimal;

public class Produto{
    protected String codigo;
    protected String nome;
    protected BigDecimal precoBase;
    private int estoque;
    
    private static Produto[] produtosCadastrados = new Produto[0]; 
    private static int codigoCadastrado = 1;

    public Produto(String nome, double precoBase, int estoque) {
        this.nome = nome;
        this.precoBase = new BigDecimal(precoBase);
        this.estoque = estoque;
        this.codigo = Integer.toString(codigoCadastrado++);
        adicionarProduto();
    }

    private void adicionarProduto() {
        Produto[] novaLista = new Produto[produtosCadastrados.length + 1];
        // FIX: The last parameter should be produtosCadastrados.length, not novaLista.length
        System.arraycopy(produtosCadastrados, 0, novaLista, 0, produtosCadastrados.length); 
        novaLista[produtosCadastrados.length] = this;
        produtosCadastrados = novaLista;
        System.out.println("Produto '" + this.nome + "' (Código: " + this.codigo + ") cadastrado.");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        if(precoBase < 0) {
            System.out.println("O preco nao pode ser menor que 0.");
            return;
        }
        this.precoBase = new BigDecimal(precoBase);
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if(estoque < 0) {
            System.out.println("O estoque nao pode ser menor que 0.");
        }
        this.estoque = estoque;
    }

    public BigDecimal comprar(int quantidade) {
        if(this.estoque == 0) {
            System.out.println("Estoque vazio.");
            return BigDecimal.ZERO;
        }
        this.estoque -= quantidade;
        return precoBase.multiply(new BigDecimal(quantidade));
    }

    public static Produto getCodigoProduto(int codigo) {
        for(int i = 0; i <= produtosCadastrados.length; i++) {
            if(produtosCadastrados[i].getCodigo().equals(Integer.toString(codigo))) {
                return produtosCadastrados[i];
            }
        }
        return null;
    }

    public void exibirProduto() {
        System.out.println("Produto "+this.codigo+": "+this.nome+" "+this.estoque+" R$"+this.precoBase);
    }
    
    public static void listarProdutosCadastrados() {
        if (produtosCadastrados.length == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n--- Produtos Cadastrados ---");
        for (Produto p : produtosCadastrados) {
            p.exibirProduto(); // Chama o método de exibição polimórfico para cada produto
        }
        System.out.println("----------------------------");
    }
}

