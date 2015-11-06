package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.AuthorityMapper;
import com.piza.model.Authority;
import com.piza.model.AuthorityExample;
import com.piza.service.AuthorityService;

@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, AuthorityExample, Integer> implements AuthorityService {

@Autowired
public void setBaseMapper(AuthorityMapper mapper) {
this.baseMapper = mapper;
}
}
