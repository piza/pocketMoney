package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.UserLogMapper;
import com.piza.model.UserLog;
import com.piza.model.UserLogExample;
import com.piza.service.UserLogService;

@Service
public class UserLogServiceImpl extends BaseServiceImpl<UserLog, UserLogExample, Integer> implements UserLogService {

@Autowired
public void setBaseMapper(UserLogMapper mapper) {
this.baseMapper = mapper;
}
}
