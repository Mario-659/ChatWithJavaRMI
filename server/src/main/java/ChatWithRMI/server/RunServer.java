package ChatWithRMI.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        int port;
        if(args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        else port = 1099;

        Server server = new Server(port);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.bind("Server", server);
    }
}
