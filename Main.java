import ui.ConsoleMenu; 
import ui.InputUtils; 


import produto.ProdutoFisico; 
import cliente.PessoaFisica;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
       
        ConsoleMenu menu = new ConsoleMenu(); 

      
        try {
          
            new ProdutoFisico("O Senhor dos Anéis (Livro)", 50.00, 10, 0.8, "23x16x4 cm");
            new ProdutoFisico("Mouse Gamer HyperX", 150.00, 25, 0.2, "10x5x3 cm");
            new ProdutoFisico("Teclado Mecânico Redragon", 350.00, 15, 1.0, "45x15x3 cm");
            
            
            new PessoaFisica("Ana Paula Souza", "Rua das Flores, 100", "99123-4567", "111.222.333-44", LocalDate.of(1990, 1, 15));
            new PessoaFisica("Carlos Eduardo Lima", "Av. Brasil, 50", "99876-5432", "555.666.777-88", LocalDate.of(1985, 7, 20));

            new cliente.PessoaJuridica("Padaria Sabor do Pão Ltda.", "Rua do Trigo, 123", "3210-9876", "00.123.456/0001-78", "Padaria Sabor do Pão LTDA", "Sabor do Pão");


        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao popular dados iniciais: " + e.getMessage());
        }
        // -----------------------------------------------------------------------

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