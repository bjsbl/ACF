/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 上午11:29:59
 * 
 */
package com.code.stroage.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.code.stroage.Storage;

/**
 * TODO
 * 
 */
public class FTPStorage implements Storage {

	private static final int BUFFER_SIZE = 1024;

	private String ftp_ip = "172.16.9.200";
	private String ftp_username = "baoliang.shen";
	private String ftp_password = "p@ssw0rd123";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.stroage.Storage#upload(java.lang.String, java.lang.String)
	 */
	@Override
	public void upload(String source, String target) {
		// TODO Auto-generated method stub
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		try {
			ftpClient.connect(ftp_ip);
			ftpClient.login(ftp_username, ftp_password);

			File srcFile = new File(source);
			fis = new FileInputStream(srcFile);
			ftpClient.changeWorkingDirectory("/ftp");
			ftpClient.setBufferSize(BUFFER_SIZE);
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(target, fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.stroage.Storage#download(java.lang.String)
	 */
	@Override
	public void download(String target) {
		// TODO Auto-generated method stub
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;

		try {
			ftpClient.connect(ftp_ip);
			ftpClient.login(ftp_username, ftp_password);

			String remoteFileName = "/admin/pic/3.gif";
			fos = new FileOutputStream("c:/down.gif");

			ftpClient.setBufferSize(BUFFER_SIZE);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.retrieveFile(remoteFileName, fos);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fos);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.stroage.Storage#exists(java.lang.String)
	 */
	@Override
	public boolean exists(String target) {
		// TODO Auto-generated method stub
		return false;
	}
}
