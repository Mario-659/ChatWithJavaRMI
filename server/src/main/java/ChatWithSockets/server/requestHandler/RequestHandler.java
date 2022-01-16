package ChatWithSockets.server.requestHandler;

import ChatWithSockets.server.ClientSession;
import ChatWithSockets.server.channels.ChannelManager;
import ChatWithSockets.server.requestHandler.State;
import ChatWithSockets.shared.Request.Request;

public class RequestHandler {
    private State state;

    public RequestHandler(ClientSession session, ChannelManager channelManager){
        this.state = new WithoutChannel(session, channelManager);
    }

    public void handleRequest(Request request, ClientSession session){
        state.handleRequest(request);
    }

    protected void changeState(State state){
        this.state = state;
    }
}
