package com.lps.action.operation.user;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.lps.service.ServerOrderService;
import com.lps.service.impl.ServerOrderServiceImpl;

@ServerEndpoint("/ws/websocket")  
public class WebSocketTest {  
	
	private ServerOrderService serverOrderServiceImpl = new ServerOrderServiceImpl();
  
    public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	@OnMessage  
    public void onMessage(String message,Session session)  
            throws IOException, InterruptedException  
       {  
        System.out.println("***************");  
        System.out.println(serverOrderServiceImpl);
        session.getBasicRemote().sendText("  this is  message");  
        int sentMessage = 0;  
//        System.out.println("session.getId() : " + session.getId());
        System.out.println("session.getId() : " + this.toString());
        while(sentMessage < 3){  
            Thread.sleep(5000);  
            
            session.getBasicRemote().sendText(" this is one mess " + sentMessage);  
//            session.getBasicRemote().
            sentMessage++;  
        }  
        session.getBasicRemote().sendText(" message send over ");  
    }  
      
    @OnOpen  
    public void onOpen(){  
        System.out.println(" client connected ");  
    }  
      
    @OnClose  
    public void onClose(){  
        System.out.println(" connection closed ");  
    }  
}  