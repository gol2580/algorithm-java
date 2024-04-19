package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P5957 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=5;i>=1;i--) {stack.push(i);}

        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> cStack = new Stack<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(Integer.parseInt(st.nextToken())==1) {
                int d = Integer.parseInt(st.nextToken());
                for(int j=0;j<d;j++) {
                    if(!stack.isEmpty()) {
                        dStack.push(stack.pop());
                    }
                }
            } else {
                int d = Integer.parseInt(st.nextToken());
                for(int j=0;j<d;j++) {
                    if(!dStack.isEmpty()) {
                        cStack.push(dStack.pop());
                    }
                }
            }
            if(cStack.size()==n) {break;}
        }
        while(!cStack.isEmpty()) {
            System.out.println(cStack.pop());
        }
    }
}
