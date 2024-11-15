package com.stp.metrics;

import java.util.ArrayList;
import java.util.List;

public class Runner13 {

    public static double lowLevelModulesCount(){
        Integer n2 = 8;
        double k = n2/8;
        return k;
    }

    public static Integer PSlevelCounter(double n2){
        double i = (Math.log(n2)/3)+1;
        return (int)i;
    }

    public static Integer KCounter(double n2, Integer i){
        double K = 0.0;
        for (int j = 1; j <= i-1; j++){
            K += (n2)/(Math.pow(8, j));
        }
        return (int)K+1;
    }

    public static double nk2Counter(double n2){
        double n2k = n2 * Math.log(n2);
        return n2k;
    }

    public static double NkCounter(double n2, double n2k){
        double Nk = 2 * n2k * Math.log(n2k);
        return Nk;
    }

    public static double NCounter(Integer K, double n2, double Nk){
        double N = K * Nk;
        return N;
    }

    public static double VPSCounter(Integer K, double Nk, double n2k){
        double V = K * Nk * Math.log(2 * n2k);
        return V;
    }

    public static double PPSCounter(double N){
        double P = ((double) 3 /8)*N;
        return P;
    }

    public static double TkCounter(double N, double n, double v){
        double Tk = (3 * N)/(8 * n * v);
        return Tk;
    }

    public static double B0Counter(double V){
        double B0 = V/3000;
        return B0;
    }

    public static double tnCounter(double tyau, double B0){
        double tn = tyau/(Math.log(B0));
        return tn;
    }

    public static void main(String[] args) {
        double n = 5;
        double v = 20;
        double tyau = 0.5;

        List<Double> n2s = new ArrayList<>(List.of(300.0, 400.0, 512.0));

        for (var it : n2s){
            Integer i = PSlevelCounter(it);
            Integer K = KCounter(it, i);
            double n2k = nk2Counter(it);
            double Nk = NkCounter(it, n2k);
            double N = NCounter(K, it, Nk);
            double V = VPSCounter(K, Nk, n2k);
            double P = PPSCounter(N);
            double Tk = TkCounter(N, n, v);
            double B0 = B0Counter(V);
            double tn = tnCounter(tyau, B0);

            System.out.println("For n2* = " + it);
            System.out.println("i = " + i);
            System.out.println("K = " + K);
            System.out.println("n2k = " + n2k);
            System.out.println("Nk = " + Nk);
            System.out.println("N = " + N);
            System.out.println("V = " + V);
            System.out.println("P = " + P);
            System.out.println("Tk = " + Tk);
            System.out.println("B0 = " + B0);
            System.out.println("tn = " + tn);
            System.out.println("//////////////////////");
        }
    }
}
