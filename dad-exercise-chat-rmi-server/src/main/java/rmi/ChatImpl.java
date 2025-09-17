package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl extends UnicastRemoteObject implements IChat {
    private final List<String> mensagens;

    public ChatImpl() throws RemoteException {
        super();
        this.mensagens = new ArrayList<>();
    }

    @Override
    public synchronized void enviarMensagem(String mensagem) throws RemoteException {
        mensagens.add(mensagem);
        System.out.println("Mensagem recebida: " + mensagem);
    }

    @Override
    public synchronized List<String> receberMensagens() throws RemoteException {
        return List.copyOf(this.mensagens);
    }
}
