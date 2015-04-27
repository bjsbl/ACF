package ${packageName}.action;

import ${packageName}.entity.${className?cap_first}Entity;
import ${packageName}.service.${className?cap_first}Service;
import ${packageName}.service.impl.${className?cap_first}ServiceImpl;
import java.util.List;
import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;


/**   
 * @Title: Action
 * @Description: ${classDesc}
 * @author ${author}
 * @date ${createDate}
 * @version V1.0   
 *
 */
 
public class ${className}Action extends ActionSupport {

	private static final Logger logger = Logger.getLogger(${className}Action.class);

	private ${className?cap_first}Service ${className?uncap_first}Service;

	/**
	 * 查询${classDesc}
	 * 
	 * @return
	 */
	public String go${className}() {
		return SUCCESS;
	}

	/**
	 * 显示${classDesc}详细
	 * 
	 * @return
	 */
	public String showDesc() {
		return SUCCESS;
	}


	/**
	 * 添加${classDesc}
	 */
	public String add() {
		return SUCCESS;
	}

	/**
	 * 编辑${classDesc}
	 */
	public String edit() {
		return SUCCESS;
	}

	/**
	 * 删除${classDesc}
	 */
	public String delete() {
		return SUCCESS;
	}
	
}
