package com.lps.util;

public class Test extends LinkParamCreater {

	int bbbb = 2222;
	
	String kk = null;
	
	public static void main(String[] args) {
		LinkParamCreater l = new Test();
		System.out.println(LinkParamCreater.createLinkParam(l, "hhh"));
	}
	
}
