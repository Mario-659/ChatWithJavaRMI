package ChatWithRMI.server.requestHandler;

import ChatWithRMI.server.ClientSession;
import ChatWithRMI.server.channels.ChannelManager;
import ChatWithRMI.shared.Request.Request;
import ChatWithRMI.shared.Request.RequestType;


public class InChannel extends State {

    protected InChannel(ClientSession session, ChannelManager manager){
        super(session, manager);
    }

    @Override
    void handleRequest(Request request) {
        switch (request.getType()) {
            case SENDMESSAGE:
                handleSendMessage(request);
                break;
            case LEAVECHANNEL:
                handleLeaveChannel(request);
                break;
            default:
                handleInvalReq(request);
                break;
        }
    }

    private void handleLeaveChannel(Request request) {
        channelManager.leaveChannel(session);
        changeToWithoutChannel();
        sendRequest(RequestType.REQUESTSUCCEEDED,
                "Left channel");
    }

    private void handleSendMessage(Request request) {
        session.getChannel().sendChatMessage(
                request.getPayload(), session);
    }

    private void changeToWithoutChannel(){
        session.getReqHandler().changeState(
                new WithoutChannel(session, channelManager));
    }
}
