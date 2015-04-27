/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 上午11:26:22
 * 
 */
package com.code.stroage;

/**
 * TODO
 * 
 */
public interface Storage {

	public void upload(String source, String target);

	public void download(String target);

	public boolean exists(String target);
}
