package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.WeixinAccountMapper;
import com.piza.model.WeixinAccount;
import com.piza.model.WeixinAccountExample;
import com.piza.service.WeixinAccountService;

@Service
public class WeixinAccountServiceImpl extends BaseServiceImpl<WeixinAccount, WeixinAccountExample, Integer> implements WeixinAccountService {

@Autowired
public void setBaseMapper(WeixinAccountMapper mapper) {
this.baseMapper = mapper;
}
}
