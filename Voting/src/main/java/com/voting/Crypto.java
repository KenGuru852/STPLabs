package com.voting;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Crypto {
    private static final SecureRandom random = new SecureRandom();

    public static BigInteger getPrimeInBounds(int bitLength) {
        BigInteger prime;
        do {
            prime = new BigInteger(bitLength, 100, random);
        } while (prime.bitLength() != bitLength);
        return prime;
    }

    public static BigInteger getCoprime(BigInteger n) {
        BigInteger coprime;
        do {
            coprime = new BigInteger(n.bitLength(), random);
        } while (coprime.compareTo(BigInteger.ONE) <= 0 || coprime.compareTo(n) >= 0 || !coprime.gcd(n).equals(BigInteger.ONE));
        return coprime;
    }

    public static BigInteger extendedGCD(BigInteger a, BigInteger b) {
        BigInteger x = BigInteger.ZERO, y = BigInteger.ONE, lastX = BigInteger.ONE, lastY = BigInteger.ZERO, temp;
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger q = a.divide(b);
            BigInteger r = a.mod(b);

            a = b;
            b = r;

            temp = x;
            x = lastX.subtract(q.multiply(x));
            lastX = temp;

            temp = y;
            y = lastY.subtract(q.multiply(y));
            lastY = temp;
        }
        return lastX;
    }

    public static BigInteger inverse(BigInteger n, BigInteger p) {
        BigInteger inv = extendedGCD(n, p);
        if (inv.compareTo(BigInteger.ZERO) < 0) {
            inv = inv.add(p);
        }
        return inv;
    }
}