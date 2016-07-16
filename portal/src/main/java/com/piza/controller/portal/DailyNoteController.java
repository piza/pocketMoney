package com.piza.controller.portal;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.piza.enums.ErrorTypeEnum;
import com.piza.enums.IndexTypeEnum;
import com.piza.enums.NormalStatusEnum;
import com.piza.events.AddIndexEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.piza.bean.PagingProperties;

import com.piza.model.DailyNote;
import com.piza.model.DailyNoteExample;
import com.piza.service.DailyNoteService;
import com.piza.validator.DailyNoteValidator;



@Controller
@RequestMapping("/dailyNote")
public class DailyNoteController extends BaseController {

    @Autowired
    private DailyNoteService dailyNoteService;
    @Autowired
    private ApplicationContext applicationContext;

    @InitBinder(value = "dailyNote")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new DailyNoteValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody DailyNote dailyNote, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        dailyNoteService.insert(dailyNote);
        AddIndexEvent addIndexEvent=new AddIndexEvent(this);
        addIndexEvent.setIndexTypeEnum(IndexTypeEnum.DB_DATA);
        addIndexEvent.setDbId(dailyNote.getId());
        addIndexEvent.setType("dailyNote");
        addIndexEvent.setTextContent(dailyNote.getContent());
        applicationContext.publishEvent(addIndexEvent);
        return successResult(dailyNote);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        DailyNote delete = new DailyNote();
        delete.setId(id);
        delete.setStatus(NormalStatusEnum.DELETED.getValue());
        dailyNoteService.updateByPrimaryKeySelective(delete);
        return successResult("Ok");
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        DailyNoteExample exam = new DailyNoteExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(dailyNoteService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<DailyNote> list = dailyNoteService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(dailyNoteService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody DailyNote dailyNote, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        dailyNoteService.updateByPrimaryKeySelective(dailyNote);
        return successResult("ok");
    }

}
