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

import com.piza.model.UserLog;
import com.piza.model.UserLogExample;
import com.piza.service.UserLogService;
import com.piza.validator.UserLogValidator;



@Controller
@RequestMapping("/userLog")
public class UserLogController extends BaseController {

    @Autowired
    private UserLogService userLogService;

    @InitBinder(value = "userLog")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserLogValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody UserLog userLog, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userLogService.insert(userLog);
        return successResult(userLog);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        UserLog delete = new UserLog();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getValue());
//        userLogService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        UserLogExample exam = new UserLogExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(userLogService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<UserLog> list = userLogService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(userLogService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody UserLog userLog, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userLogService.updateByPrimaryKeySelective(userLog);
        return successResult("ok");
    }

}
