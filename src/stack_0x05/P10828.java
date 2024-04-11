package stack_0x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[10000];
        int c=0;
        int cnt=0;
        while(n-->0) {
            String inStr = br.readLine();
            if(inStr.charAt(1)=='u') {
                StringTokenizer st = new StringTokenizer(inStr," ");
                inStr = st.nextToken();
                c =  Integer.parseInt(st.nextToken());
            }
            if(inStr.equals("push")) {
                stack[cnt++]=c;
            } else if(inStr.equals("pop")) {
                if(cnt==0) {System.out.println(-1); continue;}
                System.out.println(stack[--cnt]);
            } else if(inStr.equals("size")) {
                System.out.println(cnt);
            } else if(inStr.equals("empty")) {
                if(cnt==0) {System.out.println(1);}
                else {{System.out.println(0);}}
            } else if(inStr.equals("top")) {
                if(cnt==0) {System.out.println(-1); continue;}
                System.out.println(stack[cnt-1]);
            }
        }
    }
}
