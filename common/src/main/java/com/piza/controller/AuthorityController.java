package com.piza.controller;

import java.util.Date;
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

import com.piza.model.Authority;
import com.piza.model.AuthorityExample;
import com.piza.service.AuthorityService;
import com.piza.validator.AuthorityValidator;



@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;

    @InitBinder(value = "authority")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new AuthorityValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody Authority authority, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        authority.setCreateDate(new Date());
        authorityService.insert(authority);
        return successResult(authority);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        Authority delete = new Authority();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getValue());
//        authorityService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        AuthorityExample exam = new AuthorityExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(authorityService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<Authority> list = authorityService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(authorityService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody Authority authority, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        authorityService.updateByPrimaryKeySelective(authority);
        return successResult("ok");
    }

}
