package com.piza.service.impl;

import java.util.List;

import com.piza.dao.BaseMapper;
import com.piza.service.BaseService;

public abstract class BaseServiceImpl<T, E, K> implements BaseService<T, E, K> {
	
	protected BaseMapper<T,E,K> baseMapper;
	
	@Override
	public int countByExample(E e) throws Exception{		
		return baseMapper.countByExample(e);
	}

	@Override
	public void insert(T t) throws Exception {
		baseMapper.insert(t);
		
	}

	@Override
	public void insertSelective(T t) throws Exception {
		baseMapper.insertSelective(t);
		
	}

	@Override
	public void deleteByPrimaryKey(K k) throws Exception {
		baseMapper.deleteByPrimaryKey(k);
		
	}

	@Override
	public void deleteByExample(E e) throws Exception{		
		baseMapper.deleteByExample(e);
	}

	@Override
	public T selectByPrimaryKey(K k) throws Exception {
		return baseMapper.selectByPrimaryKey(k);
	}

	@Override
	public List<T> selectByExample(E e) throws Exception {
		return baseMapper.selectByExample(e);
	}

	@Override
	public void updateByExampleSelective(T t, E e)throws Exception {
		baseMapper.updateByExampleSelective(t, e);
	}

	@Override
	public void updateByExample(T t, E e) throws Exception{
		baseMapper.updateByExample(t, e);
		
	}

	@Override
	public void updateByPrimaryKeySelective(T t) throws Exception{
		baseMapper.updateByPrimaryKeySelective(t);
		
	}

	@Override
	public void updateByPrimaryKey(T t) throws Exception{
		baseMapper.updateByPrimaryKey(t);
		
	}

	public void setBaseMapper(BaseMapper<T, E, K> baseMapper) {
		this.baseMapper = baseMapper;
	}
		
}
