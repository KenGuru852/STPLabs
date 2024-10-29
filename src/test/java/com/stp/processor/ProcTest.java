package com.stp.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcTest {

    @Test
    public void sqrFuncTest(){

        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setRop(25);
        TFunc sqrFunc = new TFunc();
        sqrFunc.setFunction("Sqr");

        integerTProc.performFunction(sqrFunc);

        Integer expected1 = 5;
        Integer result1 = integerTProc.getRop();
        Assertions.assertEquals(expected1, result1);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setRop(65.61);

        doubleTProc.performFunction(sqrFunc);

        Double expected2 = 8.1;
        Double result2 = doubleTProc.getRop();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void revFuncTest(){

        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setRop(5);
        TFunc revFunc = new TFunc();
        revFunc.setFunction("Rev");

        integerTProc.performFunction(revFunc);

        Integer expected1 = -5;
        Integer result1 = integerTProc.getRop();
        Assertions.assertEquals(expected1, result1);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setRop(7.7);

        doubleTProc.performFunction(revFunc);

        Double expected2 = -7.7;
        Double result2 = doubleTProc.getRop();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void resetProcTest(){
        TProc<Integer> integerTProc = new TProc<>();

        integerTProc.setLop_Res(5);
        integerTProc.setRop(3);
        integerTProc.setOper("Mul");

        integerTProc.resetProc();

        Integer expected1 = 0;
        Integer result1 = integerTProc.getLop_Res();

        Integer expected2 = 0;
        Integer result2 = integerTProc.getRop();

        String expected3 = "None";
        String result3 = integerTProc.getOper();

        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
        Assertions.assertEquals(expected3, result3);
    }

    @Test
    public void getOpeeationtest(){
        TProc<Long> longTProc = new TProc<>();
        longTProc.setOper("Add");

        String expected = "Add";
        String result = longTProc.getOper();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addOperationTest(){
        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setLop_Res(3);
        integerTProc.setRop(5);
        integerTProc.setOper("Add");

        integerTProc.performOperation();

        Integer expected = 8;
        Integer result = integerTProc.getLop_Res();
        Assertions.assertEquals(expected, result);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setLop_Res(14.6);
        doubleTProc.setRop(7.6);
        doubleTProc.setOper("Add");

        doubleTProc.performOperation();

        Double expected2 = 22.2;
        Double result2 = doubleTProc.getLop_Res();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void subOperationTest(){
        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setLop_Res(3);
        integerTProc.setRop(5);
        integerTProc.setOper("Sub");

        integerTProc.performOperation();

        Integer expected = -2;
        Integer result = integerTProc.getLop_Res();
        Assertions.assertEquals(expected, result);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setLop_Res(14.6);
        doubleTProc.setRop(7.5);
        doubleTProc.setOper("Sub");

        doubleTProc.performOperation();

        Double expected2 = 7.1;
        Double result2 = doubleTProc.getLop_Res();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void mulOperationTest(){
        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setLop_Res(-3);
        integerTProc.setRop(5);
        integerTProc.setOper("Mul");

        integerTProc.performOperation();

        Integer expected = -15;
        Integer result = integerTProc.getLop_Res();
        Assertions.assertEquals(expected, result);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setLop_Res(3.5);
        doubleTProc.setRop(2.0);
        doubleTProc.setOper("Mul");

        doubleTProc.performOperation();

        Double expected2 = 7.0;
        Double result2 = doubleTProc.getLop_Res();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void divOperationTest(){
        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setLop_Res(8);
        integerTProc.setRop(4);
        integerTProc.setOper("Div");

        integerTProc.performOperation();

        Integer expected = 2;
        Integer result = integerTProc.getLop_Res();
        Assertions.assertEquals(expected, result);

        TProc<Double> doubleTProc = new TProc<>();
        doubleTProc.setLop_Res(9.3);
        doubleTProc.setRop(3.0);
        doubleTProc.setOper("Div");

        doubleTProc.performOperation();

        Double expected2 = 3.1;
        Double result2 = doubleTProc.getLop_Res();
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    public void combineTest(){
        TProc<Integer> integerTProc = new TProc<>();
        integerTProc.setLop_Res(8);
        integerTProc.setRop(4);
        integerTProc.setOper("Div");
        integerTProc.performOperation(); // 2

        integerTProc.setRop(10);
        integerTProc.setOper("Mul");
        integerTProc.performOperation();

        Integer expected1 = 20;
        Integer result1 = integerTProc.getLop_Res();
        Assertions.assertEquals(expected1, result1);

        integerTProc.setRop(70);
        integerTProc.setOper("Add");
        integerTProc.performOperation();

        Integer expected2 = 90;
        Integer result2 = integerTProc.getLop_Res();
        Assertions.assertEquals(expected2, result2);

        integerTProc.setRop(26);
        integerTProc.setOper("Sub");
        integerTProc.performOperation();

        Integer expected3 = 64;
        Integer result3 = integerTProc.getLop_Res();
        Assertions.assertEquals(expected3, result3);

        TFunc revFunc = new TFunc();
        revFunc.setFunction("Rev");
        TFunc sqrFunc = new TFunc();
        sqrFunc.setFunction("Sqr");

        integerTProc.setRop(integerTProc.getLop_Res());
        integerTProc.performFunction(sqrFunc);

        Integer expected4 = 8;
        Integer result4 = integerTProc.getRop();
        Assertions.assertEquals(expected4, result4);

        integerTProc.performFunction(revFunc);

        Integer expected5 = -8;
        Integer result5 = integerTProc.getRop();
        Assertions.assertEquals(expected4, result4);
    }

    @Test
    public void sampleTest(){
        // 2 + 3 * sqrt(4) = 2 + 3 * 2 = 2 + 6 = 8
        TProc<Integer> temp = new TProc<>();

        TFunc sqrFunc = new TFunc();
        sqrFunc.setFunction("Sqr");

        temp.setRop(4);
        temp.performFunction(sqrFunc);

        temp.setLop_Res(3);
        temp.setOper("Mul");
        temp.performOperation();

        temp.setRop(2);
        temp.setOper("Add");
        temp.performOperation();

        Integer expected = 8;
        Integer result = temp.getLop_Res();
        Assertions.assertEquals(expected, result);
    }
}