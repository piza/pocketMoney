package com.piza.controller.portal;

import com.piza.bean.ErrorBean;
import com.piza.bean.PagingProperties;
import com.piza.enums.ErrorTypeEnum;

import java.util.HashMap;
import java.util.Map;


public class BaseController{

	protected  Map<String,Object> successResult(Object value){
		
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("success", value);
		return result;
	}
	
	protected  Map<String,Object> successPageList(PagingProperties pageInfo,Object list){
		
		Map<String,Object> result=new HashMap<String,Object>();
		Map<String,Object> pageListMap=new HashMap<String,Object>();
		pageListMap.put("pagingInfo", pageInfo);
		pageListMap.put("models", list);
		result.put("success", pageListMap);
		return result;
	}


    protected  Map<String,Object> failedResult(ErrorTypeEnum errorType,String value){
			
        Map<String,Object> result=new HashMap<String,Object>();
        ErrorBean errorBean=new ErrorBean();
        errorBean.setErrorType(errorType.getValue());
        errorBean.setErrorMesg(value);
        result.put("failed",errorBean );
        return result;
    }
}
