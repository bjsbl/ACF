/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 下午4:05:51
 * 
 */
package com.code.entity.fr.impl;

import java.util.ArrayList;
import java.util.List;

import com.code.entity.fr.FLayer;
import com.code.entity.fr.FRBase;
import com.code.entity.fr.Layer;

/**
 * TODO
 * 
 */
public class Spring implements FRBase {

	private boolean isDefault = true;

	private List<FLayer> getDefault() {
		List<FLayer> flist = new ArrayList<FLayer>();
		flist.add(new FLayer("Controller", "spring/Controller.ftl", Layer.Controller));
		flist.add(new FLayer("Service", "spring/Service.ftl", Layer.Service));
		flist.add(new FLayer("ServiceImpl", "spring/ServiceImpl.ftl", Layer.Service));
		flist.add(new FLayer("Dao", "spring/Dao.ftl", Layer.Dao));
		flist.add(new FLayer("DaoImpl", "spring/DaoImpl.ftl", Layer.Dao));
		flist.add(new FLayer("Entity", "Entity.ftl", Layer.Model));
		flist.add(new FLayer("add", "jsp/add.ftl", Layer.View));
		flist.add(new FLayer("edit", "jsp/edit.ftl", Layer.View));
		flist.add(new FLayer("list", "jsp/list.ftl", Layer.View));
		return flist;
	}

	private List<FLayer> getDIY() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.entity.fr.FRBase#dependence()
	 */
	@Override
	public List<FLayer> dependence() {
		if (isDefault) {
			return getDefault();
		} else {
			return getDIY();
		}
	}

}
