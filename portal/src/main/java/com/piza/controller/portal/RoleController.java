package com.piza.controller.portal;

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

import com.piza.model.Role;
import com.piza.model.RoleExample;
import com.piza.service.RoleService;
import com.piza.validator.RoleValidator;



@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @InitBinder(value = "role")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new RoleValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody Role role, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleService.insert(role);
        return successResult(role);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        Role delete = new Role();
        delete.setId(id);
        delete.setStatus(NormalStatusEnum.DELETED.getValue());
        roleService.updateByPrimaryKeySelective(delete);
        return successResult("Ok");
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        RoleExample exam = new RoleExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(roleService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<Role> list = roleService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(roleService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody Role role, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        roleService.updateByPrimaryKeySelective(role);
        return successResult("ok");
    }

}
