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

import com.piza.model.FavoriteSite;
import com.piza.model.FavoriteSiteExample;
import com.piza.service.FavoriteSiteService;
import com.piza.validator.FavoriteSiteValidator;



@Controller
@RequestMapping("/favoriteSite")
public class FavoriteSiteController extends BaseController {

    @Autowired
    private FavoriteSiteService favoriteSiteService;

    @InitBinder(value = "form")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new FavoriteSiteValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid FavoriteSite form, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        favoriteSiteService.insert(form);
        return successResult(form);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        FavoriteSite delete = new FavoriteSite();
        delete.setId(id);
        delete.setStatus(NormalStatusEnum.DELETED.getValue());
        favoriteSiteService.updateByPrimaryKeySelective(delete);
        return successResult("Ok");
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        FavoriteSiteExample exam = new FavoriteSiteExample();
//        paging.setTotal(favoriteSiteService.countByExample(exam));
//        exam.setOrderByClause(" id desc " + paging.build());
        List<FavoriteSite> list = favoriteSiteService.selectByExample(exam);
        return successResult(list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(favoriteSiteService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid FavoriteSite form, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        favoriteSiteService.updateByPrimaryKeySelective(form);
        return successResult(form);
    }

}
