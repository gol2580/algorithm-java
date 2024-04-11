package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int in =1; int result=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            int k = Integer.parseInt(br.readLine());
            if(stack.empty()) {
                while(in<=k) {stack.add(in++); sb.append('+');}
                stack.pop(); sb.append('-');
                continue;
            }
            if(k>stack.peek()) {
                while(k>stack.peek()){stack.add(in++); sb.append('+');}
                stack.pop(); sb.append('-');
            } else if(k<stack.peek()) {
                result=1;
                break;
            } else {
                stack.pop(); sb.append('-');
            }
        }
        if(result==1) {
            System.out.println("NO");
        } else {
            for(int i=0;i<sb.length();i++) {
                System.out.println(sb.charAt(i));
            }
        }
    }
}
