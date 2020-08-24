package cn.alan.utils;

import cn.alan.common.MyResponseResult;

/**
 * 封装返回JSON的统一消息工具类
 */
public class MyResponseUtils {
    public static <T> MyResponseResult returnSuccess(T data) {

        return new MyResponseResult<T>(200, "success", data);
    }
}
