package com.lsh.handler;

import com.lsh.config.ProjectUrlConfig;
import com.lsh.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName SellExceptionHandler
 * @Description: 异常处理
 * @Author lsh
 * @Date 2019/1/2 22:17
 * @Version
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getSell())
                .concat("/sell/wechat/qrAthorize")
                .concat("?returnUrl=")
                .concat("/sell/seller/login"));
    }
}
