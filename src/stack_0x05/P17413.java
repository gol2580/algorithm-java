package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int in =0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            switch (str.charAt(i)) {
                case '<' :
                    while(!stack.empty()) {sb.append(stack.pop());}
                    in=1;
                    sb.append('<');
                    break;
                case '>' :
                    in=0;
                    sb.append('>');
                    break;
                case ' ' :
                    while(!stack.empty()) {sb.append(stack.pop());}
                    sb.append(' ');
                    break;
                default :
                    if(in==1) {sb.append(str.charAt(i));}
                    else {stack.add(str.charAt(i));}
            }
        }
        if(!stack.empty()) {while(!stack.empty()) {sb.append(stack.pop());}}
        System.out.println(sb);
    }
}
