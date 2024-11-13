package com.stp.metrics;

import java.util.*;

public class Runner {

    public static int n1;
    public static int n2;
    public static int n;
    public static List<Integer> dict;
    public static int lPractic;
    public static int N1;
    public static int N2;
    public static int N;


    public static void nNumberEnter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n1 number");
        n1 = scanner.nextInt();
        System.out.println("Enter n2 number");
        n2 = scanner.nextInt();
    }

    public static boolean checkIfFilled(){
        for (var it : dict){
            if (it == 0){
                lPractic++;
                return false;
            }
        }
        return true;
    }

    public static void fillDict(){
        Random r = new Random();
        while(!checkIfFilled()){
            int indexToFill = r.nextInt(n);
            dict.set(indexToFill, dict.get(indexToFill) + 1);
        }
    }

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
    
    public static void main(String[] args) {
        while (true) {
            lPractic = 0;
            N1 = 0;
            N2 = 0;
            nNumberEnter();
            System.out.println("n = " + n1 + " + " + n2);
            n = n1 + n2;
            dict = new ArrayList<>(Collections.nCopies(n, 0));
            fillDict();
            for (int i = 0; i < n; i++) {
                if (i < n1){
                    N1 = N1 + dict.get(i);
                }
                else{
                    N2 = N2 + dict.get(i);
                }
                System.out.println("Word #" + i + " = " + dict.get(i) + " times");
            }

            N = N1 + N2;
            System.out.println("\nN = " + N + "; N1 = " + N1 + "; N2 = " + N2 + ";");

            System.out.println("\nPractic L = " + lPractic);

            double lTheory = 0.9 * (n1 + n2) * Math.log(n1 + n2);
            System.out.println("Theory L = " + lTheory);

            double lTheory2 = (n1 * Math.log(n1)) + n2 * Math.log(n2);
            System.out.println("2nd Theory L = " + lTheory2);

            double dispercion = (Math.pow(Math.PI, 2) * Math.pow(n, 2)) / 6;
            System.out.println("\nDispercion = " + dispercion);

            double avgDeviation = Math.sqrt(dispercion);
            System.out.println("Average deviation = " + avgDeviation);

            double relative = 1 / (2 * Math.log(n));
            System.out.println("Relative error = " + relative);

            double n2star = findN2(n2, n2/2);
            System.out.println("\nn2* = " + n2star);

            double checking = n2star * Math.log(n2star);
            System.out.println("Checking = " + checking);
        }
    }
}
