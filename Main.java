import ui.ConsoleMenu; 
import ui.InputUtils; 



public class Main {

    public static void main(String[] args) {
       
        ConsoleMenu menu = new ConsoleMenu(); 

        int escolha;
        do {
            
            escolha = menu.mostraMenu()
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
