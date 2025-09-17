package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {
    void enviarMensagem(String mensagem) throws RemoteException;

    List<String> receberMensagens() throws RemoteException;
}
