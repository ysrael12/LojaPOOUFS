package cliente;
import java.util.UUID;

/* Classe Abstrata de Cliente */

public abstract class Cliente implements ICliente {
    protected UUID id; 
    protected String nome; 
    protected String endereco; 
    protected String numeroDeTelefone; 

    private static Cliente[] clientesCadastrados = new Cliente[0];

    public Cliente(String nome, String endereco, String numeroDeTeletelefone){
        this.id = UUID.randomUUID();
        this.nome = nome; 
        this.endereco = endereco; 
        this.numeroDeTelefone = numeroDeTeletelefone;
        
        adicionarClienteInterno(this); 
    }
    
    private static void adicionarClienteInterno(Cliente cliente) {
        Cliente[] novaLista = new Cliente[clientesCadastrados.length + 1];
        System.arraycopy(clientesCadastrados, 0, novaLista, 0, clientesCadastrados.length);
        novaLista[clientesCadastrados.length] = cliente;
        clientesCadastrados = novaLista;
        System.out.println("Cliente '" + cliente.getNome() + "' (ID: " + cliente.getId() + ") cadastrado.");
    }

    public static boolean removerCliente(Cliente clienteParaRemover) {
        if (clienteParaRemover == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < clientesCadastrados.length; i++) {
            if (clientesCadastrados[i].getId().equals(clienteParaRemover.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Cliente[] novaLista = new Cliente[clientesCadastrados.length - 1];
            System.arraycopy(clientesCadastrados, 0, novaLista, 0, index);
            System.arraycopy(clientesCadastrados, index + 1, novaLista, index, clientesCadastrados.length - index - 1);
            clientesCadastrados = novaLista;
            System.out.println("Cliente '" + clienteParaRemover.getNome() + "' removido da lista.");
            return true;
        }
        return false;
    }

    public static Cliente getClientePorId(String idString) {
        UUID idBusca = UUID.fromString(idString); 
        for (Cliente c : clientesCadastrados) {
            if (c != null && c.getId().equals(idBusca)) {
                return c;
            }
        }
        System.out.println("Cliente com ID '" + idString + "' não encontrado.");
        return null;
    }

    public static void listarClientesCadastrados() {
        if (clientesCadastrados.length == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Cliente c : clientesCadastrados) {
            c.exibirCliente(); 
        }
        System.out.println("----------------------------");
    }

    public void setNome(String nome) {
        this.nome = nome; 
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco; 
    }
    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }
    public UUID getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public String getNumeroDeTelefone() {
        return this.numeroDeTelefone;
    }

    public void exibirCliente() {
        System.out.println("Cliente ID: " + this.id + " | Nome: " + this.nome + " | Endereço: " + this.endereco + " | Telefone: " + this.numeroDeTelefone);
    }
}