package ${packageName}.entity;

/**   
 * @Title: Entity
 * @Description: ${classDesc}
 * @author ${author}
 * @date ${createDate}
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class ${className?cap_first}Entity implements java.io.Serializable {

	<#if fields??>
		<#list fields as field>
		/* ${field.fieldComment} */
		private ${field.fieldType} ${field.fieldName};
		</#list>
	</#if>
	
	<#if fields??>
		<#list fields as field>
		
		public void set${field.fieldName?cap_first}(${field.fieldType} obj){
 			this.${field.fieldName} = obj;
 		}
 		public ${field.fieldType} get${field.fieldName?cap_first}(){
 			return this.${field.fieldName};
 		}
		</#list>
	</#if>
}
