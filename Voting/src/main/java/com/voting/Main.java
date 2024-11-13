package com.voting;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Choice:\n 1.Yes\n 2.No\n 3.Abstained");
            int val = scanner.nextInt();
            scanner.nextLine(); // consume newline

            while (val < 1 || val > 3) {
                System.out.println("Wrong input");
                val = scanner.nextInt();
                scanner.nextLine(); // consume newline
            }

            vote(name, val, server);
        }
    }

    public static void vote(String name, int vote, Server server) {
        BigInteger rnd = new BigInteger(512, random);
        BigInteger n = rnd.shiftLeft(512).or(BigInteger.valueOf(vote));
        System.out.println("Generated n for " + name + ": " + n);

        BigInteger r = Crypto.getCoprime(server.N);
        System.out.println("Generated r for " + name + ": " + r);

        BigInteger h = server.getHash(n);
        System.out.println("Hash for " + name + ": " + h);

        BigInteger encodedH = h.multiply(r.modPow(server.D, server.N)).mod(server.N);
        System.out.println("Encoded hash for " + name + ": " + encodedH);

        BigInteger encodedS = server.getBlank(name, encodedH);
        if (encodedS.equals(BigInteger.valueOf(-1))) {
            return;
        }

        BigInteger s = encodedS.multiply(Crypto.inverse(r, server.N)).mod(server.N);
        System.out.println("Decoded s for " + name + ": " + s);

        server.sendBlank(name, n, s);
    }
}