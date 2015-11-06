package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.RoleMapper;
import com.piza.model.Role;
import com.piza.model.RoleExample;
import com.piza.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleExample, Integer> implements RoleService {

@Autowired
public void setBaseMapper(RoleMapper mapper) {
this.baseMapper = mapper;
}
}
