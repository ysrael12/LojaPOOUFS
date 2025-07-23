package ui;
import nota.Nota;
import produto.Produto;
import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;
import java.time.LocalDate;
import produto.*;



public class ConsoleMenu implements IConsoleMenu {

	
	public ConsoleMenu() {}

	public int mostraMenu(){
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Produtos");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Listar Notas Emitidas"); 
            System.out.println("0. Sair");
            
            // Lê a escolha do usuário usando InputUtils.
            int escolha = InputUtils.lerInt("Digite sua opção: "); 
	    return escolha;
	}
	

	    
	public boolean cadastrarProduto () {
	        System.out.println("\n--- Cadastro de Produto ---");
	        System.out.println("Qual tipo de produto deseja cadastrar?");
	        System.out.println("1- Físico");
	        System.out.println("2- Digital");
	        System.out.println("3- Perecível");
	        int tipo = InputUtils.lerInt("Escolha o tipo: ");
	
	        String nome = InputUtils.lerString("Coloque o nome: "); 
	        double precoBase = InputUtils.lerDouble("Coloque o preço base: R$"); 
	        int estoque = InputUtils.lerInt("Coloque o estoque inicial: "); 

        switch (tipo) {
            case 1: 
                double peso = InputUtils.lerDouble("Coloque o peso (kg): ");
                String dimensoes = InputUtils.lerString("Coloque as dimensões (ex: 10x20x5 cm): ");
                new ProdutoFisico(nome, precoBase, estoque, peso, dimensoes);
                break;
            case 2:
                String urlDownload = InputUtils.lerString("Coloque a URL de download: ");
                long tamanhoArquivoMB = InputUtils.lerInt("Coloque o tamanho do arquivo (MB): ");
                new ProdutoDigital(nome, precoBase, estoque, urlDownload, tamanhoArquivoMB);
                break;
            case 3:
                double pesoPerecivel = InputUtils.lerDouble("Coloque o peso (kg): ");
                String dimensoesPerecivel = InputUtils.lerString("Coloque as dimensões (ex: 10x20x5 cm): ");
                LocalDate dataValidade = InputUtils.lerData("Coloque a data de validade");
                String condicoesArmazenamento = InputUtils.lerString("Coloque as condições de armazenamento: ");
                new ProdutoPerecivel(nome, precoBase, estoque, pesoPerecivel, dimensoesPerecivel, dataValidade, condicoesArmazenamento);
                break;
            default:
                System.out.println("Opção de tipo de produto inválida.");
                return false;
        }
        System.out.println("Produto cadastrado com sucesso!");
        return true;
    }
	
	
	
	public boolean alterarProduto() { 
        System.out.println("\n--- Alterar Produto ---");
        int codigoProduto = InputUtils.lerInt("Digite o código do produto que deseja alterar: "); 
        Produto produto = Produto.getCodigoProduto(codigoProduto); 

        if (produto == null) {
            System.out.println("Produto com o código '" + codigoProduto + "' não encontrado.");
            return false;
        }

        System.out.println("Produto selecionado: " + produto.getNome());
        System.out.println("Que alteração deseja?");
        System.out.println("1- Nome\n2- Preço Base\n3- Estoque");
        int escolha = InputUtils.lerInt("Escolha uma opção: "); 

        if (escolha == 1){
            String nome = InputUtils.lerString("Coloque o novo nome: "); 
            produto.setNome(nome);
            System.out.println("Nome do produto alterado com sucesso.");
            return true;
        } else if(escolha == 2){
            double preco = InputUtils.lerDouble("Coloque o novo preço base: R$"); 
            produto.setPrecoBase(preco); 
            System.out.println("Preço do produto alterado com sucesso.");
            return true;
        } else if(escolha == 3){
            int estoque = InputUtils.lerInt("Coloque o novo estoque: ");
            produto.setEstoque(estoque);
            System.out.println("Estoque do produto alterado com sucesso.");
            return true;
        } else {
            System.out.println("Opção inválida.");
            return false;
        }
    }
	
	public boolean cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.println("Qual tipo de cliente deseja cadastrar?");
        System.out.println("1- Pessoa Física");
        System.out.println("2- Pessoa Jurídica");
        int tipo = InputUtils.lerInt("Escolha o tipo: "); 

        String nome = InputUtils.lerString("Coloque o nome: "); 
        String endereco = InputUtils.lerString("Coloque o endereco: "); 
        String numeroDeTelefone = InputUtils.lerString("Coloque o numero de telefone: "); 
        
        Cliente novoCliente;
        switch (tipo) {
            case 1: 
                String cpf = InputUtils.lerString("Coloque o CPF: "); 
                LocalDate dataNascimento = InputUtils.lerData("Coloque a data de nascimento");
                novoCliente = new PessoaFisica(nome, endereco, numeroDeTelefone, cpf, dataNascimento); 
                break;
            case 2:
                String cnpj = InputUtils.lerString("Coloque o CNPJ: ");
                String razaoSocial = InputUtils.lerString("Coloque a Razão Social: ");
                String nomeFantasia = InputUtils.lerString("Coloque o Nome Fantasia (opcional): ");
                novoCliente = new PessoaJuridica(nome, endereco, numeroDeTelefone, cnpj, razaoSocial, nomeFantasia);
                break;
            default:
                System.out.println("Opção de tipo de cliente inválida.");
                return false;
        }
        System.out.println("Cliente cadastrado com sucesso!\nBem Vindo!"+ novoCliente.getNome());
        return true;
    }
	
	public boolean alterarCliente() {
        System.out.println("\n--- Alterar Cliente ---");
        Cliente.listarClientesCadastrados(); 
        String idCliente = InputUtils.lerString("Digite o ID do cliente que deseja alterar: ");
        Cliente cliente = Cliente.getClientePorId(idCliente); 

        if (cliente == null) {
            System.out.println("Cliente com o ID '" + idCliente + "' não encontrado.");
            return false;
        }
		
        System.out.println("Cliente selecionado: " + cliente.getNome());
        System.out.println("Que alteração deseja?");
        System.out.println("1- Nome\n2- Endereço\n3- Número de telefone");
        System.out.println("4- Alterar Tipo de Cliente (Pessoa Física <-> Jurídica)"); 
        int escolha = InputUtils.lerInt("Escolha uma opção: ");
        
        // Removed try-catch block
        if (escolha == 1){
            String nome = InputUtils.lerString("Coloque o novo nome: ");
            cliente.setNome(nome);
            System.out.println("Nome do cliente alterado com sucesso.");
            return true;
        } else if (escolha == 2){
            String endereco = InputUtils.lerString("Coloque o novo endereco: ");
            cliente.setEndereco(endereco);
            System.out.println("Endereço do cliente alterado com sucesso.");
            return true;
        } else if(escolha == 3){
            String numeroDeTelefone = InputUtils.lerString("Coloque o novo numero de telefone: ");
            cliente.setNumeroDeTelefone(numeroDeTelefone);
            System.out.println("Numero de telefone do cliente alterado com sucesso.");
            return true;
        } else if (escolha == 4) { 
            
        	/* 
        	Implementação do DownCast e UpCast
        	*/
        	
        	System.out.println("Alterar tipo de cliente para:");
            System.out.println("1- Pessoa Física");
            System.out.println("2- Pessoa Jurídica");
            int novoTipoEscolha = InputUtils.lerInt("Escolha o novo tipo: ");

            Cliente novoCliente = null;
            if (cliente instanceof PessoaFisica && novoTipoEscolha == 2) {
                System.out.println("Convertendo Pessoa Física para Jurídica...");
                // Downcast para PessoaFisica para acessar propriedades específicas.
                PessoaFisica pf = (PessoaFisica) cliente; 
                
                String cnpj = InputUtils.lerString("Coloque o CNPJ: ");
                String razaoSocial = InputUtils.lerString("Coloque a Razão Social: ");
                String nomeFantasia = InputUtils.lerString("Coloque o Nome Fantasia (opcional): ");
                
                // Upcast CLIENTE -> PJ
                novoCliente = new PessoaJuridica(pf.getNome(), pf.getEndereco(), pf.getNumeroDeTelefone(), cnpj, razaoSocial, nomeFantasia);
                
            } else if (cliente instanceof PessoaJuridica && novoTipoEscolha == 1) {
                System.out.println("Convertendo Pessoa Jurídica para Física...");
                // Downcast para PessoaJuridica para acessar propriedades específicas.
                PessoaJuridica pj = (PessoaJuridica) cliente; 

                String cpf = InputUtils.lerString("Coloque o CPF: ");
                LocalDate dataNascimento = InputUtils.lerData("Coloque a data de nascimento");
                
                // Upcast CLIENTE -> PF
                novoCliente = new PessoaFisica(pj.getNome(), pj.getEndereco(), pj.getNumeroDeTelefone(), cpf, dataNascimento);
            } else {
                System.out.println("Alteração de tipo inválida ou sem mudança.");
                return false;
            }

            if (novoCliente != null) {
                if (Cliente.removerCliente(cliente)) {
                   System.out.println("Tipo de cliente alterado com sucesso!");
                   System.out.println(novoCliente.toString()); 
                   return true; 
                }
                return false; 
            }
            return false;
        } else {
            System.out.println("Opção inválida.");
            return false;	
        }
	}
	
		public void listarNotasEmitidas () { 
	        Nota.listarTodasNotasEmitidas(); 
	        }
		

	
		public void listarProdutos (){
			Produto.listarProdutosCadastrados();
		}
		
	    
		public void listarClientes (){
	        Cliente.listarClientesCadastrados(); 
		}
		
		public void criarNotaDeCompra() {
	        System.out.println("\n--- Criar Nova Nota de Compra ---");
	        Cliente.listarClientesCadastrados(); 
	        String idCliente = InputUtils.lerString("Digite o ID do cliente para esta nota: ");
	        Cliente clienteSelecionado = Cliente.getClientePorId(idCliente); 

	        if (clienteSelecionado == null) {
	            System.out.println("Cliente não encontrado. Operação cancelada.");
	            return;
	        }

	        System.out.println("Cliente selecionado: " + clienteSelecionado.getNome());
	        
	        Nota novaNota = new Nota(clienteSelecionado);
	        System.out.println("Nota " + novaNota.getId() + " criada."); 

	        boolean adicionarMaisItens = true;
	        while (adicionarMaisItens) {
	            Produto.listarProdutosCadastrados(); 
	            String codigoProdutoStr = InputUtils.lerString("Digite o código do produto para adicionar (ou '0' para finalizar): ");
	            
	            if (codigoProdutoStr.equals("0")) {
	                adicionarMaisItens = false;
	                break;
	            }
	            
	            int codigoProduto = -1;
	            codigoProduto = Integer.parseInt(codigoProdutoStr);
	            

	            Produto produtoSelecionado = Produto.getCodigoProduto(codigoProduto); 

	            if (produtoSelecionado == null) {
	                System.out.println("Produto não encontrado.");
	                continue;
	            }

	            int quantidade = InputUtils.lerInt("Digite a quantidade de " + produtoSelecionado.getNome() + ": ");

	            novaNota.adicionarProduto(produtoSelecionado, quantidade); 
	            produtoSelecionado.setEstoque( produtoSelecionado.getEstoque() - quantidade);
	            System.out.println("Item adicionado com sucesso.");

	            String continuar = InputUtils.lerString("Adicionar outro item? (s/n): ");
	            if (!continuar.equalsIgnoreCase("s")) {
	                adicionarMaisItens = false;
	            }
	        novaNota.emitirNota(); 
	    }    
	}
}