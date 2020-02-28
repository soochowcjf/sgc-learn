package com.java8.day02;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

/**
 * @author:chenjinfeng
 * @date: 2018/8/19
 * @time: 22:32
 * @desc
 */
public class TestParallelStream {

    /**
     * iterate(),这个方法不能调用并行流操作
     */
    @Test
    public void fun1() {
        Instant start = Instant.now();
        long l = measureSumPerf(ParallelStream::iterativeSum, 10000000000L); //96 24581
//        long l = measureSumPerf(ParallelStream::sequentialSum, 10000000000L); //705
//        long l = measureSumPerf(ParallelStream::parallelSum, 10000000000L); //2600
        Instant end = Instant.now();
        System.out.println("result: " + l + " 耗时：" + Duration.between(start, end).toMillis());

    }

    @Test
    public void fun2() {
        Instant start = Instant.now();
//        long l = measureSumPerf(ParallelStream::iterativeSum, 1000000000L);//80 2594
//        long l = measureSumPerf(ParallelStream::rangeSum, 1000000000);//140 6922
        long l = measureSumPerf(ParallelStream::parallelRangeSum, 1000000000L);//107 4170
        Instant end = Instant.now();
        System.out.println("result: " + l + " 耗时：" + Duration.between(start, end).toMillis());
    }

    /**
     * forkjoin测试
     */
    @Test
    public void fun3() {
        Instant start = Instant.now();
        long l = measureSumPerf(ParallelStream::forkJoinCal, 10_000_000);
        Instant end = Instant.now();
        System.out.println("result: " + l + " 耗时：" + Duration.between(start, end).toMillis());
    }

    /**
     * 测试stream、parallelstream、for循环的耗时
     */
    public long measureSumPerf(Function<Long, Long> function, long n) {
        Long apply = function.apply(n);
        return apply;
    }

    @Test
    public void fun() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
