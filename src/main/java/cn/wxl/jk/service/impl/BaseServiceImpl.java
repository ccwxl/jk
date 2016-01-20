package cn.wxl.jk.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


import cn.wxl.jk.dao.BaseDao;
import cn.wxl.jk.pagination.Page;
import cn.wxl.jk.service.BaseService;

import javax.annotation.Resource;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> dao;
	private Class<T> clazz;

	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	

	public BaseDao<T> getDao() {
		return dao;
	}


	@SuppressWarnings("unchecked")
	BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	public List<T> findPage(Page page) {
		return dao.findPage(page);
	}

	public List<T> find(Map paraMap) {
		return dao.find(paraMap);
	}

	public T get(Serializable id) {
		return dao.get(id);
	}

	public void insert(T entity) {
		dao.insert(entity);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void deleteById(Serializable id) {
		dao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		dao.delete(ids);
	}

}
