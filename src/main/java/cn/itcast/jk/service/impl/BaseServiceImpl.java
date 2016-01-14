package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.BaseService;

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

	@Override
	public List<T> findPage(Page page) {
		return dao.findPage(page);
	}

	@Override
	public List<T> find(Map paraMap) {
		return dao.find(paraMap);
	}

	@Override
	public T get(Serializable id) {
		return dao.get(id);
	}

	@Override
	public void insert(T entity) {
		dao.insert(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		dao.delete(ids);
	}

}
