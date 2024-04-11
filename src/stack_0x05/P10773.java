package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result=0;
        for(int i=0;i<n;i++) {
            int k = Integer.parseInt(br.readLine());
            if(k==0) {stack.pop(); continue;}
            stack.add(k);
        }
        Iterator<Integer> iter = stack.iterator();
        while(iter.hasNext()) {result+= iter.next();}
        System.out.print(result);
    }
}
