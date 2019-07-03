package com.dukl.learn.ad.vo;
import lombok.Data;

/**
 * Created by dukangli on 2019/6/17 14:51
 */

@Data
public class ChannelBankVO {
    private String bcShortCode;

    private Long chbSingleMoneyLimit;

    private Long chbDayMoneyLimit;
}
