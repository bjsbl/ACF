package com.code.utils;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf("0:") != -1) {
			ip = "localhost";
		}
		return ip;
	}

	public static boolean Ping(String ip, int port) {
		Socket client = null;
		boolean rs = false;
		try {
			client = new Socket(ip, port);
			rs = client.isConnected();
		} catch (UnknownHostException e) {
			rs = false;
		} catch (IOException e) {
			rs = false;
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {

				}
			}
		}
		return rs;
	}
}
