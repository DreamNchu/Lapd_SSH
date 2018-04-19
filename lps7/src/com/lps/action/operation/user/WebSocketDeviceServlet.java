/*package com.lps.action.operation.user;

import javax.servlet.http.HttpServletRequest;

public class WebSocketDeviceServlet extends org.apache.catalina.websocket.WebSocketServlet {

	private static  long serialVersionUID = 1L;

	@Override
	protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {

		WebSocketDeviceInbound newClientConn = new WebSocketDeviceInbound(request);
		WebSocketDeviceInboundPool.addMessageInbound(newClientConn);
		return newClientConn;

	}

}*/