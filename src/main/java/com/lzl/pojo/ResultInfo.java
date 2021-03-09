package com.lzl.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo {

	private Integer code;
	private String msg;
	private Object data;
	/**
     * 成功返回结果
     *
     * @param message
     */
    public static ResultInfo success(String message) {
        return new ResultInfo(200, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param obj
     * @param message
     */
    public static ResultInfo success(String message, Object obj) {
        return new ResultInfo(200, message, obj);
    }

    /**
     * 失败返回结果
     *
     * @param message
     */
    public static ResultInfo error(String message) {
        return new ResultInfo(204, message, null);
    }
    
    /**
     * 失败返回结果
     *
     * @param message
     */
    public static ResultInfo error(Integer code,String message) {
        return new ResultInfo(code, message, null);
    }
    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static ResultInfo error(String message,Object obj) {
        return new ResultInfo(204, message, obj);
    }
}
