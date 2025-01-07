package com.degressly.proxy.downstream.context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class GlobalTraceIdContext {
    private GlobalTraceIdContext() {
        throw new UnsupportedOperationException("Utility class - no instantiation allowed");
    }

    private static String globalTraceId;

    public static synchronized void setGlobalTraceId(String traceId) {
        log.debug("Setting global traceId to: {}", traceId);
        globalTraceId = traceId;
    }

    public static synchronized void unsetGlobalTraceId() {
        log.debug("Unsetting global traceId (was: {})", globalTraceId);
        globalTraceId = null;
    }

    public static synchronized String getGlobalTraceId() {
        return globalTraceId;
    }
}
