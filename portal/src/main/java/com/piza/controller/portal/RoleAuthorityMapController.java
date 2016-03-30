package com.piza.controller.portal;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.piza.enums.ErrorTypeEnum;
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

    @InitBinder(value = "roleAuthorityMap")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new RoleAuthorityMapValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody RoleAuthorityMap roleAuthorityMap, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleAuthorityMapService.insert(roleAuthorityMap);
        return successResult(roleAuthorityMap);
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
        if(paging.getNeedPaging()) {
            paging.setTotal(roleAuthorityMapService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<RoleAuthorityMap> list = roleAuthorityMapService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(roleAuthorityMapService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody RoleAuthorityMap roleAuthorityMap, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleAuthorityMapService.updateByPrimaryKeySelective(roleAuthorityMap);
        return successResult("ok");
    }

}
