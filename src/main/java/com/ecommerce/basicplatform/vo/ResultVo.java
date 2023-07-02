package com.ecommerce.basicplatform.vo;

import com.ecommerce.basicplatform.enums.ResultEnum;
import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * 统一返回对象
 */
@Data
public class ResultVo<T> implements Serializable {
    /**
     * 接口状态（成功、失败）
     */
    private Boolean success;

    /**
     * 返回状态码
     * 00 - 成功
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 终端提示信息
     */
    private String appMsg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 追踪traceId
     */
    private String traceId;

    /**
     * 总数
     */
    private Long totalCount;

    public static ResultVo newSuccessResult(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setSuccess(ResultEnum.SUCCESS.getResult());
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMessage(ResultEnum.SUCCESS.getMsg());
        resultVo.setTraceId(MDC.get("traceId"));
        return resultVo;
    }

    public static ResultVo newFailResult(String errorMsg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(ResultEnum.FAIL.getResult());
        resultVo.setMessage(errorMsg.isBlank() ? ResultEnum.FAIL.getMsg() : errorMsg);
        resultVo.setTraceId(MDC.get("traceId"));
        return resultVo;
    }

    public static ResultVo newFailResult(String errorCode, String errorMsg, String appMsg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(ResultEnum.FAIL.getResult());
        resultVo.setCode(errorCode.isBlank() ? ResultEnum.FAIL.getCode() : errorCode);
        resultVo.setMessage(errorMsg.isBlank() ? ResultEnum.FAIL.getMsg() : errorMsg);
        resultVo.setAppMsg(appMsg.isBlank() ? ResultEnum.FAIL.getMsg() : appMsg);
        resultVo.setTraceId(MDC.get("traceId"));
        return resultVo;
    }

    public static ResultVo newExceptionResult(String errorCode,String errorMsg){
        ResultVo result = new ResultVo();
        result.setCode(errorCode);
        result.setMessage(errorMsg);
        result.setTraceId(MDC.get("traceId"));
        return result;
    }

}
