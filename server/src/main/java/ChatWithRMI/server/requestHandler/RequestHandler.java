package ChatWithRMI.server.requestHandler;

import ChatWithRMI.server.ClientSession;
import ChatWithRMI.server.channels.ChannelManager;
import ChatWithRMI.shared.Request.Request;

public class RequestHandler {
    private State state;

    public RequestHandler(ClientSession session, ChannelManager channelManager){
        this.state = new WithoutChannel(session, channelManager);
    }

    public void handleRequest(Request request){
        state.handleRequest(request);
    }

    protected void changeState(State state){
        this.state = state;
    }
}
