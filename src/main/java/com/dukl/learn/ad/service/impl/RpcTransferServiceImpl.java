package com.dukl.learn.ad.service.impl;

import com.alibaba.fastjson.JSON;
import com.dukl.learn.ad.service.RpcTransferService;
import com.dukl.learn.ad.vo.RpcResponseResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldeneggs.common.exception.BusinessException;
import com.goldeneggs.common.util.HttpClientUtil;
import com.goldeneggs.common.util.JSONUtil;
import com.goldeneggs.common.util.NumberUtil;
import com.goldeneggs.common.util.SignatureUtil;
import com.goldeneggs.common.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dukangli on 2019/6/17 15:28
 */
public class RpcTransferServiceImpl implements RpcTransferService {
    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public <K, T> T rpcTransferCommonRequest(String url, K k, Class<T> responseClass) {
        Map<String, Object> paramsMap = formatRequestParam(k);
        return rpcTransferRequest(url, paramsMap, responseClass);
    }

    @Override
    public <T> T rpcTransferRequest(String url, Map<String, Object> paramsMap, Class<T> responseClass) {
        if (StringUtil.isBlank(url) || paramsMap == null) {
            logger.info("调用URL:{},对应参数 paramsMap:{}", url, JSONUtil.toJSONString(paramsMap));
            return null;
        }
        try {
            String mac = SignatureUtil.getSign("test.jindanlicai.com", paramsMap);
            paramsMap.put("mac", mac);
            logger.info("调用URL:{},对应参数 paramsMap:{}", url, JSONUtil.toJSONString(paramsMap));
            String responseResult = HttpClientUtil.post(url, paramsMap);
            logger.info("rpc请求响应结果，responseResult:{}", responseResult);
            return formatResponseResult(responseResult, responseClass);
        } catch (Exception e) {
            logger.info("调用发生异常,异常信息:{}", e);
            throw new BusinessException(e.getMessage());
        }
    }

    private <T> T formatResponseResult(String responseResult, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RpcResponseResultVO rpcResponseResultVO = objectMapper.readValue(responseResult, RpcResponseResultVO.class);
            if (rpcResponseResultVO == null) {
                throw new BusinessException("网络异常，请稍后再试!");
            }
            if (NumberUtil.defaultInt(rpcResponseResultVO.getResponseCode(), 0) != 200) {
                throw new BusinessException(rpcResponseResultVO.getMsg());
            }
            if (rpcResponseResultVO.getData() != null) {
                T resultData;
                if (rpcResponseResultVO.getData() instanceof Map) {
                    resultData = objectMapper.readValue(objectMapper.writeValueAsString(rpcResponseResultVO.getData()), clazz);
                } else {
                    resultData = clazz.newInstance();
                }
                return resultData;
            } else {
                return clazz.newInstance();
            }
        } catch (Exception ex) {
            logger.info("响应结果格式化异常", ex);
            throw new BusinessException("网络异常，请稍后再试!");
        }
    }

    private static <T> Map<String, Object> formatRequestParam(T t) {
        try {
            Map<String, Object> parmMap = JSON.parseObject(JSON.toJSONString(t), HashMap.class);
            return parmMap;
        } catch (Exception ex) {
            throw new BusinessException("数据异常");
        }
    }
}
