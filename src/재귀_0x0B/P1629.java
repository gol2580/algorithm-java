package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1629 {
    // a^b % c
    static long a,b,c;
    static long result;

    static long get(long A, long B, long C) {
        if(b==0) return A%C;

        result = get(A,B/2,C);
        result = result*result%C;

       return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        get(a,b,c);
        System.out.println(result);
    }
}
