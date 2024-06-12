package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[10005];
        int mod= 10007;

         //default
        d[1]=1; d[2]=2;

        for (int i = 3; i <= n; i++) d[i] = (d[i-1]+d[i-2])%mod;
        System.out.println(d[n]);
    }
}
