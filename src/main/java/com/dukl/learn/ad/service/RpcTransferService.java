package com.dukl.learn.ad.service;

import java.util.Map;

/**
 * Created by dukangli on 2019/6/17 15:28
 */
public interface RpcTransferService {
    <T> T rpcTransferRequest(String url, Map<String, Object> paramsMap, Class<T> tClass);

    <K, T> T rpcTransferCommonRequest(String url, K k, Class<T> responseClass);
}
