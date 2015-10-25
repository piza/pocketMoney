package com.piza.service.impl;

import java.util.List;

import com.piza.dao.BaseMapper;
import com.piza.service.BaseService;

public abstract class BaseServiceImpl<T, E, K> implements BaseService<T, E, K> {
	
	protected BaseMapper<T,E,K> baseMapper;
	
	@Override
	public int countByExample(E e){
		return baseMapper.countByExample(e);
	}

	@Override
	public void insert(T t) {
		baseMapper.insert(t);
		
	}

	@Override
	public void insertSelective(T t) {
		baseMapper.insertSelective(t);
		
	}

	@Override
	public void deleteByPrimaryKey(K k) {
		baseMapper.deleteByPrimaryKey(k);
		
	}

	@Override
	public void deleteByExample(E e) {		
		baseMapper.deleteByExample(e);
	}

	@Override
	public T selectByPrimaryKey(K k) {
		return baseMapper.selectByPrimaryKey(k);
	}

	@Override
	public List<T> selectByExample(E e) {
		return baseMapper.selectByExample(e);
	}

	@Override
	public void updateByExampleSelective(T t, E e){
		baseMapper.updateByExampleSelective(t, e);
	}

	@Override
	public void updateByExample(T t, E e) {
		baseMapper.updateByExample(t, e);
		
	}

	@Override
	public void updateByPrimaryKeySelective(T t) {
		baseMapper.updateByPrimaryKeySelective(t);
		
	}

	@Override
	public void updateByPrimaryKey(T t) {
		baseMapper.updateByPrimaryKey(t);
		
	}

	public void setBaseMapper(BaseMapper<T, E, K> baseMapper) {
		this.baseMapper = baseMapper;
	}
		
}
