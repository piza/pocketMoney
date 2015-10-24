package com.piza.service;

import java.util.List;

public interface BaseService<T,E,K> {
	
	int countByExample(E e) throws Exception;
	
	void insert(T t) throws Exception;
	void insertSelective(T t) throws Exception;
	
	void deleteByPrimaryKey(K k) throws Exception;
	void deleteByExample(E e) throws Exception;
	 		
	T  selectByPrimaryKey(K k) throws Exception;
	
	List<T> selectByExample(E e) throws Exception;
		
	void updateByExampleSelective(T t, E e) throws Exception;

    void updateByExample(T t, E e) throws Exception;

    void updateByPrimaryKeySelective(T t) throws Exception;

    void updateByPrimaryKey(T t) throws Exception;
	
	
}
