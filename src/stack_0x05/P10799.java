package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(') {stack.push('(');}
            else {
                if(str.charAt(i-1)=='(') { //레이저인경우
                    // 현재 스택의 길이만큼 +
                    stack.pop();
                    result+=stack.size();
                }
                else { //막대기인경우
                    // 끝난 막대기 개수만큼 +
                    stack.pop();
                    result+=1;
                }
            }
        }
        System.out.println(result);
    }
}
