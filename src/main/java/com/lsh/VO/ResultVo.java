package com.lsh.VO;

import lombok.Data;

/**
 * @ClassName ResultVo
 * @Description: http请求返回的最外层对象
 * @Author lsh
 * @Date 2018/10/7 20:41
 * @Version
 */
@Data
public class ResultVo<T> {
    /**
     * 错误码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

    public ResultVo(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
