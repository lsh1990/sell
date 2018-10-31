package com.lsh.utils.serializer;

import com.lsh.enums.CodeEnum;
import com.lsh.enums.OrderStatusEnum;

/**
 * @ClassName EnumUtil
 * @Description: 枚举工具类，通过Code返回枚举
 * <T extends CodeEnum> 定义泛型的上限
 * enumClass.getEnumConstants() 通过反射取出Enum所有常量的属性值
 * @Author lsh
 * @Date 2018/10/24 21:38
 * @Version
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
