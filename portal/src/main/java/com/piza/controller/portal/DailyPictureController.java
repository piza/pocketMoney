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

import com.piza.model.DailyPicture;
import com.piza.model.DailyPictureExample;
import com.piza.service.DailyPictureService;
import com.piza.validator.DailyPictureValidator;



@Controller
@RequestMapping("/dailyPicture")
public class DailyPictureController extends BaseController {

    @Autowired
    private DailyPictureService dailyPictureService;

    @InitBinder(value = "dailyPicture")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new DailyPictureValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@Valid @RequestBody DailyPicture dailyPicture, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        dailyPictureService.insert(dailyPicture);
        return successResult(dailyPicture);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Map<String, Object> delete(@PathVariable("id") Integer id) {
//        DailyPicture delete = new DailyPicture();
//        delete.setId(id);
//        delete.setStatus(NormalStatusEnum.DELETED.getValue());
//        dailyPictureService.updateByPrimaryKeySelective(delete);
//        return successResult("Ok");
//    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(PagingProperties paging) {
        DailyPictureExample exam = new DailyPictureExample();
        if(paging.getNeedPaging()) {
            paging.setTotal(dailyPictureService.countByExample(exam));
            exam.setOrderByClause(" id desc " + paging.build());
        }
        List<DailyPicture> list = dailyPictureService.selectByExample(exam);
        return successPageList(paging,list);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get(@PathVariable("id") Integer id) {
        return successResult(dailyPictureService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@PathVariable("id") Integer id, @Valid @RequestBody DailyPicture dailyPicture, BindingResult result) {
        if (result.hasErrors()) {
            return failedResult(ErrorTypeEnum.VALIDATE_ERROR, result.getAllErrors().get(0).getDefaultMessage());
        }
        dailyPictureService.updateByPrimaryKeySelective(dailyPicture);
        return successResult("ok");
    }

}
