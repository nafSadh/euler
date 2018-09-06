package com.nafsadh.euler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LargestPrimeFactor {
    
    private List<Long> primes = new ArrayList<>();
    
    public LargestPrimeFactor() {
        primes.add(2L);
        primes.add(3L);
    }
    
    private boolean isPrime(long x) {
        long cap = (long) Math.sqrt(x);
        for (int i = 0; i < primes.size() && primes.get(i) < cap; i++) {
            if (x % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
    
    long getIthPrime(int i) {
        while (i+1 > primes.size()) {
            long x = primes.get(primes.size() - 1) + 2;
            while (!isPrime(x)) {
                x += 2;
            }
            primes.add(x);
        }
        if (i < primes.size()) {
            return primes.get(i);
        } else {
            return -1;
        }
    }
    
    public long largestPrimeFactor(long n) {
        int i = 0;
        long prime = getIthPrime(i);
        long maxPF = prime;
        while (n>=prime && prime>0){
            if(n%prime==0){
                maxPF = prime;
                n=n/prime;
            } else {
                prime = getIthPrime(++i);
            }
        }
        
        return maxPF;
    }
    
    public static void main(String[] args) {
        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(largestPrimeFactor.largestPrimeFactor(n));
        }
    }
}
