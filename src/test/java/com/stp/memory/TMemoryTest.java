package com.stp.memory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TMemoryTest {

    @Test
    public void getSetTest(){
        TMemory<Integer> intNumber = new TMemory<>();

        intNumber.setFNumber((Integer)5);

        Integer expected1 = 5;
        int result1 = intNumber.getFNumber();
        Assertions.assertEquals(expected1, result1);

        TMemory<Double> doubleNumber = new TMemory<>();

        doubleNumber.setFNumber(3.22);

        Double expected2 = 3.22;
        Double result2 = doubleNumber.getFNumber();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void addFNumberTest(){
        TMemory<Integer> intResultNumber = new TMemory<>();
        intResultNumber.setFNumber(5);
        intResultNumber.addFNumber(10);

        TMemory<Integer> intExpectedNumber = new TMemory<>();
        intExpectedNumber.setFNumber(15);
        Assertions.assertEquals(intExpectedNumber.getFNumber(), intResultNumber.getFNumber());

        TMemory<Double> doubleResultNumber = new TMemory<>();
        doubleResultNumber.setFNumber(5.25);
        doubleResultNumber.addFNumber(4.75);

        TMemory<Double> doubleExpectedNumber = new TMemory<>();
        doubleExpectedNumber.setFNumber(10.0);
        Assertions.assertEquals(doubleExpectedNumber.getFNumber(), doubleResultNumber.getFNumber());
    }

    @Test
    public void clearFNumberTest(){
        TMemory<Integer> intResultNumber = new TMemory<>();
        intResultNumber.setFNumber(5);
        intResultNumber.clearFNumber();

        TMemory<Integer> intExpectedNumber = new TMemory<>();
        intExpectedNumber.setFNumber(0);
        Assertions.assertEquals(intExpectedNumber.getFNumber(), intResultNumber.getFNumber());

        TMemory<Double> doubleResultNumber = new TMemory<>();
        doubleResultNumber.setFNumber(3.45);
        doubleResultNumber.clearFNumber();

        TMemory<Double> doubleExpectedNumber = new TMemory<>();
        doubleExpectedNumber.setFNumber(0.0);
        Assertions.assertEquals(doubleExpectedNumber.getFNumber(), doubleResultNumber.getFNumber());
    }

    @Test
    public void returnFStateTest(){
        TMemory<Integer> intNumber = new TMemory<>();

        String intExpected1 = "False";
        String intResult1 = intNumber.returnFState();
        Assertions.assertEquals(intExpected1, intResult1);

        intNumber.setFNumber(5);

        String intExpected2 = "True";
        String intResult2 = intNumber.returnFState();
        Assertions.assertEquals(intExpected2, intResult2);

        intNumber.clearFNumber();

        String intExpected3 = "False";
        String intResult3 = intNumber.returnFState();
        Assertions.assertEquals(intExpected3, intResult3);

        TMemory<Double> doubleNumber = new TMemory<>();

        String doubleExpected1 = "False";
        String doubleResult1 = doubleNumber.returnFState();
        Assertions.assertEquals(doubleExpected1, doubleResult1);

        doubleNumber.setFNumber(9.123);

        String doubleExpected2 = "True";
        String doubleResult2 = doubleNumber.returnFState();
        Assertions.assertEquals(doubleExpected2, doubleResult2);

        doubleNumber.clearFNumber();

        String doubleExpected3 = "False";
        String doubleResult3 = doubleNumber.returnFState();
        Assertions.assertEquals(doubleExpected3, doubleResult3);
    }
}
