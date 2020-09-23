package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadPrime implements Prime {

    private static int rangeSize = 8;

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(rangeSize, rangeSize, 100000,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(rangeSize));


    @Override
    public long rangeSum(long begin, long end) {
        if (end <= 1 || begin > end) {
            return 0;
        }
        if (begin < 2) {
            begin = 2;
        }
        final long range = (end - begin) / rangeSize;
        try {
            long count = 0;
            List<FutureTask> futureTasks = new ArrayList<>();
            for (int i = 0; i < rangeSize; i++) {
                int index = i;
                long rangeEnd = i == rangeSize - 1 ? end : (index + 1) * range;
                FutureTask<Long> futureTask = new FutureTask<>(() -> new SingleThreadPrime().rangeSum(index * range, rangeEnd));
                executor.submit(futureTask);
                futureTasks.add(futureTask);
            }
            for (FutureTask<Long> task : futureTasks) {
                count += task.get();
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
