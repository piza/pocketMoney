package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.DailyPictureMapper;
import com.piza.model.DailyPicture;
import com.piza.model.DailyPictureExample;
import com.piza.service.DailyPictureService;

@Service
public class DailyPictureServiceImpl extends BaseServiceImpl<DailyPicture, DailyPictureExample, Integer> implements DailyPictureService {

    @Autowired
    public void setBaseMapper(DailyPictureMapper mapper) {
        this.baseMapper = mapper;
    }
}
