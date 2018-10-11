package com.lsh.utils;

import com.lsh.VO.ResultVo;

/**
 * @ClassName ResultVoUtil
 * @Description: 返回结果
 * @Author lsh
 * @Date 2018/10/10 21:27
 * @Version
 */
public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo(0, "成功",object);
        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
