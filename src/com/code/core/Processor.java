package com.code.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.code.dao.DBHandler;
import com.code.dao.impl.MySqlDBHandler;
import com.code.dao.impl.OracleDBHandler;
import com.code.entity.ClassMeta;
import com.code.entity.DBMeta;
import com.code.entity.TableMeta;
import com.code.entity.fr.FLayer;
import com.code.utils.Constants;
import com.code.utils.DBUtils;
import com.code.utils.IpUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class Processor {

	private Logger logger = Logger.getLogger(this.getClass());

	private HttpServletRequest request;
	private DBMeta dbmeta;
	private ClassMeta classmeta;
	private TableMeta table;
	private HashMap<String, Object> paramMap = new HashMap<String, Object>();

	public ClassMeta getClassmeta() {
		return classmeta;
	}

	public void setClassmeta(ClassMeta classmeta) {
		this.classmeta = classmeta;
	}

	public DBMeta getDbmeta() {
		return dbmeta;
	}

	public void setDBmeta(DBMeta dbmeta) {
		this.dbmeta = dbmeta;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private String getClientId() {
		return IpUtil.getIpAddr(request);
	}

	private String getWebRoot() {
		return request.getSession().getServletContext().getRealPath(File.separator);
	}

	public String getOutPath() {
		return getWebRoot() + getClientId() + File.separator;
	}

	public String getOutFile() {
		return getWebRoot() + getClientId() + ".zip";
	}

	private Configuration getConfiguration() throws IOException {
		Configuration localConfiguration = new Configuration();
		String str = getWebRoot() + Constants.BASE_TEMPLATE_PATH;
		File localFile = new File(str);
		localConfiguration.setDirectoryForTemplateLoading(localFile);
		localConfiguration.setLocale(Locale.CHINA);
		localConfiguration.setDefaultEncoding("UTF-8");
		return localConfiguration;
	}

	private String getCodePath(FLayer template, String packageName, String entityName) {
		String str1 = getWebRoot() + getClientId() + File.separator;
		StringBuilder stringBuilder = new StringBuilder(str1);
		stringBuilder = stringBuilder.append(packageName).append(StringUtils.lowerCase(entityName)).append(File.separator);
		switch (template.getType()) {
		case Controller:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case Service:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case Dao:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case DaoImpl:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case ServiceImpl:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case Model:
			stringBuilder.append(template.getName()).append(entityName).append(".java");
			break;
		case View:
			stringBuilder = new StringBuilder(str1);
			stringBuilder.append("WebRoot").append(File.separator);
			stringBuilder.append(template.getName()).append(".jsp");
			break;
		}
		return stringBuilder.toString();
	}

	public void generateFile(FLayer template) {
		long start = System.currentTimeMillis();
		paramMap.put(Constants.TEMPLATE_FIELD_AUTHOR, classmeta.getAuthor());
		paramMap.put(Constants.TEMPLATE_FIELD_CLASSDESC, classmeta.getClassDesc());
		paramMap.put(Constants.TEMPLATE_FIELD_CLASSNAME, classmeta.getClassFullName());
		paramMap.put(Constants.TEMPLATE_FIELD_CREATEDATE, classmeta.getCreatedate());
		paramMap.put(Constants.TEMPLATE_FIELD_PACKAGENAME, classmeta.getPackageName());
		paramMap.put(Constants.TEMPLATE_FIELD_FIELDS, table.getColumns());
		try {
			String str1 = paramMap.get(Constants.TEMPLATE_FIELD_PACKAGENAME).toString().replace(".", File.separator);
			String str2 = paramMap.get(Constants.TEMPLATE_FIELD_CLASSNAME).toString();
			String str3 = getCodePath(template, str1, str2);
			String str4 = StringUtils.substringBeforeLast(str3, File.separator);
			FileUtils.forceMkdir(new File(str4 + File.separator));
			Template localTemplate = getConfiguration().getTemplate(template.getTemplate());
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(str3), Constants.SYSTEM_ENCODING);
			localTemplate.process(paramMap, writer);
			writer.close();
		} catch (TemplateException localTemplateException) {
			localTemplateException.printStackTrace();
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
		logger.info("Build " + template.getName() + " Done \t Cost:" + ((System.currentTimeMillis() - start)));
	}

	public void readTableColumns() {
		Connection conn = DBUtils.getInstance(dbmeta);
		DBHandler handler = null;
		if (dbmeta.getClassName().indexOf("mysql") > 0) {
			handler = new MySqlDBHandler();
		} else if (dbmeta.getClassName().indexOf("oracle") > 0) {
			handler = new OracleDBHandler();
		}
		if (handler != null) {
			try {
				table = handler.getTableMeta(conn, classmeta.getTableName());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void release() {
		File file = new File(getOutPath());
		if (file.exists() && file.isDirectory()) {
			logger.info(" delete source files .... done");
			try {
				FileUtils.deleteDirectory(file);
			} catch (IOException e) {
				try {
					FileUtils.forceDelete(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		file = new File(getOutFile());
		if (file.exists() && file.isDirectory()) {
			logger.info(" delete zip files .... done");
			try {
				FileUtils.deleteDirectory(file);
			} catch (IOException e) {
				try {
					FileUtils.forceDelete(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
