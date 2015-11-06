package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.MemberInfoMapper;
import com.piza.model.MemberInfo;
import com.piza.model.MemberInfoExample;
import com.piza.service.MemberInfoService;

@Service
public class MemberInfoServiceImpl extends BaseServiceImpl<MemberInfo, MemberInfoExample, Integer> implements MemberInfoService {

@Autowired
public void setBaseMapper(MemberInfoMapper mapper) {
this.baseMapper = mapper;
}
}
