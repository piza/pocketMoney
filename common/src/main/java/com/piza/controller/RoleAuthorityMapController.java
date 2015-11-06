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

import com.piza.model.RoleAuthorityMap;
import com.piza.model.RoleAuthorityMapExample;
import com.piza.service.RoleAuthorityMapService;
import com.piza.validator.RoleAuthorityMapValidator;



@Controller
@RequestMapping("/roleAuthorityMap")
public class RoleAuthorityMapController extends BaseController {

    @Autowired
    private RoleAuthorityMapService roleAuthorityMapService;

    @InitBinder(value = "form")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new RoleAuthorityMapValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid RoleAuthorityMap form, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleAuthorityMapService.insert(form);
        return successResult(form);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        RoleAuthorityMap delete = new RoleAuthorityMap();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getValue());
//        roleAuthorityMapService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        RoleAuthorityMapExample exam = new RoleAuthorityMapExample();
        paging.setTotal(roleAuthorityMapService.countByExample(exam));
        exam.setOrderByClause(" id desc " + paging.build());
        List<RoleAuthorityMap> list = roleAuthorityMapService.selectByExample(exam);
        return successResult(list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(roleAuthorityMapService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid RoleAuthorityMap form, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleAuthorityMapService.updateByPrimaryKeySelective(form);
        return successResult(form);
    }

}
