package com.dukl.learn.ad;

import com.dukl.learn.ad.vo.ChannelBankParamVO;

import java.util.Random;

/**
 * Created by dukangli on 2019/7/3 18:54
 */
public class BaseDataUtils {
    private static String[] bankCodeArray = {"ABOC",
            "BJCN",
            "BKCH",
            "BOJS",
            "BOSH",
            "CIBK",
            "CMBC",
            "COMM",
            "EVER",
            "FJIB",
            "GDBK",
            "GZCB",
            "HZCB",
            "ICBK",
            "MSBC",
            "PCBC",
            "PSBC",
            "SPDB",
            "SZDB",
            "ZJCB"
    };

    private static String[] userArray = {"1716456",
            "1716457",
            "1716458",
            "1716459",
            "1716460",
            "1716461",
            "1716462",
            "1716463",
            "1716464",
            "1716465",
            "1716466",
            "1716467",
            "1716468",
            "1716469",
            "1716470",
            "1716471",
            "1716472",
            "1716473",
            "1716474",
            "1716475"
    };

    public static ChannelBankParamVO randChannelBankParamVO() {
        Random rand = new Random();
        int index = rand.nextInt(userArray.length);
        return new ChannelBankParamVO(userArray[index], bankCodeArray[index%2]);
    }
}
