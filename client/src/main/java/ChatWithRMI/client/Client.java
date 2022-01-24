package ChatWithRMI.client;

import ChatWithRMI.shared.Request.Request;
import ChatWithRMI.shared.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements ChatWithRMI.shared.Client {
    Controller controller;

    public Client(int clientPort) throws  RemoteException {
        UnicastRemoteObject.exportObject(this, clientPort);
    }

    @Override
    public void sendRequest(Request request) throws RemoteException {
        controller.processRequest(request);
    }

    public void startClient(int serverPort) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", serverPort);
        Server server = (Server) registry.lookup("Server");
        controller = new Controller(this, server);
        controller.start();
    }
}
