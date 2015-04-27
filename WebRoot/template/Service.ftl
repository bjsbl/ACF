package ${packageName}.service;

import ${packageName}.entity.${className?cap_first}Entity;
import java.util.List;

/**   
 * @Title: Action
 * @Description: ${classDesc}
 * @author ${author}
 * @date ${createDate}
 * @version V1.0   
 *
 */
public interface ${className?cap_first}Service {
	
	/**
	 * 保存 ${className?uncap_first}
	 * 
	 * @param ${className?uncap_first}
	 */
	public void add(${className?cap_first}Entity obj);

	/**
	 * 修改${className?uncap_first}
	 * 
	 * @param ${className?uncap_first}
	 */
	public void update(${className?cap_first}Entity obj) throws Exception;

	/**
	 * 删除${className?uncap_first}
	 * 
	 * @param ids
	 */
	public void delete(String ids);

	/**
	 * 查询${className?uncap_first}
	 */
	public List<${className?cap_first}Entity> listAll(${className?cap_first} ${className?uncap_first});
	
}
