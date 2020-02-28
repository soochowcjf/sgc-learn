package com.java8.day02;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author:chenjinfeng
 * @date: 2018/8/19
 * @time: 22:35
 * @desc
 */
public class ParallelStream {

    public static long iterativeSum(long l) {
        long sum = 0;
        for (long i = 0; i <= l; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sequentialSum(long l) {
        return Stream.iterate(1L, i -> i + 1L)
                .limit(l)
                .reduce(Long::sum)
                .get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1L)
                .parallel()
                .limit(n)
                .reduce(Long::sum)
                .get();
    }

    public static long rangeSum(long l) {
        return LongStream.rangeClosed(1, l).reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long l) {
        return LongStream.rangeClosed(1, l).parallel().reduce(0L, Long::sum);
    }

    public static long forkJoinCal(long l) {
        long[] numbers = LongStream.rangeClosed(1, l).toArray();
        ForkJoinTask<Long> task = new FrokJoinCalculate(numbers, 0, numbers.length);
        Long result = new ForkJoinPool().invoke(task);
        return result;
    }
}
