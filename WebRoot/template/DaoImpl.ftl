package ${packageName}.dao.impl;

import ${packageName}.entity.${className?cap_first}Entity;
import ${packageName}.dao.${className?cap_first}Dao;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ${className?cap_first}DaoImpl extends SpringJDBCTemplate implements ${className?cap_first}Dao {

	private Log logger = LogFactory.getLog(getClass());

	public void delete${className?cap_first}(String id){
		logger.info(sql);
		getHibernateTemplate().delete(obj);
		return res;
	}

	public List<${className}> findAll(){
		String sql = "";
		List<${className}> list = getHibernateTemplate().find(sql);
		return list;
	}

	public void save${className?cap_first}(${className} obj){
		getHibernateTemplate().save(obj);
	}	

	public void update${className?cap_first}(${className} obj){
		getHibernateTemplate().save(obj);
	}
}
