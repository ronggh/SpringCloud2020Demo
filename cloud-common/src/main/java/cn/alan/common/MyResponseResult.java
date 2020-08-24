package cn.alan.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public MyResponseResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
