package com.lsh.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Description: uuid工具类-生成唯一主键
 * @Author lsh
 * @Date 2018/10/13 19:44
 * @Version
 */
public class KeyUtil {

    /**
        * @Description: 生成唯一主键
    	* @Param []
    	* @Return java.lang.String
        * @author lsh
        * @date 2018/10/13 19:47
        */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        //两位随机数
        //Integer a = random.nextInt(90) + 10;
        Integer a = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(a);
    }
}
