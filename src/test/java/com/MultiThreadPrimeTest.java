package com;

import org.junit.Test;

public class MultiThreadPrimeTest {

    @Test
    public void testSuccess(){
        // Arrange
        Prime multiThreadPrime = new MultiThreadPrime();
        int begin = 0;
        int end = 100;

        long up = System.currentTimeMillis();
        // Act
        long result = multiThreadPrime.rangeSum(begin, end);

        // Assert
        assert(result == 1060);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }

    @Test
    public void testInputRangeError(){
        // Arrange
        Prime multiThreadPrime = new MultiThreadPrime();
        int begin = 8000;
        int end = 6000;

        long up = System.currentTimeMillis();
        // Act
        long result = multiThreadPrime.rangeSum(begin, end);

        // Assert
        assert(result == 0);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }

    @Test
    public void testInputNegative(){
        // Arrange
        Prime multiThreadPrime = new MultiThreadPrime();
        int begin = -1000;
        int end = 200000;

        long up = System.currentTimeMillis();
        // Act
        long result = multiThreadPrime.rangeSum(begin, end);

        // Assert
        assert(result == 1709600813);
        long down = System.currentTimeMillis();
        System.out.println("spend: " + (down - up));
    }
}
