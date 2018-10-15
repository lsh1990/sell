package com.lsh.exception;

import com.lsh.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description: 异常处理
 * @Author lsh
 * @Date 2018/10/13 14:34
 * @Version
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
