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

import com.piza.model.UserInfo;
import com.piza.model.UserInfoExample;
import com.piza.service.UserInfoService;
import com.piza.validator.UserInfoValidator;



@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @InitBinder(value = "userInfo")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserInfoValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody UserInfo userInfo, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userInfoService.insert(userInfo);
        return successResult(userInfo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        UserInfo delete = new UserInfo();
        delete.setId(id);
        delete.setStatus(NormalStatusEnum.DELETED.getValue());
        userInfoService.updateByPrimaryKeySelective(delete);
        return successResult("Ok");
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        UserInfoExample exam = new UserInfoExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(userInfoService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<UserInfo> list = userInfoService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id,@RequestParam(required = false) String currentToken) {
        if(currentToken!=null){
            UserInfoExample userInfoExample=new UserInfoExample();
            userInfoExample.or().andCurrentTokenEqualTo(currentToken);
            List<UserInfo> userInfoList=this.userInfoService.selectByExample(userInfoExample);
            if(userInfoList.size()>0){
                return successResult(userInfoList.get(0));
            }else{
                return this.failedResult(ErrorTypeEnum.NEED_LOGIN,"请重新登录");
            }
        }
        return successResult(userInfoService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody UserInfo userInfo, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        userInfoService.updateByPrimaryKeySelective(userInfo);
        return successResult("ok");
    }

}
