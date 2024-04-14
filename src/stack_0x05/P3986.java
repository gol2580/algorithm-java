package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int result =0;
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            stack.push(str.charAt(0));
            for(int j=1;j<str.length();j++) {
                if(stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else {
                    if(stack.peek()==str.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
                    }
                }
            }
            if(stack.isEmpty()) {result++;}
            stack.clear();
        }
        System.out.println(result);
    }
}
