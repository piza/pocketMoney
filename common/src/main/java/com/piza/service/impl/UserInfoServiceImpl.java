package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.UserInfoMapper;
import com.piza.model.UserInfo;
import com.piza.model.UserInfoExample;
import com.piza.service.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, UserInfoExample, Integer> implements UserInfoService {

@Autowired
public void setBaseMapper(UserInfoMapper mapper) {
this.baseMapper = mapper;
}
}
