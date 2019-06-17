package com.dukl.learn.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adu on 2019/6/15.
 */
public class JavaStreamDemo {
    public static void main(String[] args) {
       /* List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());*/

        //squareNums.forEach(out -> System.out.println(out));


        List<Integer> sourcelist = Arrays.asList(9, 8, 12, 3, 6, 11, 45, 32, 67, 7, 201, 107, 98, 12);

        List<Integer> collect = sourcelist.parallelStream()
              /*  .map(i -> {
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                    return i * 2;
                })*/
                .sorted(Comparator.comparing(Integer::intValue, (x, y) -> {
                            System.out.println(Thread.currentThread().getName() + "---->" + x + "compare" + y);
                            return x - y;
                        }
                ))
                .collect(Collectors.toList());

        collect.forEach(out -> System.out.print(out + ","));

    }
}
