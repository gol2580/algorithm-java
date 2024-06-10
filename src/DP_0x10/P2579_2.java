package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579_2 {
    public static void main(String[] args) throws IOException {
        int[] step= new int[305];
        int[] dp = new int[305];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) step[i] = Integer.parseInt(br.readLine());
        //default
        dp[1] = step[1];
        if(n>1) dp[2] = step[1] + step[2];
        if(n>2) dp[3] = step[3] + Math.min(step[1], step[2]);

        for (int i = 4; i <= n; i++) dp[i]=step[i] + Math.min(step[i-1]+dp[i-3],dp[i-2] );

        System.out.println(dp[n]);

    }
}
