package produto;

public class ProdutoDigital extends Produto implements IProduto {
	protected String urlDownload; 
	protected long tamanhoDoArquivoEmMb; 
	
	public ProdutoDigital(String nome, double precoBase, int estoque, String urlDownload, long tamanhoDoArquivoEmMb) {
		super(nome, precoBase, estoque);
		this.urlDownload = urlDownload;
		this.tamanhoDoArquivoEmMb = tamanhoDoArquivoEmMb;
	}
	
	public String getUrlDownload() {
        return urlDownload;
    }

    public void setUrlDownload(String urlDownload) {
        if (urlDownload == null || urlDownload.trim().isEmpty()) {
            System.out.println("URL de download não pode ser vazia.");
            return;
        }
        this.urlDownload = urlDownload;
    }

    public long getTamanhoArquivoMB() {
        return this.tamanhoDoArquivoEmMb;
    }

    public void setTamanhoArquivoMB(long tamanhoArquivoMB) {
        if (tamanhoArquivoMB <= 0) {
            return;
        }
        this.tamanhoDoArquivoEmMb = tamanhoArquivoMB;
    }
    
    @Override
    public void exibirProduto() {
        super.exibirProduto(); // Chama o método da superclasse
        System.out.println("  Tipo: Digital | URL Download: " + this.urlDownload + " | Tamanho: " + this.tamanhoDoArquivoEmMb);
    }

	
}
