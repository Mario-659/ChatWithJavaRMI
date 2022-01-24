package ChatWithRMI.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        Integer serverPort = null;
        Integer clientPort = null;
        if(args.length == 1) serverPort = Integer.parseInt(args[0]);
        else if(args.length == 2){
            serverPort = Integer.parseInt(args[0]);
            clientPort = Integer.parseInt(args[1]);
        }
        if(serverPort == null) serverPort = 1099;
        if(clientPort == null) clientPort = 0;

        Client client = new Client(clientPort);
        client.startClient(serverPort);
    }
}
