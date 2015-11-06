package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.RoleAuthorityMapMapper;
import com.piza.model.RoleAuthorityMap;
import com.piza.model.RoleAuthorityMapExample;
import com.piza.service.RoleAuthorityMapService;

@Service
public class RoleAuthorityMapServiceImpl extends BaseServiceImpl<RoleAuthorityMap, RoleAuthorityMapExample, Integer> implements RoleAuthorityMapService {

@Autowired
public void setBaseMapper(RoleAuthorityMapMapper mapper) {
this.baseMapper = mapper;
}
}
