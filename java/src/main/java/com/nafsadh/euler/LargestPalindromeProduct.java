package com.nafsadh.euler;

import java.util.Scanner;

/*

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

In this HackerRank Euler+ version: search the largest palindrome which is smaller than a
certain cap.

 */

public class LargestPalindromeProduct {
    private static int T1 = 10;
    private static int T2 = T1*10;
    private static int T3 = T2*10;
    private static int T4 = T3*10;
    private static int T5 = T4*10;
    
    
    static boolean isSixDigitPalindrome(int n){
        return (n/T5==n%10)
                && ((n/T4)%10) == (n/T1)%10
                && ((n/T3)%10) == (n/T2)%10;
    }
    
    static boolean isProductOfTwo3DigitNums(int n){
        for (int a = 100; a <=999; a++) {
            if(n%a==0){
                int b = n/a;
                if(100<= b && b<=999) return true;
            }
        }
        return false;
    }
    
    static int largestPalindromeProdOf6Digit(int cap){
        int x = cap-1;
        while (!(isSixDigitPalindrome(x) && isProductOfTwo3DigitNums(x))) x--;
        return x;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(largestPalindromeProdOf6Digit(n));
        }
    }
}
