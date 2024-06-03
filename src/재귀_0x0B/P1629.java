package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    // a^b % c
    static long a,b,c;
    static long result;

    static long get(long A, long B, long C) {
        if(B==1) return A%C;

        result = get(A, B/2, C);
        result = result * result % C;

        if(B%2==0) return result;
        return result*A%C;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(get(a,b,c));
    }
}
