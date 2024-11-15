package com.stp.metrics.algorithms;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleFunctions {

    public static double findN2(double n2, double initialGuess) {
        double n1 = initialGuess;
        double epsilon = 1e-15;
        int maxIterations = 1000;

        for (int i = 0; i < maxIterations; i++) {
            double f = n1 * Math.log(n1) - n2;
            double fPrime = Math.log(n1) + 1;

            double n1New = n1 - f / fPrime;

            if (Math.abs(n1New - n1) < epsilon) {
                return n1New;
            }

            n1 = n1New;
        }

        return n1;
    }

    public static Map.Entry<Integer, Integer> minElement(List<Integer> array) {
        Integer minValue = array.get(0);
        Integer index = 0;

        int curIndex = 0;
        for (Integer it : array) {
            if (it < minValue) {
                minValue = it;
                index = curIndex;
            }
            curIndex++;
        }
        return new AbstractMap.SimpleEntry<>(minValue, index);
        /*return IntStream.range(0, array.size()).boxed().min(Comparator.comparingInt(i -> array.get(i)))
                .map(i -> new AbstractMap.SimpleEntry<>(array.get(i), i))
                .orElseThrow(() -> new IllegalArgumentException("Imbossible To Find"));*/
    }

    public static List<Integer> bubbleSort(List<Integer> array) {
        int n = array.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    // {}, =, size(), ;, for, (), <, -, ++, .get, >, +, .set(), if, !, break, return - операторы
    // 5, 6, 1, 13, 2, 4, 2, 3, 2, 3, 1, 3, 2, 2, 1, 1, 1 = 52
    // array n array.size() swapped i 0 1 j array.get(j) array.get(j+1) temp true false - операнды
    // 2, 3, 1, 4, 4, 2, 5, 9, 2, 3, 2, 1, 1 = 39

    public static int binarySearch(List<Integer> array, int target) {
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // {}, =, 0, .size(), -, while, (), <=, +, /, if, .get(), ==, return, else, < - операторы (16)
    // 5, 5, 1, 1, 3, 1, 4, 1, 1, 1, 2, 2, 1, 2, 2, 1 = 33
    // array, target, left, 0, right, array.size(), 1, mid, 2, array.get(mid), -1 - операнды (11)
    // 1, 3, 5, 1, 4, 1, 3, 4, 1, 2, 1 = 26

    private static class MinElementResult{
        int value;
        int rInd;
        int cInd;
        public MinElementResult(int val, int ri, int ci){
            this.value = val;
            this.rInd = ri;
            this.cInd = ci;
        }
    }

    public static MinElementResult matrixMinElement(List<List<Integer>> matrix){
        int minValue = matrix.get(0).get(0);
        int minRowIndex = 0;
        int minColIndex = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) < minValue) {
                    minValue = matrix.get(i).get(j);
                    minRowIndex = i;
                    minColIndex = j;
                }
            }
        }
        return new MinElementResult(minValue, minRowIndex, minColIndex);
    }

    // {}, =, .get(), ;, for, <, .size(), ++, if, (), return, new - операторы (12)
    // 4, 8, 7, 10, 2, 3, 2, 2, 1, 4, 1, 1 = 45
    // matrix, minValue, matrix.get(0).get(0), 0, minRowIndex, minColIndex, i, matrix.size(), j,
    // matrix.get(i).size(), matrix.get(i).get(i), matrix.get(i).get(j) - операнды (12)
    // 1, 4, 1, 6, 3, 3, 7, 1, 6, 1, 1, 1 = 35

    public static List<Integer> rearrangement(List<Integer> array){
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            int temp = array.get(left);
            array.set(left, array.get(right));
            array.set(right, temp);
            left++;
            right--;
        }
        return array;
    }

    // {}, =, ;, .size(), -, while, (), <, .get(), .set(), ++, --, return - операторы (13)
    // 2, 3, 7, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1 = 24
    // array, left, 0, right, array.size(), 1, temp, array.get(left), array.set(left, array.get(right)), array.set(right, temp) - операнды (10)
    // 2, 5, 1, 5, 1, 1, 2, 1, 1, 1 = 20

    public static List<Integer> moveLeft(List<Integer> array, int toMove){
        int n = array.size();
        toMove = toMove % n;
        if (toMove == 0) {
            return array;
        }
        List<Integer> result = new ArrayList<>(n);
        for (int i = toMove; i < n; i++) {
            result.add(array.get(i));
        }
        for (int i = 0; i < toMove; i++) {
            result.add(array.get(i));
        }
        return result;
    }

    // {}, ==, =, .size(), ;, %, if, (), new, for, <, ++, .add(), .get(), return - операторы (15)
    // 4, 1, 5, 1, 10, 1, 1, 3, 1, 2, 2, 2, 2, 2, 2, 1 = 40
    // array, toMove, n, a.size(), 0, result, i, array.get(i) - операнды (8)
    // 2, 5, 4, 1, 2, 2, 8, 2 = 26

    public static List<Integer> replaceByElement(List<Integer> array, Integer oldValue, Integer newValue){
        List<Integer> result = new ArrayList<>(array);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals(oldValue)) {
                result.set(i, newValue);
            }
        }
        return result;
    }

    // {}, =, new, ;, for, (), <, .size(), ++, if, .get(), .equals(), .set(), return - операторы (14)
    // 3, 2, 1, 5, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1 = 22
    // array, oldValue, newValue, result, ArrayList<>(array), i, 0, result.size(), result.get(i).equals(oldValue) - операнды (9)
    // 2, 2, 2, 2, 1, 5, 1, 1, 1 = 17
    
    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<Integer>(List.of(2, 3, 1, 5, 4, 6));
        List<Integer> test2 = new ArrayList<Integer>(List.of(3, 3, 4, 5, 2, 6));
        List<Integer> test3 = new ArrayList<Integer>(List.of(2, 4, 6, 8, 10, 12));
        Map.Entry<Integer, Integer> resultTest1 = minElement(test1);
        //System.out.println("Result first = " + resultTest1.getKey() + " " + resultTest1.getValue());

        Map.Entry<Integer, Integer> resultTest2 = minElement(test2);
        //System.out.println("Result second = " + resultTest2.getKey() + " " + resultTest2.getValue());

        //List<Integer> testt1 = bubbleSort(test1);
        //List<Integer> testt2 = bubbleSort(test2);

        //System.out.println(testt1.toString());
        //System.out.println(testt2.toString());

        //System.out.println(binarySearch(test3, 6));

/*        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(4, 2, 7));
        matrix.add(List.of(4, 5, 3));
        matrix.add(List.of(9, 1, 6));

        MinElementResult result = matrixMinElement(matrix);
        System.out.println("Value = " + result.value + " Row Index = " + result.rInd + " Col Index = " + result.cInd);*/

        System.out.println(findN2(9, 4));
        System.out.println(5.3602811109788036 * Math.log(5.3602811109788036));
    }

}
