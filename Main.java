import ui.ConsoleMenu; 
import ui.InputUtils; 



public class Main {

    public static void main(String[] args) {
       
        ConsoleMenu menu = new ConsoleMenu(); 

        int escolha;
        do {
            // Exibe as opções do menu principal.
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Produtos");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Listar Notas Emitidas"); // Adicionado a opção de listar notas
            System.out.println("0. Sair");
            
            // Lê a escolha do usuário usando InputUtils.
            escolha = InputUtils.lerInt("Digite sua opção: "); 

            // Direciona para o método apropriado no ConsoleMenu com base na escolha.
            switch (escolha) {
                case 1: menu.cadastrarProduto(); break;
                case 2: menu.alterarProduto(); break;
                case 3: menu.cadastrarCliente(); break; 
                case 4: menu.alterarCliente(); break;   
                case 5: menu.criarNotaDeCompra(); break;
                case 6: menu.listarProdutos(); break;
                case 7: menu.listarClientes(); break;   
                case 8: menu.listarNotasEmitidas(); break;
                case 0: System.out.println("Saindo do sistema. Até logo!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        // Fecha o Scanner ao finalizar o programa, liberando recursos.
        InputUtils.closeScanner(); 
    }
}