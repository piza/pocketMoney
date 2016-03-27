package com.piza.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.piza.enums.ErrorTypeEnum;
import com.piza.enums.NormalStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.piza.bean.PagingProperties;

import com.piza.model.MemberInfo;
import com.piza.model.MemberInfoExample;
import com.piza.service.MemberInfoService;
import com.piza.validator.MemberInfoValidator;



@Controller
@RequestMapping("/memberInfo")
public class MemberInfoController extends BaseController {

    @Autowired
    private MemberInfoService memberInfoService;

    @InitBinder(value = "memberInfo")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new MemberInfoValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody MemberInfo memberInfo, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        memberInfoService.insert(memberInfo);
        return successResult(memberInfo);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        MemberInfo delete = new MemberInfo();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getValue());
//        memberInfoService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        MemberInfoExample exam = new MemberInfoExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(memberInfoService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<MemberInfo> list = memberInfoService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(memberInfoService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody MemberInfo memberInfo, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        memberInfoService.updateByPrimaryKeySelective(memberInfo);
        return successResult("ok");
    }

}
