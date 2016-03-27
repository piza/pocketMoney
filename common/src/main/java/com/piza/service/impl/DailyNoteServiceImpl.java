package com.piza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piza.dao.DailyNoteMapper;
import com.piza.model.DailyNote;
import com.piza.model.DailyNoteExample;
import com.piza.service.DailyNoteService;

@Service
public class DailyNoteServiceImpl extends BaseServiceImpl<DailyNote, DailyNoteExample, Integer> implements DailyNoteService {

    @Autowired
    public void setBaseMapper(DailyNoteMapper mapper) {
        this.baseMapper = mapper;
    }
}
