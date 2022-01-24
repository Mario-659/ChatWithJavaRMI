package ChatWithRMI.shared;

import ChatWithRMI.shared.Request.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
    void sendRequest(Request request) throws RemoteException;
}
