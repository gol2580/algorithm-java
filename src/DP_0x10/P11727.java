package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //1. 테이블설정
        // d[i] : 2 x i짜리 테이블을 채우는 경우의 수
        int[] d = new int[n+5];

        //2. 초기값 설정
        d[1] = 1;
        d[2] = 3;

        //3. 점화식
        // 0,0에 1x2를 사용한경우 : d[i-1]
        // 2x1을 사용한 경우 : d[i-2]
        // 2x2를 사용한 경우 : d[i-2]
        for (int i = 3; i <= n; i++) d[i] = (d[i-1] + 2*d[i-2])%10007;

        //4. 출력
        System.out.println(d[n]);
    }
}
