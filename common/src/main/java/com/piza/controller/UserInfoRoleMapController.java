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

import com.piza.model.UserInfoRoleMap;
import com.piza.model.UserInfoRoleMapExample;
import com.piza.service.UserInfoRoleMapService;
import com.piza.validator.UserInfoRoleMapValidator;



@Controller
@RequestMapping("/userInfoRoleMap")
public class UserInfoRoleMapController extends BaseController {

    @Autowired
    private UserInfoRoleMapService userInfoRoleMapService;

    @InitBinder(value = "userInfoRoleMap")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserInfoRoleMapValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody UserInfoRoleMap userInfoRoleMap, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userInfoRoleMapService.insert(userInfoRoleMap);
        return successResult(userInfoRoleMap);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        UserInfoRoleMap delete = new UserInfoRoleMap();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getVapwlue());
//        userInfoRoleMapService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        UserInfoRoleMapExample exam = new UserInfoRoleMapExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(userInfoRoleMapService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<UserInfoRoleMap> list = userInfoRoleMapService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(userInfoRoleMapService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody UserInfoRoleMap userInfoRoleMap, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userInfoRoleMapService.updateByPrimaryKeySelective(userInfoRoleMap);
        return successResult("ok");
    }

}
