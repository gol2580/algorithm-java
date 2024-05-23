package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {
    static int n;
    static StringBuilder sb = new StringBuilder();

    static void func(int a, int b, int c) {
        if(c==1) {
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        func(a,6-a-b,c-1);
        sb.append(a).append(" ").append(b).append('\n');
        func(6-a-b,b,c-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb.append((1<<n)-1).append('\n');
        func(1,3,n);
        System.out.println(sb);
    }
}
