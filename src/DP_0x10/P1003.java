package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 테이블
        // d[i][2] : fibonacci(i)를 호출했을때 0, 1이 호출되는 횟수
        int[][] d = new int[41][2];

        // 2. 초기값
        d[0][0] = 1; d[0][1] = 0;
        d[1][0] = 0; d[1][1] = 1;
        d[2][0] = 1; d[2][1] = 1;
        d[3][0] = d[2][0]; d[3][1] = d[2][1]+1;

        //3. 점화식
        for (int k = 4; k <= 40; k++) {
            d[k][0] = d[k-1][0] + d[k-2][0];
            d[k][1] = d[k-1][1] + d[k-2][1];
        }

        //4. 출력
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            System.out.println(d[cur][0]+" "+d[cur][1]);
        }
    }
}
