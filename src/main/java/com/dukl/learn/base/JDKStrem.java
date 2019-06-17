package com.dukl.learn.base;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by adu on 2019/6/15.
 */
public class JDKStrem {
    public static void main(String[] args){
        int size = 50000000;
        List<String> uuisList = new ArrayList<>(size);

        //生成500万个uuid
        for (int i = 0; i< size; i++){
            uuisList.add(UUID.randomUUID().toString());
        }
        parallelSorted(uuisList);
        streamSorted(uuisList);
    }

    //并行排序
    public static void parallelSorted(List<String> uuisList){
        System.out.println("开始并行排序");
        long startTime = System.nanoTime();//纳秒，更为精确
        uuisList.parallelStream().sorted().count();//并行排序
        long endTime = System.nanoTime();//纳秒，更为精确
        long distanceTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("结束并行排序 耗时为 " + distanceTime);
    }

    //串行排序
    public static void streamSorted(List<String> uuisList){
        System.out.println("开始串行排序");
        long startTime = System.nanoTime();//纳秒，更为精确
        uuisList.parallelStream().sorted().count();//串行排序
        long endTime = System.nanoTime();//纳秒，更为精确
        long distanceTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("结束串行排序 耗时为 " + distanceTime);
    }
}
