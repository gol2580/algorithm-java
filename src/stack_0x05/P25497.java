package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int cnt =0; int in=0;
        String str = br.readLine();
        for(int i=0;i<n;i++) {
            if(str.charAt(i)-'0'>=1 && str.charAt(i)-'0'<=9) {
                cnt++;
            } else if(str.charAt(i)=='L') {
                stack.push('L');
            } else if(str.charAt(i)=='R') {
                in = stack.search('L');
                if(in!=-1) {
                    stack.remove(stack.size()-in);
                    cnt++;
                } else {
                    break;
                }
            } else if(str.charAt(i)=='S') {
                stack.push('S');
            } else if(str.charAt(i)=='K') {
                in = stack.search('S');
                if(in!=-1) {
                    stack.remove(stack.size()-in);
                    cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
