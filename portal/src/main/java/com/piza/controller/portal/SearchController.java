package com.piza.controller.portal;

import com.piza.bean.PagingProperties;
import com.piza.bean.portal.SearchBean;
import com.piza.model.DailyNote;
import com.piza.model.DailyNoteExample;
import com.piza.util.LuceneUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Peter on 16/7/16.
 */
@Controller
@RequestMapping("/search")
public class SearchController extends BaseController{


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(SearchBean searchBean) {
        List<Map<String,String>> result= LuceneUtil.getInstance().search(null,searchBean.getContent());
        return successResult(result);
    }

}
