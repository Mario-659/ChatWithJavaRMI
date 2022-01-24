package ChatWithRMI.client.state;

import ChatWithRMI.shared.Request.Request;
import ChatWithRMI.client.Controller;
import ChatWithRMI.shared.Request.RequestType;

public class InChannel extends State{
    public InChannel(Controller controller, String info) {
        super(controller);
        displayInfo(info + "\nTo leave channel type exit");
    }

    @Override
    public void run() {
        String input = getInput();
        while(!input.equals("exit")){
            sendRequest(RequestType.SENDMESSAGE, input);
            input = getInput();
        }
        sendRequest(RequestType.LEAVECHANNEL, "");
    }

    @Override
    public void handleRequest(Request request, Controller controller) {
        switch (request.getType()){
            case PING: break;
            case REQUESTSUCCEEDED:
                handleSucceeded();
                break;
            default:
                display(request.getPayload());
                break;
        }
    }

    private void handleSucceeded() {
        controller.changeState(new WithoutChannel(controller));
    }
}
