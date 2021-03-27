package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	String min = minRemoveToMakeValid("lee(t(c)o)de)");
    System.out.println(min);
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> index = new Stack<Integer>();
        Stack<Character> balance = new Stack<Character>();
        int count = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                balance.push(c);
                index.push(i);
            }
            else {
                if (c ==')' && !balance.empty()) {
                    balance.pop();
                    index.pop();
                }
                else if (c ==')' && balance.empty()){
                    index.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (!index.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
