package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1629 {
    // a^b % c
    static BigInteger a,b,c;
    static BigInteger result;

    static BigInteger get(BigInteger A, BigInteger B, BigInteger C) {
        if(B.equals(BigInteger.ONE)) return A.mod(C);
        result  = get(A,B.divide(BigInteger.TEN),C);
        result = result.multiply(result).mod(C);
        if(b.mod(BigInteger.TEN).equals(BigInteger.ZERO)) return result;
        return result.multiply(A).mod(C);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        c = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        get(a,b,c);
        System.out.println(result);
    }
}
