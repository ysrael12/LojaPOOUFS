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
	private LocalDate data;
	
	private static Nota[] notasEmitidas = new Nota[0]; 
	private static int ultimoId = 0;

	public Nota(Cliente pessoa) {
		this.pessoa = pessoa;
		this.subtotal = new BigDecimal(0f);
		this.id = Integer.toString(ultimoId++);
		this.data = LocalDate.now();
		this.listaProdutos = new ItemNota[0];
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
	    System.out.println("ID da nota: "+ this.id);
	    System.out.println("Produtos:");

	    for (int i = 0; i < listaProdutos.length; i++) {
	        System.out.println("- " + listaProdutos[i]);
	    }

	    System.out.println("Subtotal: R$ " + subtotal);
	}
	
	
	public void emitirNota () {
		Nota [] novaListaNotas = new Nota [notasEmitidas.length + 1];
		System.arraycopy(notasEmitidas, 0, novaListaNotas, 0, notasEmitidas.length ); 
		novaListaNotas[notasEmitidas.length] = this;
		notasEmitidas = novaListaNotas;

		System.out.println ("\n--- Nota " + this.id + " EMITIDA ---");
        this.exibirNota(); 
    }
	
	
	public static void listarTodasNotasEmitidas() {
        if (notasEmitidas.length == 0) {
            System.out.println("Nenhuma nota emitida.");
            return;
        }
        System.out.println("\n--- Todas as Notas Emitidas ---");
        System.out.println("Total de Notas: " + notasEmitidas.length);
        System.out.println("----------------------------------------------");
        for (Nota n : notasEmitidas) {
            if (n != null) {
                n.exibirNota(); 
                System.out.println("==============================================");
            }
        }
        System.out.println("--- Fim da Lista de Notas Emitidas ---");
    }
	
	@Override
    public String toString() {
        return "Nota [ID=" + id + ", Cliente=" + pessoa.getNome() + ", Data=";
    }
}
