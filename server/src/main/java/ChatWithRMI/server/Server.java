package ChatWithRMI.server;

import ChatWithRMI.shared.Client;
import ChatWithRMI.shared.Request.Request;
import lombok.extern.log4j.Log4j2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Log4j2
public class Server implements ChatWithRMI.shared.Server {
    ClientManager clientManager = new ClientManager(this);

    public Server(int port) throws RemoteException {
        log.debug("Starting server at port " + port);
        UnicastRemoteObject.exportObject(this, port);
        log.debug("Server started");
    }

    @Override
    public void sendRequest(Request request, Client client) throws RemoteException {
        clientManager.processRequest(request, client);
    }
}
