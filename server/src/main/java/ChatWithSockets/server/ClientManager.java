package ChatWithSockets.server;

import ChatWithSockets.server.channels.ChannelManager;
import ChatWithSockets.shared.Client;
import ChatWithSockets.shared.Request.Request;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;

@Log4j2
public class ClientManager {
    private HashMap<Client, ClientSession> clients = new HashMap<>();
    private ChannelManager channelManager = new ChannelManager();

    public void processRequest(Request request, Client client) {
        ClientSession session = clients.get(client);
        if(session == null) {
            registerClient(client);
            processRequest(request, client);
        }
        else session.handleRequest(request, session);
    }

    public ChannelManager getChannelManager(){
        return channelManager;
    }

    private void registerClient(Client client) {
        if(clients.containsKey(client)){
            RuntimeException e = new RuntimeException("Tried to register client that was already registered." +
                    " Client=" + client + " AllClients=" + clients);
            log.debug(e.getMessage());
            throw e;
        }
        else clients.put(client, new ClientSession(client, this));
    }

}
