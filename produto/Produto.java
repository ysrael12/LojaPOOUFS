package produto;
import java.math.BigDecimal;

public class Produto{
    protected String codigo;
    protected String nome;
    protected BigDecimal precoBase;
    private int estoque;
    private static Produto[] produtosCadastrados;
    private static int codigoCadastrado = 0;

    public Produto(String nome, double precoBase, int estoque) {
        this.nome = nome;
        this.precoBase = new BigDecimal(precoBase);
        this.estoque = estoque;
        this.codigo = Integer.toString(codigoCadastrado++);
        adicionarProduto();
    }

    private void adicionarProduto() {
        Produto[] lista = new Produto[produtosCadastrados.length];
        System.arraycopy(produtosCadastrados, 0, lista, 0, lista.length+1);
        lista[produtosCadastrados.length] = this;
        produtosCadastrados = lista;
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

    public void setPrecoBase(int precoBase) {
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

}

