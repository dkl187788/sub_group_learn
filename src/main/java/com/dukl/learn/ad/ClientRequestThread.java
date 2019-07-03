package com.dukl.learn.ad;

import com.dukl.learn.ad.service.RpcTransferService;
import com.dukl.learn.ad.vo.ChannelBankParamVO;
import com.dukl.learn.ad.vo.ChannelBankVO;
import com.goldeneggs.common.util.JSONUtil;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by dukangli on 2019/7/3 18:11
 */
public class ClientRequestThread implements Runnable {

    private RpcTransferService rpcTransferService;

    private String threadName;

    private CyclicBarrier cyclicBarrier;

    private ChannelBankParamVO channelBankParamVO;

    private String url = "http://192.168.100.17:7913/xw-pay-gateway/channel/currentMaxLimitChannel";


    public ClientRequestThread(RpcTransferService rpcTransferService, String threadName, CyclicBarrier cyclicBarrier,ChannelBankParamVO channelBankParamVO) {
        this.rpcTransferService = rpcTransferService;
        this.threadName = threadName;
        this.cyclicBarrier = cyclicBarrier;
        this.channelBankParamVO = channelBankParamVO;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(threadName + "准备好等待其它线程");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChannelBankVO channelBankVO = rpcTransferService.rpcTransferCommonRequest(url, channelBankParamVO, ChannelBankVO.class);
        System.out.println(threadName + "--------->" + JSONUtil.toJSONString(channelBankVO));
    }
}
