package com.code.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.code.core.Processor;
import com.code.entity.ClassMeta;
import com.code.entity.DBMeta;
import com.code.entity.fr.FLayer;
import com.code.entity.fr.impl.Spring;
import com.code.utils.ZipUtils;

@Controller
@RequestMapping("/generator")
public class GeneratorController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private Processor processor;

	@RequestMapping(value = "/emit", method = RequestMethod.POST)
	public String processing(HttpServletResponse resp, HttpServletRequest request, DBMeta db, ClassMeta bean, boolean framework) throws IOException {
		long start = System.currentTimeMillis();
		logger.info("Start to Process.");
		processor.setClassmeta(bean);
		processor.setDBmeta(db);
		processor.setRequest(request);
		processor.readTableColumns();
		Spring spring = new Spring();
		List<FLayer> depends = spring.dependence();
		for (FLayer layer : depends) {
			processor.generateFile(layer);
		}
		logger.debug("Start to Compress Files.");
		ZipUtils.zip(processor.getOutPath(), processor.getOutFile(), true);
		logger.debug("Finish to Compression");
		long cost = System.currentTimeMillis() - start;
		logger.info("Finish to Process.Cost:" + cost);

//		LocalStorage storage = new LocalStorage();
//		storage.setResp(resp);
//		storage.upload(processor.getOutFile(), "e://aaa.zip");
//
//		FTPStorage ftp = new FTPStorage();
//		ftp.upload(processor.getOutFile(), "acf1.zip");

//		processor.release();
		return "success";
	}

}
