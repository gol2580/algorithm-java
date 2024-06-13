package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579_3 {
    public static void main(String[] args) throws IOException {
        int[] s = new int[305];
        int[][] d = new int[305][3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) s[i] = Integer.parseInt(br.readLine());

        if(n==1) System.out.println(s[1]);
        else {
            d[1][1] = s[1];
            d[1][2] = 0;
            d[2][1] = s[2];
            d[2][2] = s[1]+s[2];
            for (int i = 3; i <= n; i++) {
                d[i][1] = Math.max(d[i-2][1], d[i-2][2]+s[i]);
                d[i][2] = d[i-1][1] + s[i];
            }
            System.out.println(Math.max(d[n][1],d[n][2]));
        }
    }
}
