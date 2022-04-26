package com.practice.algo.ds;

/**
 "(()()()((()))()())))()()((()()(()())())(((()())()))()())(()(()))((()()()(())((()((())()()((((()()))))))()((()()((()(())))))))(())))(()))))()(()())))()())()))(()(((()))())())()((()()))()())))()))())((()()(())())(()))))())())()()(())(()())())))(((((()(()))))))()))()))(())(())))()())((("
 "01010111111001100101110101010000000011100000000001111110111011001100000011101100101011101011100000000001100001001111001010011110110011100111000101111101100000011111000101001110110000111011110110011101001110101001000111100111101011100101010100110110100100101001011110010010001000001101"
 (
 
 */

public class ValidString {
    
    public static void main(String[] s) {
        boolean b = new ValidString().canBeValid("()()((()))((", "111111101101");
        System.out.println(b);
    }
    
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0) {
            return false;
        }
        int n = s.length();
        return isValid(0, s, locked, n/2, n/2);
    }
    
    public boolean isValid(int i, String s, String locked, int o, int c) {
        if(o == 0 && c == 0) {
            return true;
        }
        if(o > 0 && c == 0) {
            return false;
        }
        if(s.charAt(i) == '(') {
            o--;//0
            if(o < 0 && locked.charAt(i) != '0') {
                return false;
            } else if(o < 0 && locked.charAt(i) == '0') {
                return isValid(i + 1, s, locked, o + 1, c - 1);
            } else if (locked.charAt(i) == '0') {
                return isValid(i + 1, s, locked, o, c) ||  isValid(i+ 1, s, locked, o + 1, c - 1);
            }
        } else {
            c--;//0
            if(o > c && locked.charAt(i) != '0') {
                return false;
            } else if(o > c && locked.charAt(i) == '0') {
                return isValid(i + 1, s, locked, o - 1, c + 1);//5,s,l,0,1
            } else if(locked.charAt(i) == '0') {
                return isValid(i + 1, s, locked, o, c) ||  isValid(i+ 1, s, locked, o - 1, c + 1);
            }
        }
        return isValid(i + 1, s, locked, o, c);//4,s,l,0,0
    }
}
