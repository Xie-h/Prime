package com;

public interface Prime {

    default boolean isPrime(long num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    long rangeSum(long begin, long end);
}
