package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean pEnd = true;
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        do {
            String str = br.readLine();
            if (str.equals(".")) { pEnd = false; break; }
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='.') { break; }
                switch (str.charAt(i)) {
                    case '(' :
                        stack.push('(');
                        break;
                    case ')' :
                        if (!stack.isEmpty()) {
                            if (stack.peek() == '(') { stack.pop(); break; }
                            else { result = false; break; }
                        } else {
                            result = false;
                            break;
                        }
                    case '[' :
                        stack.push('[');
                        break;
                    case ']' :
                        if (!stack.isEmpty()) {
                            if (stack.peek() == '[') { stack.pop(); break;}
                            else { result = false; break; }
                        } else {
                            result = false;
                            break;
                        }
                }
            }
            if (result && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            result = true; stack.clear();
        }
        while (pEnd); {}
    }
}

