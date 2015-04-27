package ${packageName}.dao;

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
public interface ${className?cap_first}Dao {

	/**
	 * 删除${className}
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	public void deleteById${className?cap_first}(String id);

	/**
	 * 查询所有${className}
	 * 
	 */
	public List<${className?cap_first}Entity> findAll();

	/**
	 * 根据id查询${classDesc}
	 * 
	 * @param id
	 * @return
	 */
	public ${className?cap_first}Entity get${className?cap_first}ById(String id) ;


	/**
	 * 添加${classDesc}
	 * 
	 * @param user
	 * @throws DataAccessException
	 */
	public void save(${className?cap_first}Entity obj);

	/**
	 * 更新${classDesc}
	 * 
	 * @param user
	 * @throws DataAccessException
	 */
	public void update(${className?cap_first}Entity obj);
}
