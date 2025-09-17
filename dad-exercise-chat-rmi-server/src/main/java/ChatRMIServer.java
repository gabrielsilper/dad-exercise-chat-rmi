import rmi.ChatImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatRMIServer {
    private static final int port = 2000;

    public static void main(String[] args) throws RemoteException {
        ChatImpl chat = new ChatImpl();

        Registry registry = LocateRegistry.createRegistry(port);

        registry.rebind("rmi://localhost:" + port + "/chat", chat);

        System.out.println("Servidor RMI escutando na porta " + port + "...");
    }
}
