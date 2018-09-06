package com.nafsadh.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LargestPrimeFactor {
    
    private List<Long>         primes = new ArrayList<>();
    private Map<Long, Boolean> isP    = new HashMap<>();
    
    public LargestPrimeFactor() {
        primes.add(2L);
        primes.add(3L);
        isP.put(1L,false );
        isP.put(2L,true);
        isP.put(3L,true );
    }
    
    private boolean isPrime(long x) {
        long cap = (long) Math.sqrt(x);
        for (int i = 0; i < primes.size() && primes.get(i) <= cap; i++) {
            if (x % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPrime2(long x){
        if(isP.containsKey(x)) return isP.get(x);
        if(x%2==0) return false;
        long cap = (long) Math.sqrt(x);
        for (int i = 3; i <= cap; i+=2) {
            if(x%i==0){
                isP.put(x,false );
                return false;
            }
        }
        isP.put(x,true );
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
                while (n%prime==0)n/=prime;
            } else {
                prime = getIthPrime(++i);
            }
        }
        
        return maxPF;
    }
    
    public long largestPrimeFactorFast(long n){
        long maxPrime = 2;
        for(int i = 1; i <= (int) Math.sqrt(n); i++) {
            long mod = n%i;
            if(mod == 0) {
                long div = n/i;
                if(div == i) {
                    if(isPrime2(div)) maxPrime = Math.max(maxPrime, div);
                } else {
                    if(isPrime2(div)) maxPrime = Math.max(maxPrime, div);
                    else if(isPrime2(i)) maxPrime = Math.max(maxPrime, i);
                }
            }
        }
        return maxPrime;
    }
    
    public static void main(String[] args) {
        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(largestPrimeFactor.largestPrimeFactorFast(n));
        }
    }
}
