package com.vlsmcalculator.submax.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathOperationTest {

    @Test
    public void log2Test() {
        long res = MathOperations.log2(24);
        System.out.println(res);
        assert res==5;
    }

    @Test
    public void powTest() {
        long res = MathOperations.pow(2,3);
        System.out.println(res);
        assert  res==8;
    }
}
