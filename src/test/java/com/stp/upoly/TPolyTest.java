package com.stp.upoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TPolyTest {

    @Test
    @DisplayName("Тест на поиск степени/складывания полиномов 1")
    public void getDegreeTest1() {
        TPoly first = new TPoly(1, 0);
        TPoly tPoly = new TPoly(1, 2);
        tPoly.addPolynom(first);

        int expected = 2;
        int result = tPoly.findPolyDegree();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест на поиск степени/складывания полиномов 2")
    public void getDegreeTest2() {
        TPoly tPoly = new TPoly(17, 0);
        tPoly.findPolyDegree();

        int expected = 0;
        int result = tPoly.findPolyDegree();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест на поиск коэффициента при степени, которой нету в полиноме")
    public void getCoeffTest1() {
        TPoly tPoly = new TPoly(1, 3);
        tPoly.addPolynom(new TPoly(2, 1));
        tPoly.addPolynom(new TPoly(1, 0));
        // x^3 + 2x + 1
        int expected = 0;
        int result = tPoly.findPolyCoeff(4);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест на поиск коэффициента при степени, которая есть в полиноме")
    public void getCoeffTest2() {
        TPoly tPoly = new TPoly(1, 3);
        tPoly.addPolynom(new TPoly(2, 1));
        tPoly.addPolynom(new TPoly(1, 0));
        // x^3 + 2x + 1
        int expected = 2;
        int result = tPoly.findPolyCoeff(1);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест на складывание полиномов (в обоих полиномах одинаковые степени)")
    public void addTest1() {
        TPoly leftOperand = new TPoly(3, 2);
        leftOperand.addPolynom(new TPoly(2, 1));
        leftOperand.addPolynom(new TPoly(1, 0));
        // 3x^2 + 2x + 1
        TPoly rightOperand = new TPoly(4, 2);
        rightOperand.addPolynom(new TPoly(-5, 1));
        rightOperand.addPolynom(new TPoly(7, 0));
        // 4x^2 - 5x + 7

        // answer = 7x^2 - 3x + 8
        TPoly expected = new TPoly(7, 2);
        expected.addPolynom(new TPoly(-3, 1));
        expected.addPolynom(new TPoly(8, 0));
        String expString = expected.toString();

        TPoly result = leftOperand.addPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на складывание полиномов")
    public void addTest2() {
        TPoly leftOperand = new TPoly(2, 3);
        leftOperand.addPolynom(new TPoly(3, 2));
        leftOperand.addPolynom(new TPoly(4, 1));
        // 2x^3 + 3x^2 + 4x;
        TPoly rightOperand = new TPoly(5, 4);
        rightOperand.addPolynom(new TPoly(-6, 2));
        rightOperand.addPolynom(new TPoly(7, 0));
        // 5x^4 - 6x^2 + 7

        // answer = 5x^4 + 2x^3 - 3x^2 + 4x + 7
        TPoly expected = new TPoly(5, 4);
        expected.addPolynom(new TPoly(2, 3));
        expected.addPolynom(new TPoly(-3, 2));
        expected.addPolynom(new TPoly(4, 1));
        expected.addPolynom(new TPoly(7, 0));
        String expString = expected.toString();

        TPoly result = leftOperand.addPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на умножение полиномов (простой)")
    public void mulTest1() {
        TPoly leftOperand = new TPoly(3, 2);
        leftOperand.addPolynom(new TPoly(2, 1));
        // 3x^2 + 2x
        TPoly rightOperand = new TPoly(4, 2);
        rightOperand.addPolynom(new TPoly(-7, 0));
        // 4x^2 - 7

        // answer = 12x^4 + 8x^3 - 21x^2 - 14x
        TPoly expected = new TPoly(12, 4);
        expected.addPolynom(new TPoly(8, 3));
        expected.addPolynom(new TPoly(-21, 2));
        expected.addPolynom(new TPoly(-14, 1));
        String expString = expected.toString();

        TPoly result = leftOperand.mulPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на умножение полиномов (сложный)")
    public void mulTest2() {
        TPoly leftOperand = new TPoly(2, 3);
        leftOperand.addPolynom(new TPoly(3, 2));
        leftOperand.addPolynom(new TPoly(4, 1));
        // 2x^3 + 3x^2 + 4x;
        TPoly rightOperand = new TPoly(5, 4);
        rightOperand.addPolynom(new TPoly(-6, 2));
        rightOperand.addPolynom(new TPoly(7, 0));
        // 5x^4 - 6x^2 + 7

        // answer = 10x^7 + 15x^6 + 8x^5 - 18x^4 - 10x^3 + 21x^2 + 28x
        TPoly expected = new TPoly(10, 7);
        expected.addPolynom(new TPoly(15, 6));
        expected.addPolynom(new TPoly(8, 5));
        expected.addPolynom(new TPoly(-18, 4));
        expected.addPolynom(new TPoly(-10, 3));
        expected.addPolynom(new TPoly(21, 2));
        expected.addPolynom(new TPoly(28, 1));
        String expString = expected.toString();

        TPoly result = leftOperand.mulPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на вычитание полиномов (в обоих полиномах одинаковые степени)")
    public void subTest1() {
        TPoly leftOperand = new TPoly(3, 2);
        leftOperand.addPolynom(new TPoly(2, 1));
        leftOperand.addPolynom(new TPoly(1, 0));
        // 3x^2 + 2x + 1
        TPoly rightOperand = new TPoly(4, 2);
        rightOperand.addPolynom(new TPoly(-5, 1));
        rightOperand.addPolynom(new TPoly(7, 0));
        // 4x^2 - 5x + 7

        // answer = -x^2 + 7x - 6
        TPoly expected = new TPoly(-1, 2);
        expected.addPolynom(new TPoly(7, 1));
        expected.addPolynom(new TPoly(-6, 0));
        String expString = expected.toString();

        TPoly result = leftOperand.subPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на вычитание полиномов")
    public void subTest2() {
        TPoly leftOperand = new TPoly(2, 3);
        leftOperand.addPolynom(new TPoly(3, 2));
        leftOperand.addPolynom(new TPoly(4, 1));
        // 2x^3 + 3x^2 + 4x;
        TPoly rightOperand = new TPoly(5, 4);
        rightOperand.addPolynom(new TPoly(-6, 2));
        rightOperand.addPolynom(new TPoly(-10, 1));
        rightOperand.addPolynom(new TPoly(7, 0));
        // 5x^4 - 6x^2 - 10x + 7

        // answer = -5x^4 + 2x^3 + 9x^2 + 14x - 7
        TPoly expected = new TPoly(-5, 4);
        expected.addPolynom(new TPoly(2, 3));
        expected.addPolynom(new TPoly(9, 2));
        expected.addPolynom(new TPoly(14, 1));
        expected.addPolynom(new TPoly(-7, 0));
        String expString = expected.toString();

        TPoly result = leftOperand.subPolynom(rightOperand);
        String resString = result.toString();

        Assertions.assertEquals(expString, resString);
    }

    @Test
    @DisplayName("Тест на минус полином")
    public void minusTest1() {
        TPoly tPoly = new TPoly(-2, 3);
        tPoly.addPolynom(new TPoly(3, 2));
        tPoly.addPolynom(new TPoly(-4, 1));
        // -2x^3 + 3x^2 - 4x;
        TPoly expected = new TPoly(2, 3);
        expected.addPolynom(new TPoly(-3, 2));
        expected.addPolynom(new TPoly(4, 1));

        String exp = expected.toString();
        String res = tPoly.minusPolinom().toString();

        Assertions.assertEquals(exp, res);
    }

    @Test
    @DisplayName("Тест на равенство полиномов")
    public void isEqualTest() {
        TPoly tPoly = new TPoly(-2, 3);
        tPoly.addPolynom(new TPoly(3, 2));
        tPoly.addPolynom(new TPoly(-4, 1));
        // -2x^3 + 3x^2 - 4x;
        TPoly tPoly1 = new TPoly(-2, 3);
        tPoly1.addPolynom(new TPoly(3, 2));
        tPoly1.addPolynom(new TPoly(-4, 1));

        Assertions.assertTrue(tPoly.isEqual(tPoly1));
    }

    @Test
    @DisplayName("Тест на дифференцирование полинома")
    public void diffTest1(){
        TPoly tPoly = new TPoly(2, 3);
        tPoly.addPolynom(new TPoly(3, 2));
        tPoly.addPolynom(new TPoly(-4, 1));
        tPoly.addPolynom(new TPoly(7, 0));
        // 2x^3 + 3x^2 - 4x + 7;

        // answer = 6x^2 + 6x^1 - 4
        TPoly expected = new TPoly(6, 2);
        expected.addPolynom(new TPoly(6, 1));
        expected.addPolynom(new TPoly(-4, 0));

        TPoly result = tPoly.diffPoly();

        String exp = expected.toString();
        String res = result.toString();

        Assertions.assertEquals(exp, res);
    }

    @Test
    @DisplayName("Тест на вычисление полинома")
    public void calculateTest1(){
        TPoly tPoly = new TPoly(3, 2);
        tPoly.addPolynom(new TPoly(-4, 1));
        tPoly.addPolynom(new TPoly(7, 0));
        // 3x^2 - 4x + 7 (x = 3);

        // 3*9 - 4*3 + 7 = 27 - 12 + 7 = 22
        int expected = 22;
        int result = tPoly.calculate(3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест на поиск элемента")
    public void foundByIndTest(){
        TPoly tPoly = new TPoly(3, 2);
        tPoly.addPolynom(new TPoly(7, 0));
        tPoly.addPolynom(new TPoly(-4, 1));

        TMember expected1 = new TMember(3, 2);
        TMember expected2 = new TMember(-4, 1);
        TMember expected3 = new TMember(7, 0);

        TMember result1 = tPoly.foundByInd(0);
        TMember result2 = tPoly.foundByInd(1);
        TMember result3 = tPoly.foundByInd(2);

        boolean res1 = expected1.isEqual(result1);
        boolean res2 = expected2.isEqual(result2);
        boolean res3 = expected3.isEqual(result3);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertTrue(res3);
    }
}