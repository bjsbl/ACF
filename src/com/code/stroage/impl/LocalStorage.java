/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 上午11:29:36
 * 
 */
package com.code.stroage.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.code.stroage.Storage;

/**
 * TODO
 * 
 */
public class LocalStorage implements Storage {

	private HttpServletResponse resp;

	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.stroage.Storage#upload(java.lang.String, java.lang.String)
	 */
	@Override
	public void upload(String source, String target) {
		// TODO Auto-generated method stub
		File srcDir = new File(source);
		if (srcDir.exists()) {
			File destDir = new File(target);
			destDir.delete();
			try {
				FileUtils.copyFile(srcDir, destDir);
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
		try {
			if (target != null && !"".equals(target)) {
				String name = target.substring(target.lastIndexOf("/") + 1);
				String fileName = URLEncoder.encode(name, "UTF-8");
				File destFile = new File(target);

				resp.reset();
				resp.addHeader("Content-Disposition", "attachment;filename=" + fileName);
				resp.addHeader("Content-Length", String.valueOf(destFile.length()));
				resp.setContentType("application/octet-stream;charset=UTF-8");
				FileInputStream in = new FileInputStream(target);
				ServletOutputStream os = resp.getOutputStream();
				byte[] buffer = new byte[1024];
				while (((in.read(buffer)) != -1)) {
					os.write(buffer, 0, buffer.length);
				}
				os.flush();
				os.close();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
