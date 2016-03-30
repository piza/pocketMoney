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

import com.piza.model.WeixinAccount;
import com.piza.model.WeixinAccountExample;
import com.piza.service.WeixinAccountService;
import com.piza.validator.WeixinAccountValidator;



@Controller
@RequestMapping("/weixinAccount")
public class WeixinAccountController extends BaseController {

    @Autowired
    private WeixinAccountService weixinAccountService;

    @InitBinder(value = "weixinAccount")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new WeixinAccountValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody WeixinAccount weixinAccount, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        weixinAccountService.insert(weixinAccount);
        return successResult(weixinAccount);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        WeixinAccount delete = new WeixinAccount();
        delete.setId(id);
        delete.setStatus(NormalStatusEnum.DELETED.getValue());
        weixinAccountService.updateByPrimaryKeySelective(delete);
        return successResult("Ok");
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        WeixinAccountExample exam = new WeixinAccountExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(weixinAccountService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<WeixinAccount> list = weixinAccountService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(weixinAccountService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody WeixinAccount weixinAccount, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        weixinAccountService.updateByPrimaryKeySelective(weixinAccount);
        return successResult("ok");
    }

}
