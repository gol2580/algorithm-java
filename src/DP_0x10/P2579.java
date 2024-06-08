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
        int[] s = new int[305]; int[] d = new int[305];
        int total = 0;
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(br.readLine());
            total+=s[i];
        }
        // d[k][1] = Math.max(d[k-2][1], d[k-2][2]) + s[k]
        // d[k][2] = d[k-1][1] + s[k]
        if(n<=2) {
            System.out.println(total);
            return;
        }
        d[1]= s[1];
        d[2] = s[2];
        d[3]= s[3];
        for (int i = 4; i <= n-1 ; i++) d[i] = Math.min(d[i-2],d[i-3])+s[i];
        System.out.println(total-Math.min(d[n-1],d[n-2]));
    }
}
