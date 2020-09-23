package com;

import org.junit.Test;

public class SingleThreadPrimeTest {

    @Test
    public void testSuccess(){
        // Arrange
        Prime singleThreadPrime = new SingleThreadPrime();
        int begin = 0;
        int end = 100;

        long up = System.currentTimeMillis();
        // Act
        long result = singleThreadPrime.rangeSum(begin, end);

        // Assert
        assert(result == 1060);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }

    @Test
    public void testInputRangeError(){
        // Arrange
        Prime singleThreadPrime = new SingleThreadPrime();
        int begin = 8000;
        int end = 6000;

        long up = System.currentTimeMillis();
        // Act
        long result = singleThreadPrime.rangeSum(begin,end);

        // Assert
        assert(result == 0);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }

    @Test
    public void testInputNegative(){
        // Arrange
        Prime singleThreadPrime = new SingleThreadPrime();
        int begin = 0;
        int end = 100;

        long up = System.currentTimeMillis();
        // Act
        long result = singleThreadPrime.rangeSum(begin, end);

        // Assert
        assert(result == 1060);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }
}
