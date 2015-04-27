package com.code.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtils {

	private static final Logger logger = Logger.getLogger(ZipUtils.class);
	private static final int BUFFER = 1024 * 10;

	public static boolean zip(String sourceFilePath, String zipFilePath, boolean override) {
		boolean result = false;
		File source = new File(sourceFilePath);
		if (!source.exists()) {
			logger.info(sourceFilePath + " doesn't exist.");
			return result;
		}
		if (!source.isDirectory()) {
			logger.info(sourceFilePath + " is not a directory.");
			return result;
		}
		File zipFile = new File(zipFilePath);
		if (zipFile.exists()) {
			if (override) {
				logger.info(zipFile.getName() + " is already exist.but override");
				zipFile.delete();
			} else {
				logger.info(zipFile.getName() + " is already exist.");
				return result;
			}
		} else {
			if (!zipFile.getParentFile().exists()) {
				if (!zipFile.getParentFile().mkdirs()) {
					logger.info("cann't create file " + zipFilePath);
					return result;
				}
			}
		}
		FileOutputStream dest = null;
		ZipOutputStream out = null;
		try {
			dest = new FileOutputStream(zipFile);
			CheckedOutputStream checksum = new CheckedOutputStream(dest, new CRC32());
			out = new ZipOutputStream(new BufferedOutputStream(checksum));
			out.setMethod(ZipOutputStream.DEFLATED);
			compress(source, out, source.getName());
			out.setComment("Checksum: " + checksum.getChecksum().getValue());
			result = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.closeEntry();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static void compress(File file, ZipOutputStream out, String mainFileName) {
		int index = file.getAbsolutePath().indexOf(mainFileName);
		String entryName = file.getAbsolutePath().substring(index);
		if (file.isFile()) {
			FileInputStream fi = null;
			BufferedInputStream origin = null;
			try {
				fi = new FileInputStream(file);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry(entryName);
				out.putNextEntry(entry);
				byte[] data = new byte[BUFFER];
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (origin != null) {
					try {
						origin.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (file.isDirectory()) {
			try {
				out.putNextEntry(new ZipEntry(entryName + File.separator));
			} catch (IOException e) {
				e.printStackTrace();
			}
			File[] fs = file.listFiles();
			if (fs != null && fs.length > 0) {
				for (File f : fs) {
					compress(f, out, mainFileName);
				}
			}
		}
	}
}
