package com.lps.web.socket;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.lps.action.operation.order.CreateOrderAction;
import com.lps.service.ServerOrderService;
import com.lps.service.impl.ServerOrderServiceImpl;

@ServerEndpoint(value="/server/websocket",configurator=GetHttpSessionConfigurator.class)  
public class OrderReceiveWebSocket {  
	
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
    public void onOpen(@PathParam("userId")String userId,Session session){  
    	System.out.println(" connection open");  
    	
    	
    	System.out.println(session.getClass().getName());
    	System.out.println(userId);
//    	HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        System.out.println( httpSession.getAttribute("name"));
//        System.out.println("httpSession.getAttribute(userName) : " + httpSession.getAttribute("userName"));
//    	CreateOrderAction.userSessionWebSocket.put(httpSession, this);
//        sessionMap.put(session.getId(), session); 
    	
    }  
      
    @OnClose  
    public void onClose(@PathParam("userId")String userId,Session session){
    	
        System.out.println(" connection closed ");  
//        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        System.out.println( httpSession.getAttribute("name"));
//        CreateOrderAction.userSessionWebSocket.remove(session);
        
    }  
}  