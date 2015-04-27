package ${packageName}.service.impl;

import ${packageName}.entity.${className?cap_first}Entity;
import ${packageName}.dao.${className?cap_first}Dao;
import ${packageName}.service.${className?cap_first}Service;
import ${packageName}.dao.impl.${className?cap_first}DaoImpl;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ${className?cap_first}Dao ${className?uncap_first}Dao;
	
	public void add(${className?cap_first} obj){
		${className?uncap_first}Dao.save${className?cap_first}(obj);
	}

	public void update(${className?cap_first} ${className?uncap_first}) throws Exception{
		${className?uncap_first}Dao.update${className?cap_first}(obj);
	}

	public void delete(String ids){
		${className?uncap_first}Dao.delete${className?cap_first}(obj);
	}

	public List<${className?cap_first}> listAll(){
		return ${className?uncap_first}Dao.findAll();
	}
	

}
