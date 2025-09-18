import rmi.IChat;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatRMIClient {
    private static final int port = 2000;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Scanner scanner = new Scanner(System.in);

        Registry registry = LocateRegistry.getRegistry(port);

        IChat chat = (IChat) registry.lookup("rmi://localhost:" + port + "/chat");

        System.out.println("Bem vindo! Por favor, faça o login.");
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (!chat.autenticar(usuario, senha)) {
            System.out.println("Autenticação falhou. Encerrando aplicação.");
            System.exit(0);
        }

        System.out.println("""
                Olá! Bem-vindo ao Chat RMI.
                1 - Enviar mensagem
                2 - Enviar múltiplas mensagens
                3 - Receber mensagens
                0 - Sair
                """);

        int opcao = -1;
        while (opcao != 0) {
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> enviarMensagem(chat, scanner);
                case 2 -> enviarMultiplasMensagens(chat, scanner);
                case 3 -> receberMensagens(chat);
                case 0 -> System.out.println("Aplicação encerrada.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void enviarMensagem(IChat chat, Scanner scanner) throws RemoteException {
        System.out.print("Digite sua mensagem: ");
        scanner.nextLine();
        String mensagem = scanner.nextLine();
        chat.enviarMensagem(mensagem);
        System.out.println("Mensagem enviada com sucesso!");
    }

    public static void enviarMultiplasMensagens(IChat chat, Scanner scanner) throws RemoteException {
        List<String> mensagens = new ArrayList<>();

        scanner.nextLine();
        String mensagemAtual = "";
        while (true) {
            System.out.println("Digite 'Parar' para finalizar o envio de mensagens.");
            System.out.print("Digite sua mensagem: ");
            mensagemAtual = scanner.nextLine();
            if (mensagemAtual.equalsIgnoreCase("Parar")) {
                break;
            }
            mensagens.add(mensagemAtual);
        }

        for (String mensagem : mensagens) {
            chat.enviarMensagem(mensagem);
        }

        System.out.println(mensagens.size() + " mensagens enviadas com sucesso!");
    }

    public static void receberMensagens(IChat chat) throws RemoteException {
        System.out.println("Mensagens recebidas:");
        for (String mensagem : chat.receberMensagens()) {
            System.out.println(mensagem);
        }
        System.out.println("-- Fim das mensagens --\n");
    }
}
