package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.UserInfoRoleMapMapper;
import com.piza.model.UserInfoRoleMap;
import com.piza.model.UserInfoRoleMapExample;
import com.piza.service.UserInfoRoleMapService;

@Service
public class UserInfoRoleMapServiceImpl extends BaseServiceImpl<UserInfoRoleMap, UserInfoRoleMapExample, Integer> implements UserInfoRoleMapService {

@Autowired
public void setBaseMapper(UserInfoRoleMapMapper mapper) {
this.baseMapper = mapper;
}
}
