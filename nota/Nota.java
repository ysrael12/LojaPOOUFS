package nota;
import java.math.BigDecimal;
import java.time.LocalDate;
import produto.Produto;
import cliente.Cliente;

public class Nota{
	private Cliente pessoa;
	private BigDecimal subtotal;
	private ItemNota[] listaProdutos;
	private String id;
	private static Nota[] notasEmitidas;
	private static int ultimoId = 0;
	private LocalDate data;
	
	public Nota(Cliente pessoa) {
		this.pessoa = pessoa;
		this.subtotal = new BigDecimal(0f);
		this.id = Integer.toString(ultimoId++);
		this.data = LocalDate.now();
	}
	
	public Cliente getPessoa() {
		return this.pessoa;
	}
	
	public BigDecimal getSubtotal() {
		return this.subtotal;
	}
	
	public String getId() {
		return this.id;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public void adicionarProduto (Produto produto, int quantidade) {
        ItemNota item = new ItemNota(produto, quantidade);
        ItemNota [] listaItemNota = new ItemNota[listaProdutos.length + 1];
        System.arraycopy(listaProdutos, 0, listaItemNota, 0, listaProdutos.length);
        listaItemNota[listaProdutos.length] = item;
        listaProdutos = listaItemNota;

        subtotal = subtotal.add(item.getPrecoTotal());
    }
	
	public void exibirNota() {
	    System.out.println("Cliente: ");
	    this.pessoa.exibirCliente();
	    System.out.println("Data: " + this.data);
	    System.out.println("Produtos:");

	    for (int i = 0; i < listaProdutos.length; i++) {
	        System.out.println("- " + listaProdutos[i]);
	    }

	    System.out.println("Subtotal: R$ " + subtotal);
	}
	
	public void emitirNota () {
		Nota [] novaLista = new Nota [notasEmitidas.length + 1];
		System.arraycopy(notasEmitidas, 0, novaLista, 0, novaLista.length );
		novaLista[notasEmitidas.length] = this;
		notasEmitidas = novaLista;
		System.out.println ("Subtotal: " + this.subtotal);
		System.out.println("Itens da compra: ");
		
        for (int i = 0; i < listaProdutos.length; i++) {
        	listaProdutos[i].exibirItemNota();
        }
    }
	
}
