package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            switch (str.charAt(0)) {
                case '1' :
                    stack.push(str.substring(2));
                    break;
                case '2' :
                    if(!stack.isEmpty()) {sb.append(stack.pop()+"\n");}
                    else {sb.append("-1"+'\n');}
                    break;
                case '3' :
                    sb.append(stack.size()+"\n");
                    break;
                case '4' :
                    if(stack.isEmpty()) {sb.append("1"+'\n');}
                    else {sb.append("0"+'\n');}
                    break;
                case '5' :
                    if(!stack.isEmpty()) {sb.append(stack.peek()+'\n');}
                    else {sb.append("-1"+'\n');}
                    break;
            }
        }
        System.out.println(sb);
    }
}
