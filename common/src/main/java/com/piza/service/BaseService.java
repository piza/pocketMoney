package com.piza.service;

import java.util.List;

public interface BaseService<T,E,K> {
	
	int countByExample(E e);
	
	void insert(T t);
	void insertSelective(T t);
	
	void deleteByPrimaryKey(K k);
	void deleteByExample(E e);
	 		
	T  selectByPrimaryKey(K k);
	
	List<T> selectByExample(E e);
		
	void updateByExampleSelective(T t, E e);

    void updateByExample(T t, E e);

    void updateByPrimaryKeySelective(T t);

    void updateByPrimaryKey(T t);
	
	
}
