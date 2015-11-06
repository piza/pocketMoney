package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.FavoriteSiteMapper;
import com.piza.model.FavoriteSite;
import com.piza.model.FavoriteSiteExample;
import com.piza.service.FavoriteSiteService;

@Service
public class FavoriteSiteServiceImpl extends BaseServiceImpl<FavoriteSite, FavoriteSiteExample, Integer> implements FavoriteSiteService {

@Autowired
public void setBaseMapper(FavoriteSiteMapper mapper) {
this.baseMapper = mapper;
}
}
