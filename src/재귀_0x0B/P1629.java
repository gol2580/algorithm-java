package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1629 {
    // a^b % c
    static Long a,b,c;
    static Long result;

    static Long get(Long A, Long B, Long C) {
        if(b==1) return A%C;
        result  = get(A,B/2,C);
        result = result*result%C;
        if(b%2==0) return result;
        return result*A%C;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Long.valueOf(Integer.parseInt(st.nextToken()));
        b = Long.valueOf(Integer.parseInt(st.nextToken()));
        c = Long.valueOf(Integer.parseInt(st.nextToken()));
        get(a,b,c);
        System.out.println(result);
    }
}
