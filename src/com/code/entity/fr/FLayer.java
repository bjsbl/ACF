/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 下午4:12:49
 * 
 */
package com.code.entity.fr;

/**
 * TODO
 * 
 */
public class FLayer {

	private String name;
	private String template;
	private Layer type;

	public Layer getType() {
		return type;
	}

	public void setType(Layer type) {
		this.type = type;
	}

	public FLayer(String name, String template, Layer type) {
		this.name = name;
		this.template = template;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
