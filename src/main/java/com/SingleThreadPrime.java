package com;

public class SingleThreadPrime implements Prime {

    @Override
    public long rangeSum(long begin, long end) {
        if (end <= 1 || begin > end) {
            return 0;
        }
        if(begin < 2){
            begin = 2;
        }
        if(begin == end){
            return isPrime(begin) ? begin : 0;
        }

        long count = 0;
        for (long i = begin; i <= end; i++) {
            //当这个数为任何数的次方时判断为非质数
            if (i % (Math.sqrt(i)) == 0) {
                continue;
            }
            if (isPrime(i)) {
                count = count + i;
            }
        }
        return count;
    }

}
