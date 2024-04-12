package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            String result="YES";
            String str = br.readLine();
            for(int j=0;j<str.length();j++) {
                if(str.charAt(j)=='(') {stack.add('(');}
                else {
                    if(stack.empty()) {result="NO"; continue;}
                    stack.pop();
                }
            }
            if(!stack.empty()) {result="NO";}
            System.out.println(result);
            stack.clear();
        }
    }
}
