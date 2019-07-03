package com.dukl.learn.ad;

import com.dukl.learn.ad.service.RpcTransferService;
import com.dukl.learn.ad.service.impl.RpcTransferServiceImpl;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by dukangli on 2019/7/3 18:10
 */
public class MainThreadDemo {
    private final static int THREAD_COUNT = 20;
    private static RpcTransferService rpcTransferService = new RpcTransferServiceImpl();
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
              new Thread(new ClientRequestThread(rpcTransferService,"Test"+i,cyclicBarrier, BaseDataUtils.randChannelBankParamVO())).start();
        }
    }
}
