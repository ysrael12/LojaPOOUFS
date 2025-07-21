import cliente.Cliente;
public class Main {
	public static void main(String args[]) {
		Cliente client = new Cliente("A","B","C");
		System.out.println("Olá "+ client.getUUID());
		
		Cliente client1 = new Cliente("A","B","C");
		System.out.println("Olá "+ client1.getUUID());
		
		Cliente client2 = new Cliente("U","B","C");
		System.out.println("Olá "+ client2.getUUID());
		
		Cliente client3 = new Cliente("A","C","V");
		System.out.println("Olá "+ client3.getUUID());
}
}