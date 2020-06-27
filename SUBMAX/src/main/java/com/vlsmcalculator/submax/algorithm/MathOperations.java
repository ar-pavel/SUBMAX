package com.vlsmcalculator.submax.algorithm;

public class MathOperations {

    public static long log2(long N) {
        long result = (long) (Math.log(N)/Math.log(2)+1e-10);
        if(pow(2L,result) < N)
            ++result;
        return result;
    }
    public static long pow(long base, long power) {
        long result = 1;
        for (long i = 0; i < power; i++)
            result *= base;
        return result;
    }

    public static long preferable(long size) {
        return  Math.max (3L,(long) Math.pow(2L,MathOperations.log2(size+2L)));
    }

    public static long bitReq(long size){
        return log2(size);
    }
}
