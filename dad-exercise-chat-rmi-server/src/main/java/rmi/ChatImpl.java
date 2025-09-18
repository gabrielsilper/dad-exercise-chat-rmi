package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatImpl extends UnicastRemoteObject implements IChat {
    private final List<String> mensagens;
    private final Map<String,String> usuarios;

    public ChatImpl() throws RemoteException {
        super();
        this.mensagens = new ArrayList<>();
        this.usuarios = new HashMap<>();

        usuarios.put("gabrielpereira", "password123");
        usuarios.put("fulanodasilva", "senha123");
        usuarios.put("edwardcullen", "bela1234");
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

    @Override
    public boolean autenticar(String usuario, String senha) throws RemoteException {
        if (usuarios.containsKey(usuario)){
            return usuarios.get(usuario).equalsIgnoreCase(senha);
        }
        return false;
    }
}
