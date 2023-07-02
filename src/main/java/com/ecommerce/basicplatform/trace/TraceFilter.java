package com.ecommerce.basicplatform.trace;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * 生成trace id
 */
@Activate(group = {"provider", "consumer"})
public class TraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext rpcContext = RpcContext.getContext();
        String traceId;
        if (rpcContext.isConsumerSide()){
            traceId = MDC.get("traceId");
            if (null == traceId){
                traceId = UUID.randomUUID().toString();
            }
            rpcContext.setAttachment("traceId",traceId);
        }
        if (rpcContext.isProviderSide()){
            traceId = rpcContext.getAttachment("traceId");
            MDC.put("traceId",traceId);
        }
        return invoker.invoke(invocation);
    }
}
