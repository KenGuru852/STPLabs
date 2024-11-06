package com.stp.tset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TSetTest {

    @Test
    @DisplayName("Проверка инициализации множества, добавления элементов, подсчёта количества элементов")
    public void checkAddElementSize() {

        TSet<Integer> tSet = new TSet<>();

        tSet.getTset().add(5);
        tSet.getTset().add(7);
        tSet.getTset().add(10);

        Integer expected = 3;

        Integer result = tSet.getTset().size();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка подсчёта количества элементов, если множество пустое")
    public void checkSizeZero() {

        TSet<Integer> tSet = new TSet<>();

        Integer expected = 0;

        Integer result = tSet.getTset().size();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка на пустоту, если в множестве есть элементы")
    public void checkIsEmptyFalse() {
        TSet<Double> tSet = new TSet<>();

        tSet.getTset().add(2.34);
        tSet.getTset().add(3.45);
        tSet.getTset().add(4.56);

        boolean result = tSet.getTset().isEmpty();

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Проверка на пустоту, если в множестве нету элементов")
    public void checkIsEmptyTrue() {
        TSet<Long> tSet = new TSet<>();

        boolean result = tSet.getTset().isEmpty();

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка на опустошение элементов из множества")
    public void checkClear() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);

        tset.clear();

        boolean result = tset.isEmpty();

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка принадлежит ли элемент множеству (крайний правый элемент)")
    public void checkContainsRight() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);

        boolean result = tset.contains(7);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка принадлежит ли элемент множеству (крайний левый элемент)")
    public void checkContainsLeft() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);

        boolean result = tset.contains(5);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка принадлежит ли элемент множеству (элемент по середине)")
    public void checkContains() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);
        tset.add(8);

        boolean result = tset.contains(6);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка удаления элемента, если элемент есть в множестве")
    public void checkRemoveHave() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);
        tset.add(8);

        tset.remove(6);

        boolean result = tset.contains(6);

        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Проверка удаления элемента, если элемента нету в множестве")
    public void checkRemoveHaveNot() {
        TSet<Integer> tset = new TSet<>();

        tset.add(5);
        tset.add(6);
        tset.add(7);
        tset.add(8);

        tset.remove(9);

        Integer expected = 4;
        Integer result = tset.size();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка на объединение двух множеств")
    public void checkCombine() {
        TSet<Integer> tset1 = new TSet<>();
        tset1.add(2);
        tset1.add(4);
        tset1.add(6);

        TSet<Integer> tSet2 = new TSet<>();
        tSet2.add(1);
        tSet2.add(2);
        tSet2.add(3);
        tSet2.add(5);
        tSet2.add(7);

        TSet<Integer> combinedTSet = tset1.combine(tSet2);

        Integer expectedSize = 7;
        Integer resultSize = combinedTSet.size();

        Assertions.assertEquals(expectedSize, resultSize);

        boolean result = true;

        for (int i = 1; i < 8; i++) {
            if (!combinedTSet.contains(i)) {
                result = false;
                break;
            }
        }

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка на вытягивание элемента по индексу #1")
    public void checkGetElement1() {
        TSet<Integer> tSet = new TSet<>();
        tSet.add(4);
        tSet.add(13);
        tSet.add(45);
        tSet.add(102);

        Integer expected = 102;
        Integer result = tSet.getElement(3);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка на вытягивание элемента по индексу #2")
    public void checkGetElement2() {
        TSet<Integer> tSet = new TSet<>();
        tSet.add(4);
        tSet.add(13);
        tSet.add(45);
        tSet.add(102);

        Integer expected = 13;
        Integer result = tSet.getElement(1);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка на вытягивание элемента по индексу (исключение на j < 0)")
    public void checkGetElementJLessZero() {
        TSet<Integer> tSet = new TSet<>();
        tSet.add(4);
        tSet.add(13);
        tSet.add(45);
        tSet.add(102);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            tSet.getElement(-1);
        });

        Assertions.assertEquals("Index out of bounds: -1", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка на вытягивание элемента по индексу (исключение на j > размер множества)")
    public void checkGetElementJMoreSetSize() {
        TSet<Integer> tSet = new TSet<>();
        tSet.add(4);
        tSet.add(13);
        tSet.add(45);
        tSet.add(102);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            tSet.getElement(4);
        });

        Assertions.assertEquals("Index out of bounds: 4", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка на вычитание множества")
    public void checkSubtract() {
        TSet<Integer> tSet1 = new TSet<>();
        tSet1.add(1);
        tSet1.add(2);
        tSet1.add(3);
        tSet1.add(4);
        tSet1.add(5);
        tSet1.add(6);
        tSet1.add(7);

        TSet<Integer> tSet2 = new TSet<>();
        tSet2.add(2);
        tSet2.add(4);
        tSet2.add(6);
        tSet2.add(8);

        TSet<Integer> subtracteTSet = tSet1.subtract(tSet2);

        Integer expectedSize = 4;
        Integer resultSize = subtracteTSet.size();

        Assertions.assertEquals(expectedSize, resultSize);

        boolean resultIdentify = true;
        Integer itter = 0;

        for (int i = 1; i < 8; i += 2) {
            if (!subtracteTSet.getElement(itter).equals(i)) {
                resultIdentify = false;
                break;
            } else {
                itter++;
            }
        }

        Assertions.assertTrue(resultIdentify);
    }

    @Test
    @DisplayName("Проверка на умножение множества. Элементов в множестве 9, также здесь есть попытка добавить 2 одинаковых элемента")
    public void checkMultiple() {
        TSet<Integer> tSet1 = new TSet<>();
        tSet1.add(1);
        tSet1.add(2);
        tSet1.add(3);
        tSet1.add(5);
        tSet1.add(7);

        TSet<Integer> tSet2 = new TSet<>();
        tSet2.add(2);
        tSet2.add(4);
        tSet2.add(6);
        tSet2.add(8);
        tSet2.add(9);

        TSet<Integer> multiplyedTSet = tSet1.multiple(tSet2);

        Integer expectedSize = 9;
        Integer resultSize = multiplyedTSet.size();

        Assertions.assertEquals(expectedSize, resultSize);

        boolean resultIdentify = true;

        for (int i = 0; i < 9; i++) {
            if (!multiplyedTSet.contains(i + 1)) {
                resultIdentify = false;
                break;
            }
        }

        Assertions.assertTrue(resultIdentify);
    }
}
