package com.stp.upoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMemberTest {

    @Test
    @DisplayName("Простейший тест на равенство одночленов")
    public void isEqualTest(){
        TMember firstMem = new TMember(3, 2);
        TMember secondMem = new TMember(3, 2);

        boolean result = firstMem.isEqual(secondMem);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Дифференцирование одночлена со степенью один")
    public void findDiffOneDegree(){
        TMember member = new TMember(3, 1);
        TMember expected = new TMember(3, 0);

        TMember result = member.findDiff();

        boolean isTrue = expected.isEqual(result);

        Assertions.assertTrue(isTrue);
    }

    @Test
    @DisplayName("Дифференцирование одночлена со степенью 0")
    public void findDiffZeroDegree(){
        TMember member = new TMember(4, 0);
        TMember expected = new TMember(0, 0);

        TMember result = member.findDiff();

        boolean isTrue = expected.isEqual(result);

        Assertions.assertTrue(isTrue);
    }

    @Test
    @DisplayName("Дифференцирование одночлена со степенью, отличной от степеней в тестах выше")
    public void findDiffTest(){
        TMember member = new TMember(3, 4);
        TMember expected = new TMember(12, 3);

        TMember result = member.findDiff();

        boolean isTrue = expected.isEqual(result);

        Assertions.assertTrue(isTrue);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью один")
    public void calculateOneDegree(){
        TMember member = new TMember(3, 1);

        int expected = 15;

        int result = member.calculate(5);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью 0")
    public void calculateZeroDegree(){
        TMember member = new TMember(4, 0);

        int expected = 4;

        int result = member.calculate(20);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью, отличной от степеней в тестах выше")
    public void calculateTest(){
        TMember member = new TMember(3, 2);

        int expected = 27;

        int result = member.calculate(3);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью один")
    public void toStringOneDegree(){
        TMember member = new TMember(3, 1);

        String expected = "3x";

        String result = member.toString();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью 0")
    public void toStringZeroDegree(){
        TMember member = new TMember(4, 0);

        String expected = "4";

        String result = member.toString();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Вычисление одночлена со степенью, отличной от степеней в тестах выше")
    public void toStringTest(){
        TMember member = new TMember(3, 2);

        String expected = "3x^2";

        String result = member.toString();

        Assertions.assertEquals(expected, result);
    }
}
