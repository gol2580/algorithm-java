package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    //테이블
    //d[i][j] : 연속해서 j번 밟았을때, i번째 계단에서 점수의 최댓값, i는 반드시 밟는다
    // -> k는 1, 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[305]; int[][] d = new int[305][3];
        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(br.readLine());
        // d[k][1] = Math.max(d[k-2][1], d[k-2][2]) + s[k]
        // d[k][2] = d[k-1][1] + s[k]
        if(n==1) {
            System.out.println(s[1]);
            return;
        }
        d[1][1]= s[1];
        d[1][2] = 0;
        d[2][1] = s[2];
        d[2][2] = s[1]+s[2];
        for (int i = 3; i <= n ; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]+s[i]);
            d[i][2] = d[i-1][1]+s[i];
        }
        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
