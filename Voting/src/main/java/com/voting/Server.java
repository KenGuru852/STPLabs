package com.voting;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public BigInteger N;
    public BigInteger D;
    private BigInteger C;
    private Map<String, BigInteger> users;
    private Map<String, Vote> database;

    public Server() {
        BigInteger P = Crypto.getPrimeInBounds(1024);
        BigInteger Q = Crypto.getPrimeInBounds(1024);

        N = P.multiply(Q);
        BigInteger phi = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));

        D = Crypto.getCoprime(phi);
        C = Crypto.inverse(D, phi);

        users = new HashMap<>();
        database = new HashMap<>();
    }

    public BigInteger getBlank(String name, BigInteger userResult) {
        if (users.containsKey(name)) {
            System.out.println(name + " already voted");
            return BigInteger.valueOf(-1);
        }
        users.put(name, userResult);
        BigInteger encodedResult = userResult.modPow(C, N);
        System.out.println("Encoded result for " + name + ": " + encodedResult);
        return encodedResult;
    }

    public void sendBlank(String name, BigInteger n, BigInteger s) {
        BigInteger hash = getHash(n);
        BigInteger calculatedHash = s.modPow(D, N);
        System.out.println("Hash for " + name + ": " + hash);
        System.out.println("Calculated hash for " + name + ": " + calculatedHash);
        if (hash.equals(calculatedHash)) {
            database.put(name, new Vote(n, s));
            System.out.println("n: " + n);
            System.out.println("s: " + s);
            System.out.println("Blank from " + name + " accepted");
        } else {
            System.out.println("n: " + n);
            System.out.println("s: " + s);
            System.out.println("Blank from " + name + " rejected");
            System.out.println("hash: " + hash);
            System.out.println("calc hash: " + calculatedHash);
        }
    }

    public BigInteger getHash(BigInteger num) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(num.toString().getBytes());
            return new BigInteger(1, hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class Vote {
        BigInteger n;
        BigInteger s;

        public Vote(BigInteger n, BigInteger s) {
            this.n = n;
            this.s = s;
        }
    }
}