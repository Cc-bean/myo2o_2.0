package com.yyc.o2o.web.handler;

import com.yyc.o2o.exceptions.ProductOperationException;
import com.yyc.o2o.exceptions.ShopOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @Auther:Cc
 * @Date: 2020/03/27/9:00
 */
//对spring容器扫描到的controller进行拦截
@ControllerAdvice//该类会被植入所有被spring管理的controller中
public class GlobalExceptionHandler {
    //将controller中的错误捕获异常打印到日志
    private final static Logger LOG= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //指定要统一处理的异常
    @ExceptionHandler(value = Exception.class)
    //遇到指定异常时返回前端指定信息
    @ResponseBody
    public Map<String,Object> handle(Exception e){
        Map<String,Object> modleMap=new HashMap<String, Object>();
        modleMap.put("success",false);
        if(e instanceof ShopOperationException){
            modleMap.put("errMsg",e.getMessage());
        }else if(e instanceof ProductOperationException){
            modleMap.put("errMsg",e.getMessage());
        }else {//其他异常
            LOG.error("系统出现异常",e.getMessage());
            modleMap.put("errMsg","未知错误，请联系工作人员进行解决");
        }
        return modleMap;
    }





}
