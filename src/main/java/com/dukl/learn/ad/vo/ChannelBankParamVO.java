package com.dukl.learn.ad.vo;

import lombok.Data;

/**
 * Created by dukangli on 2019/7/3 18:36
 */
@Data
public class ChannelBankParamVO {
    private String uId;

    private String uaBank;

    public ChannelBankParamVO(String uId, String uaBank) {
        this.uId = uId;
        this.uaBank = uaBank;
    }
}
