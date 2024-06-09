package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws IOException {
        int[][] d = new int[1005][3];
        int[] r = new int[1005];
        int[] g = new int[1005];
        int[] b = new int[1005];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        d[1][0] = r[1];
        d[1][1] = g[1];
        d[1][2] = b[1];
        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i-1][1],d[i-1][2]+r[i]);
            d[i][1] = Math.min(d[i-1][0],d[i-1][2]+g[i]);
            d[i][2] = Math.min(d[i-1][0],d[i-1][1]+b[i]);
        }
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]),d[n][2]));
    }
}
