package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //1. 테이블설정
        //d[i] : i자리수의 이천수의 개수
        long[] d = new long[n+5];

        //2. 초기화
        d[1] = 1; d[0] = 0;
        d[2] = 1;

        /*3. 점화식
        10
        100 101
        1000 1001 1010
        10000 10001 10010 10100 10101
        d[i-1]에 0을 붙이거나 / d[i-2]에 01을 붙이거나 = 피보나치
        */
        for (int i = 3; i <= n; i++) d[i] = d[i-1]+d[i-2];
        // 4. 출력
        System.out.println(d[n]);
    }
}
