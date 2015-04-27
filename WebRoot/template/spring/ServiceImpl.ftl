/**
 * ACF
 * Create By ${author}
 * ${createDate}
 * 
 */
package org.app.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.app.cms.dao.AccountDao;
import org.app.cms.model.AccountEntity;
import org.app.cms.service.AccountService;
import org.app.core.common.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;


	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#find(java.io.Serializable)
	 */
	@Override
	public AccountEntity find(Serializable id) {
		// TODO Auto-generated method stub
		return accountDao.find(id);
	}

	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#findAll()
	 */
	@Override
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		accountDao.deleteEntityById(id);
	}

	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(AccountEntity entity) {
		// TODO Auto-generated method stub
		accountDao.saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(AccountEntity entity) {
		// TODO Auto-generated method stub
		accountDao.update(entity);
	}

	/* (non-Javadoc)
	 * @see org.app.core.service.BaseService#find(org.app.core.common.Filter)
	 */
	@Override
	public AccountEntity find(Filter filter) {
		// TODO Auto-generated method stub
		return accountDao.queryObject(filter);
	}
	
}
