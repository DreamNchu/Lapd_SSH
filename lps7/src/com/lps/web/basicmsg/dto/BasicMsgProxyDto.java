package com.lps.web.basicmsg.dto;

import java.util.Map;

import com.lps.util.WorkJson;

public class BasicMsgProxyDto {

	private BasicRespondMsgDto msgDto;
	
	public BasicMsgProxyDto() {
		msgDto = new BasicRespondMsgDto();
	}
	
	/**
	 * 恢复原来的数据模型
	 */
	public void regress(){
		msgDto = new BasicRespondMsgDto();
	}

	public BasicRespondMsgDto getMsgDto() {
		return msgDto;
	}

	public void setMsgDto(BasicRespondMsgDto msgDto) {
		this.msgDto = msgDto;
	}

	public void writeInJsonData(StringBuilder jsonData) {
		jsonData.replace(0, jsonData.length(), WorkJson.toJsonDisableHtmlEscaping(msgDto));
//		jsonData.
	}

	public void setDefaultErrorMsg(){
		msgDto.setDefaultErrorMsg();
	}
	
	public void setDefaultSuccessMsg(){
		msgDto.setDefaultSuccessMsg();
	}
	
	public Map<String, Object> getMap() {
		return msgDto.getMap();
	}
	/**
	 * 默认值为：执行失败
	 * @param value
	 */
	public void setErrorMsg(Object value){
		msgDto.setErrorMsg(value);
	}
	
	public void appendErrorMsg(String value) throws Exception{
		msgDto.appendErrorMsg(value);
	}
	
	public void appendSuccessMsg(String value) throws Exception{
		msgDto.appendSuccessMsg(value);
	}
	
	public Object getErrorMsg(){
		return msgDto.getErrorMsg();
	}
	
	/**
	 * 默认值为：执行成功
	 * @param value
	 */
	public void setSuccessMsg(Object value){
		msgDto.setSuccessMsg(value);
	}
	
	public Object getSuccessMsg(){
		return msgDto.getSuccessMsg();
	}

}
