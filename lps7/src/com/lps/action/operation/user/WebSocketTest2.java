package com.lps.action.operation.user;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//@ServerEndpoint("/ws/websocket")
public class WebSocketTest2 {

	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {
		System.out.println("*******");
		session.getBasicRemote().sendText("  this is  message");
		int sentMessage = 0;

		while (sentMessage < 3) {
			Thread.sleep(5000);
			session.getBasicRemote().sendText("this is one mess " + sentMessage);
			sentMessage++;
		}

	}

//	@OnOpen
	/*public void onOpen(){
		
	}*/
	
	public void kk(){
		
	}
	
	/*public void onOpen(){
		System.out.println(" client connected ");
	}*/
	
	  /*  public void onOpen(){
	        System.out.println();
	    }*/

	/*
	 * @OnMessage     public void onMessage(String message,Session session)
	 *             throws IOException, InterruptedException        {
	 *         System.out.println("***************");
	 *         session.getBasicRemote().sendText("  this is  message");
	 *         int sentMessage = 0;         while(sentMessage < 3){
	 *             Thread.sleep(5000);
	 *             session.getBasicRemote().sendText(" this is one mess " +
	 * sentMessage);             sentMessage++;         }
	 *         session.getBasicRemote().sendText(" message send over ");     }
	 */

}
