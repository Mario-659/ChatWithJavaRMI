package ChatWithSockets.server;

import ChatWithSockets.server.channels.Channel;
import ChatWithSockets.server.util.IDManager;
import ChatWithSockets.shared.Client;
import ChatWithSockets.shared.Request.Request;
import lombok.Getter;

import java.rmi.RemoteException;

@Getter
public class ClientSession {
    private final int sessionID;
    private final Client client;
    private final ClientManager clientManager;
    private boolean isInChannel;
    private Channel channel;

    public ClientSession(Client client, ClientManager clientManager) {
        this.sessionID = IDManager.getFreeId();
        this.client = client;
        this.clientManager = clientManager;
        isInChannel = false;
        channel = null;
    }

    public void setChannel(Channel channel){
        isInChannel = channel != null;
        this.channel = channel;
    }

    public void sendRequest(Request request){
        try {
            client.sendRequest(request);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ClientSession{" +
                "id=" + sessionID +
                ", client=" + client +
                ", manager=" + clientManager +
                ", isInChannel=" + isInChannel +
                ", channel=" + channel.getChannelName() +
                '}';
    }
}
