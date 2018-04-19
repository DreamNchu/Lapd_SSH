/*package com.lps.action.operation.user;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.annotations.JSON;

public class WebSocketDeviceInbound extends MessageInbound {
	private  HttpServletRequest request;
	private DeviceAccount connectedDevice;

	public DeviceAccount getConnectedDevice() {
		return connectedDevice;
	}

	public void setConnectedDevice(DeviceAccount connectedDevice) {
		this.connectedDevice = connectedDevice;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public WebSocketDeviceInbound(HttpServletRequest request) {
		this.request = request;
		DeviceAccount connectedDa = (DeviceAccount) request.getSession(true).getAttribute("connectedDevice");
		if (connectedDa == null) {
			String deviceId = request.getParameter("id");
			DeviceAccountDao deviceDao = new DeviceAccountDao();
			connectedDa = deviceDao.getDaById(Integer.parseInt(deviceId));
		}
		this.setConnectedDevice(connectedDa);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {

	}

	@Override
	protected void onClose(int status) {
		WebSocketDeviceInboundPool.removeMessageInbound(this);

	}

	@Override
	protected void onBinaryMessage(ByteBuffer message) throws IOException {
		throw new UnsupportedOperationException("Binary message not supported.");
	}

	@Override
	protected void onTextMessage(CharBuffer message) throws IOException {
		WebSocketDeviceInboundPool.processTextMessage(this, message.toString());

	}

	public void sendMessage(BaseEvent event) {
		String eventStr = JSON.toJSONString(event);
		try {
			this.getWsOutbound().writeTextMessage(CharBuffer.wrap(eventStr));
			// …以下代码省略
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}*/