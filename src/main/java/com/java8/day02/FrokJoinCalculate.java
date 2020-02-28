package com.java8.day02;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author:chenjinfeng
 * @date: 2018/8/20
 * @time: 21:49
 * @desc
 */

/**
 * 1.继承RecursiveTask，实现compute()，这种方法有返回值
 * 2.继承RecursiveAction，实现compute()，这种方法没有返回值
 */
public class FrokJoinCalculate extends RecursiveTask<Long> {

    /**
     * 不再将任务分解为子任务的阈值
     */
    public static final long THRESHOLD = 10_000;
    private long[] numbers;
    private int start;
    private int end;

    public FrokJoinCalculate(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * 这个方法里写fork，join逻辑
     */
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0L;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }

        ForkJoinTask<Long> left = new FrokJoinCalculate(numbers, start, length / 2);
        left.fork();

        ForkJoinTask<Long> right = new FrokJoinCalculate(numbers, length / 2, end);
        right.fork();

        return left.join() + right.join();
    }
}
