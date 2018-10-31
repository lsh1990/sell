package com.lsh.utils;

import com.lsh.VO.ResultVO;

/**
 * @ClassName ResultVoUtil
 * @Description: 返回结果
 * @Author lsh
 * @Date 2018/10/10 21:27
 * @Version
 */
public class ResultVoUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO(0, "成功",object);
        return resultVo;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
